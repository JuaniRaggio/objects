public class Ej2_5 {
  public static void main(String[] args) {
    // a antes era un entero, y las condiciones tienen que ser booleanas
    // si o si en java
    boolean a = true;
    if (a) { // aca si a no es boolean, falla en tiempo de compilacion
      System.out.println(" ,. ");
    }
  }
}
