public class Ej4 {
  public static void main(String[] args) {
    try {
      // Parsea el nombre de la clase a entero
      Integer valor1 = Integer.valueOf(args[0]);
      // Parsea el primer argumento a entero
      Integer valor2 = Integer.valueOf(args[1]);
      // Aca nos conviene el Wrapper porque sino con el built-in no podes usar
      // el .toString
      Integer suma = valor1 + valor2;
      // Pasa la suma a string
      System.out.println(suma.toString());
    } catch (NumberFormatException | IndexOutOfBoundsException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
