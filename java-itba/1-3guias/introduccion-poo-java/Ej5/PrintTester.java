package Ej4;

public class PrintTester {

  public static void main(String[] args) {
    A a = new A();
    System.out.println("Integer A");
    // Integer
    a.print(3);

    System.out.println("Number A");
    // Number
    a.print(3.14);

    System.out.println("Number A");
    // Number
    a.print((Number)3);

    System.out.println("Object A");
    // Object
    a.print((Object)3);

    A b1 = new B();

    System.out.println("B Number");
    // B Number
    b1.print(3.14);

    System.out.println("A Object");
    // A Object
    b1.print("Hola");
    
    System.out.println("A Number");
    // A Number
    b1.print((Number)3);

    System.out.println("A Object");
    // A Object
    b1.print((Object)3);

    B b2 = new B();
    System.out.println("B Number");
    // B Number
    b2.print(3.14);

    System.out.println("A Object");
    // A OBject
    b2.print("Hola");

    System.out.println("B Number");
    // B Number
    b2.print((Number)3);

    System.out.println("A Object");
    // A Object
    b2.print((Object)3);
  }

}
