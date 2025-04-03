package point;

import point.*;

public class Main {
  public static void main(String[] args) {
    // Si tuviesemos una clase main y ejecutamos lo siguiente, que pasa?
    Point_intro p1 = new Point_intro(2, 1);
    Point_intro p2 = new Point_intro(2, 1);
    System.out.println(p1 == p2);
    // stdout: false

    p1 = new Point_intro(2, 1);
    p2 = new Point_intro(2, 1);
    System.out.println(p1.equals(p2));
    // stdout: false
    // Eso pasa porque no esta implementado el metodo equals en la clase point,
    // equals no puede adivinar que es lo que se espera que se haga

    p1 = new Point_intro(2, 1);
    p2 = new Point_intro(2, 1);
    // getX me retorna un double y double no tienen un metodo equals por lo que vamos a tener un error
    // System.out.println(p1.getX().equals(p2.getX()) && p1.getY().equals(p2.getY()));

    Point_intro p = new Point_intro(2, 1);
    System.out.println(p instanceof Object);
    // true porque toda instancia de una clase hija de otra, tambien es instancia de las clases padres de la misma

    // p = new Point_intro();
    System.out.println(p);
    // Necesitas tener un constructor sin parametros si queres que funcione sin parametros
    // De todas maneras si estuviese solo la clase, creo que imprime la direccion de memoria de p

    // Point_intro[] points = new Point_intro[10];
    // for (Point_intro point : points) {
    //   // Los puntos estan en basura o tira un runtime error
    //   // Lo que pasa aca es que se inicializa un arreglo de punteros en null
    //   System.out.println(point.getX() + ", " + point.getY());
    // }

    p = new Point_intro(2, 1);
    System.out.println(p);
    // Creo que la direccion de memoria de p o usa el metodo toString() que esta sobreescrito por la clase
    // Efectivamente usa el metodo string
  }
}
