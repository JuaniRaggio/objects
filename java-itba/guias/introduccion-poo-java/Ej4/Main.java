package Ej4;

public class Main {
  public static void main(String[] args) {
    // Se inicializa una instancia de B -> Se va a usar el method de B
    ClassA a = new ClassB();
    a.method(3);

    // b ( clase hija ) no puede ser instancia de ClassA ( clase padre ) -> tira un error
    // ClassB b = new ClassA();
    // b.method(3);

    // Aca todo normal, b es clase de b y esta todo bien, se va a ejecutar method de b
    ClassB b = new ClassB();
    b.method(3);

    // Integer es clase hija de Number por lo que sigue estando todo bien, no es necesario hacer esto
    b = new ClassB();
    b.method((Number)3);

    a = new ClassA();
    b = (ClassB)a;
    b.method(3);

    b = new ClassB();
    a = (ClassA)b;
    a.method(3);
  }
}

