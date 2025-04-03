// No se a que se refieren cuando me dicen que solo cambie la generacion de s1
public class Ej1_a {
  public static void main(String[] args) {
    String s1, s2;
    s1 = new String("hola");
    s2 = new String("hola");
    if (s1 == s2) {
      System.out.println("Son iguales");
    } else {
      System.out.println("Son distintos");
    }
  }
}
