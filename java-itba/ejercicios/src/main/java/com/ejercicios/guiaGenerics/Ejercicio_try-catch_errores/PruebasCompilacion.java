class Exception1 extends Exception {}
class Exception2 extends Exception {}
class Exception3 extends Exception2 {}
class Exception4 extends RuntimeException {}

public class PruebasCompilacion {

   public static void main(String[] args) {
       PruebasCompilacion ej3 = new PruebasCompilacion();
       try {
           ej3.method();
       } catch (Exception2 e) {
           System.out.println("Excepción 2 capturada");
       } catch (Exception3 e) {
           System.out.println("Excepción 3 capturada");
       }
   }

   public void method() throws Exception3 {
       throw new Exception3();
   }
}
