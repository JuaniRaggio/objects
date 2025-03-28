package com.ejercicios.guiaGenerics.Ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CompositeFunctionTest {

  @Test
   public void testComposite() {
       Function f1 = new LinearFunction(2, 0); // y = 2x
       Function f2 = new QuadraticFunction(1, 0, 0); // y = x^2
       Function f3 = new CompositeFunction(f1, f2); // y = (2x)^2
       assertEquals(4.0, f3.evaluate(1)); // 4.0
       assertEquals(16.0, f3.evaluate(2)); // 16.0
       Function f4 = new SineFunction(); //y = sin(x)
       Function f5 = new CompositeFunction(f1, f4); // y = sin(2x)
       Function f6 = new CompositeFunction(f5, f1); // y = 2 sin(2x)
       assertEquals(0.0, f6.evaluate(0)); // 0.0
       assertEquals(2.0, f6.evaluate(Math.PI / 4.0)); // 2.0
   }

}
