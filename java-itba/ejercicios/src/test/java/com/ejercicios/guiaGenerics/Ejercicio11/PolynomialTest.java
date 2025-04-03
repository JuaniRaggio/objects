package com.ejercicios.guiaGenerics.Ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PolynomialTest {

  @Test
  public void polyTest() throws InvalidGradeException, InvalidIndexException {
    Polynomial fourthGradePol = new Polynomial(4);
    fourthGradePol.set(2, 3.1); // 3.1 * x^2
    fourthGradePol.set(3, 2); // 2 * x^3 + 3.1 * x^2
    assertEquals(fourthGradePol.eval(2), 28.4); // 28.4
    assertEquals(new Polynomial(3).eval(5), 0); // 0
    try {
      new Polynomial(-4);
    } catch (InvalidGradeException e) {
      assertEquals(e.getMessage(), "Grado Invalido"); // 0
    }
    try {
      fourthGradePol.set(7, 1.5); // 1.5 * x^7
    } catch (InvalidIndexException e) {
      assertEquals("Indice Invalido", e.getMessage());
    }
  }

}
