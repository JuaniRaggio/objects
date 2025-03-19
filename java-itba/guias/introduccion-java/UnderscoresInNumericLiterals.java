public class UnderscoresInNumericLiterals {
  public static void main(String[] args) {
    int dni = 12_345_678;
    double pi = 3.14_16;
    System.out.printf("%.4f", dni + pi);
  }
}
