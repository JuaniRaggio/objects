package com.ejercicios.guiaGenerics.Ejercicio15;

import org.junit.jupiter.api.Test;

public class OperationTest {

  @Test
   public void opTest() {
       double x = 4;
       double y = 2;
       for(BasicOperation operation : BasicOperation.values()) {
           System.out.printf("%.2f %s %.2f = %.2f\n", x, operation, y, operation.apply(x,y));
       }
       for(ExtendedOperation operation : ExtendedOperation.values()) {
           System.out.printf("%.2f %s %.2f = %.2f\n", x, operation, y, operation.apply(x,y));
       }
   }

}
