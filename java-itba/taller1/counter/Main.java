import java.util.stream.IntStream;

public class Main {
  // No entiendo porque aca si Counter no es static, me tira errores y no me
  // permite crear una instancia de Counter()
  private static class Counter {
    private static int count;

    public Counter() {
      // Las variables static se inicializan en cero como en C?
      count = 0;
    }

    public void increment() {
      count++;
    }

    public void decrement() {
      count--;
    }

    public int get_counter() {
      return count;
    }
  }

  public static void main(String[] args) {
    Counter first_counter = new Counter();
    IntStream.range(0, 5).forEach(i -> {
      int expected;
      first_counter.increment();
      expected = i + 1;
      System.out.println("Current value of counter: " +
        first_counter.get_counter() +
        " expected: " +
        expected);
    });
    IntStream.range(0, 4).forEach(i -> {
      int expected;
      first_counter.decrement();
      expected = 4 - i;
      System.out.println("Current value of counter: " +
        first_counter.get_counter() +
        " expected: " +
        expected);
    });
  }
}
