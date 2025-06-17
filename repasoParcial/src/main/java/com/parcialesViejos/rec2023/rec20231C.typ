= Ejercicio 1

```java

a.m1() = 11;
a.m2() = 11;
a.m3() = 11;

b.m1() = 22;
b.m2() = 22;
b.m3() = 22;

c.m1() = StackOverflow;
c.m2() = StackOverflow;
c.m3() = 33;

```

= Ejercicio 2

```java
public class WordCount {

  private final String word;
  private final int count;

  public WordCount(String word, int count) {
    this.word = word;
    this.count = count;
  }

  public String getWord() {
    return word;
  }

  public int getCount() {
    return count;
  }

  @Override
  public String toString() {
    return "WC: %s -> %d".formatted(word, count);
  }

}

public abstract class WordCountCatalog implements Iterable<WordCount> {

  private static final int BLOCK;
  protected WordCount[] words;
  private int dim;

  protected WordCountCatalog() {
    dim = 0;
    words = new WordCount[BLOCK];
  }

  protected WordCount[] resize(int dim) {
    return Arrays.copyOf(words, dim);
  }

  public WordCountCatalog add(WordCount word) {
    // Recordar .size() no existe en [], es .length
    if (dim == words.length) {
      words = resize(dim + BLOCK);
    }
    words[dim++] = word;
    return this;
  }

  public WordCount getByIndex(int idx) {
    if (idx >= dim || idx < 0) {
      throw new IllegalArgumentException();
    }
    return words[idx];
  }

  protected WordCount[] getSortedWords(Comparator<WordCount> cmp) {
    WordCount[] wc = resize(dim);
    Arrays.sort(wc, cmp);
    return wc;
  }

  protected WordCount[] getSortedWords();

  public Iterator<WordCount> iterator() {
    return new Iterator<>() {

      private int idx;
      private WordCount[] ws = getSortedWords();

      @Override
      public boolean hasNext() {
        return idx < ws.size();
      }

      @Override
      public WordCount next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return ws[idx++];
      }

    }
  }

}

public class AlphabeticalWordCatalog extends WordCountCatalog {

  protected WordCount[] getSortedWords() {
    return getSortedWords((wc1, wc2) -> {
      int cmp = wc1.getWord().compareTo(wc2.getWord());
      if (cmp == 0) {
        cmp = wc1.getCount().compareTo(wc2.getCount());
      }
      return cmp;
    });
  }

}

public class DescendingCountCatalog extends WordCountCatalog {

  protected WordCount[] getSortedWords() {
    return getSortedWords((a, b) -> {
      int cmp = b.getCount().compareTo(a.getCount())
      if (cmp == 0) {
        cmp = b.getWord().compareTo(a.getWord());
      }
      return cmp;
    })
  }

}

```

= Ejercicio 3

Alquiler de bicicletas

== Existen dos tipos de bicicletas:

1. CLASSIC: Cada una cuesta \$100 y *no requisito minimo de cantidad de alq*

2. ELECTRIC: Cuesta \$150 y *se requieren 3 alq*


== Solucion

```java

public enum BikeType {

  CLASSIC(100, 0), ELECTRIC(150, 3);

  private int minimum;
  private double prizePerUnit;

  private BikeType(double prize, int minimumRequired) {
    this.prizePerUnit = prize;
    this.minimum = minimumRequired;
  }

  public double getPrizePerUnit() { return prizePerUnit; }

  public int getMinimumRequired() { return minimum; }

}

public class CannotRideBikeException extends Exception {

  private static final String MSG = "Cannot ride bike";

  public CannotRideBikeException() {
    super(MSG);
  }

}

public abstract class Pass {

  protected int usess = 0;

  protected abstract boolean canAfford(BikeType bike);

  protected boolean canRide(BikeType bike) {
    return usess < bike.getMinumumRequired();
  }

  protected void checkRideStatus(BikeType bike) {
    if (!canRide(bike) || !canAfford()) {
      throw new CannotRideBikeException();
    }
  }

  public void ride(BikeType bike) {
    checkRideStatus(bike);
    usess++;
  }

  public String toString() {
    return "Pass used %d times".formatted(usess);
  }

}

public class MemberPass extends Pass {

  private int balance;
  private String name;

  protected boolean canAfford() {
    return true;
  }

  public void ride(BikeType bike) {
    super.ride(bike);
    balance += bike.getPrize();
  }

  public String toString() {
    return "Member %s for %s with $%d balance".
          formatted(super.toString(), name, balance);
  }

}

public class VisitorPass extends Pass {

  private int maxRides;

  protected boolean canAfford() {
    return usess < maxRides;
  }

  public String toString() {
    return "Visitor %s with max rides %s".formatted(super.toString(), maxRides);
  }

}


```



