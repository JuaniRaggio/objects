package com.ejercicios.guiaGenerics.Ejercicio6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExpressionTest {

  @Test
   public void ExprTest() {
       SimpleExpression exp1 = new SimpleExpression(true);
       SimpleExpression exp2 = new SimpleExpression(false);
       Expression exp3 = exp1.not();
       Expression exp4 = exp1.or(exp2);
       Expression exp5 = exp3.and(exp4);
       assertEquals(true, exp1.evaluate());
       assertEquals(false, exp3.evaluate());
       assertEquals(true, exp4.evaluate());
       assertEquals(false, exp5.evaluate());
       exp1.setValue(false);
       assertEquals(true, exp3.evaluate());
       assertEquals(false, exp4.evaluate());
       assertEquals(false, exp5.evaluate());
       exp2.setValue(true);
       assertEquals(true, exp5.evaluate());
   }

}
