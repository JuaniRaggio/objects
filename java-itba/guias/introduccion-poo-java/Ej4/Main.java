package Ej4;

public class Main {
  public static void main(String[] args) {
    // Se inicializa un dato ClassA pero como una instancia de ClassB
    // Entonces los metodos availables van a ser los de ClassA pero si ClassB
    // sobreescribio un metodo de ClassA, se va a usar el de ClassB
    // por lo tanto a.method(3) va a usar el method de B
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

    // Esto deberia tirar un error (?
    // pues a es la clase padre y no puede transformarse en ClassB, ya que es hija
    // y podria funcionar al revez pero de esta forma no deberia
    // a = new ClassA();
    // b = (ClassB)a;
    // b.method(3);

    // Esto esta bien porque b es de tipo ClassB y puede castearse a una clase
    // padre
    // No estoy seguro si a.method va a usar el de A o el de B
    b = new ClassB();
    a = (ClassA)b; // Esto hace que se interprete como una instancia de A por lo que si se quiere acceder a method, va a ir al de A
    a.method(3);
  }
}

