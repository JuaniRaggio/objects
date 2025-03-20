package introduccion_poo_java;

public class instanceof_vs_getClass {
  public static void main(String args[]) {
    String s = "hola";
    System.out.println(s instanceof String); // Va a dar true
    System.out.println(s instanceof Object); // Si porque toda clase hija es instancia de la clase padre, al revez no se cumple
    System.out.println(s.getClass().equals(String.class)); // getClass es un metodo de clase por lo que no se necesita una instancia para llamarlo
    System.out.println(s.getClass().equals(Object.class));
  }
}
