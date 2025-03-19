public class Ej2_6 {
    public static void main(String[] args) {
        long x = 3;
        long y = 2;
        long rta;
        rta = sumar(x, y);
        System.out.println(rta);
  }
  // No existia el metodo que recibia dos long
  // aunque quizas seria mas acertado que reciba dos ints pues los datos son
  // muy chicos
  private static long sumar(long a, long b) {
    return a + b;
  }
}
