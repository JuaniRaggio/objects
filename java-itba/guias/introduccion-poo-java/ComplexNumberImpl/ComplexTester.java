package ComplexNumberImpl;

public class ComplexTester {

  public static void main(String[] args) {
     System.out.println("Hola");
     Complex c1 = new Complex(12d, 5);
     Complex c2 = new Complex(10);
     System.out.println(c1.equals(c2)); // false
     System.out.println(c1.equals(new Complex(12, 5))); // true
     System.out.println(c1.plus(c2)); // 22.00 + 5.00 -> En este por algun motivo me retorna 12.0 + 5.0
     System.out.println(c1.plus(-3)); // 9.00 + 5.00
     System.out.println(c1.plus((double) -3)); // 9.00 + 5.00
   }

}
