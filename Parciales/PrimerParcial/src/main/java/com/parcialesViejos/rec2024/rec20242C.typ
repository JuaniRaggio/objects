= Ejercicio 1

```java

a.m1() = 10;
a.m2() = 10;
a.m3() = 10;

b.m1() = 10;
b.m2() = StackOverflow;
b.m3() = 10;

c.m1() = 20;
c.m2() = 20;
c.m3() = 20;

```


= Ejercicio 2

Biblioteca de videojuegos

- Juegos:

  - Formato fisico: Nombre, Año (int), Nombre de local

  - Formato digital: Nombre, Año (int), almacenamiento

- Agregar videojuego fisico
- Agregar videojuego digital

- Se pide
  - get: Juegos fisicos y digitales ordenados por: Año asc y Nombre dsc
  - get2: Juegos fisicos y digitales ordenados por: Año dsc y Nombre asc

  - Consultar fisicos y digitales en orden de insercion


```java

public abstract class VideoGame implements Comparable<VideoGame> {

  private String name;
  private int year;

  protected VideoGame(String name, int year) {
    this.name = name;
    this.year = year;
  }

  public String toString() {
    return "VG %s launched in %d";
  }

  public int compareTo(VideoGame other) {
    int cmp = year.compareTo(other.year);
    if (cmp == 0) {
      return other.name.compareTo(name);
    }
    return cmp;
  }

}

public class PhysicalGame extends VideoGame {

  private String local;

  public PhisicalGame(String name, int year, String local) {
    super(name, year);
    this.local = local;
  }

  public String toString() {
    return "Physical %s buyed at %s".formatted(super.toString(), local);
  }

}

public class DigitalGame extends VideoGame {

  private double sizeGB;

  public DigitalGame(String name, int year, double sizeGB) {
    super(name, year);
    this.sizeGB = sizeGB;
  }

  public String toString() {
    return "Digital %s of size %g GB".formatted(super.toString(), sizeGB);
  }

}

public class VideoGameLibrary implements Iterable<VideoGame> {

  private static final int BLOCK;
  private VideoGame[] vgs = new VideoGame[BLOCK];
  private int dim = 0;

  private void resize() {
    vgs = Arrays.copyOf(vgs, dim + BLOCK);
  }

  private void addGame(VideoGame vg) {
    if (dim == vgs.length) {
      resize();
    }
    vgs[dim++] = vg;
  }

  public void addPhysicalGame(String name, int year, String local) {
    addGame(new PhysicalGame(name, year, local));
  }

  public void addDigitalGame(String name, int year, double sizeGB) {
    addGame(new DigitalGame(name, year, sizeGB));
  }

  private VideoGame[] getCopy(Comparator<VideoGame> cmp) {
    VideoGame[] cpvgs = Arrays.copyOf(vgs, dim);
    Arrays.sort(cpvgs, cmp);
    return cpvgs;
  }

  public VideoGame[] getAscendingYearCopy() {
    return getCopy(Comparator.naturalOrder());
  }

  public VideoGame[] getDescendingYearCopy() {
    return getCopy(Comparator.reverseOrder());
  }

  public Iterator<VideoGame> iterator() {
    return new Iterator<>() {

      private int i = 0;

      public boolean hasNext() {
        return i < dim;
      }

      public VideoGame next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return vgs[i++];
      }

    }
  }

}

```


= Ejercicio 3 - Raro

Administracion de reservas de un hotel

- Clientes:
  - Reservan en base a un tipo, cant hues y cant noches (verificar no negativos)

=== Tipos de clientes
- Turista: nombre y monto maximo a gastar

- Ejecutivo: nombre y cantidad maxima de reservas (se ignora el costo de cada
reserva)


- Tipos de habitaciones:
  - *simple*: 1hue, 1000/dia
  - *suite*: 4hue max, 3000/dia
  _Caso superar limite_ $->$ error

```java

public enum RoomType {

  SIMPLE(1000, 1), SUITE(3000, 4);

  private int limit, prize;

  private RoomType(int prize, int limit) {
    this.prize = prize;
    this.limit = limit;
  }

  public boolean canAfford(int nights, double moneyLeft) {
    return Double.compare(moneyLeft - prize * nights, 0.0) < 0;
  }

  public double payment(int nights, double moneyLeft) {
    return moneyLeft - prize * nights;
  }

  public boolean canBook(int people) {
    return people > 0 && people <= limit;
  }

}

public abstract class Customer {

  private String name;
  private int bookings;

  protected Customer(String name) {
    this.name = name;
    this.bookings = 0;
  }

  protected abstract boolean canAfford(RoomType type, int nights);

  protected abstract void pay(RoomType type, int nights);

  public void bookRoom(RoomType type, int people, int nights) {
    if (!canAfford(type, nights) || !type.canBook(people) || nights < 0) {
      throw new CannotBookException();
    }
    pay(type, nights);
    bookings++;
  }

  public String toString() {
    return "Client %s made %d bookings".formatted(name, bookings);
  }

}

public class Tourist extends Customer {

  private int moneyLeft;

  public Tourist(String name, double money) {
    super(name);
    moneyLeft = money;
  }

  protected boolean canAfford(RoomType type, int nights) {
    return type.canAfford(nights, moneyLeft);
  }

  protected void pay(RoomType type, int nights) {
    moneyLeft = type.payment(nights, moneyLeft);
  }

}

public class Ejecutive extends Customer {

  private int reservationsAvailable;

  public Ejecutive(String name, int reservations) {
    super(name);
    reservationsAvailable = reservations;
  }

  protected boolean canAfford(RoomType type, int nights) {
    return reservationsAvailable > 0;
  }

  protected void pay(RoomType type, int nights) {
    reservationsAvailable--;
  }
  
}

public class CannotBookException extends Exception {

  private static final String MSG = "Cannot Book";

  public CannotBookException() {
    super(MSG);
  }

}

```

