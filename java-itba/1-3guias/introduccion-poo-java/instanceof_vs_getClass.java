public class instanceof_vs_getClass {
  public static void main(String args[]) {
    String s = "hola";

    // Va a dar true
    System.out.println(s instanceof String);

    // true porque toda clase hija es instancia de la clase padre, al revez no se cumple
    System.out.println(s instanceof Object);

    // Yo entiendo que getClass nos retorna como el blueprint de la clase y es un metodo de instancia
    // Mientras que el atributo class nos retorna tambien un blueprint de la clase
    // Entonces el primero nos va a dar true y el segundo false porque el blueprinte de String es igual al de una sintancia del mimso
    // Pero el blueprint de un String no es el mismo que el de Object
    System.out.println(s.getClass().equals(String.class));
    System.out.println(s.getClass().equals(Object.class));
  }
}
