package com.ejercicios.guiaGenerics.Ejercicio15;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class OperationTest {

  @Test
  public void opTest() {
    double x = 4;
    double y = 2;
    double[] ops = new double[4];
    int i = 0;

    for (BasicOperation operation : BasicOperation.values()) {
      ops[i] = operation.apply(x, y);
      System.out.printf("%.2f %s %.2f = %.2f\n", x, operation, y, ops[i++]);
    }
    double[] expected = {6.00, 2.00, 8.00, 2.00};
    assertArrayEquals(expected, ops);

    i = 0;
    double[] ops2 = new double[2];
    for (ExtendedOperation operation : ExtendedOperation.values()) {
      ops2[i] = operation.apply(x, y);
      System.out.printf("%.2f %s %.2f = %.2f\n", x, operation, y, ops2[i++]);
    }
    double[] expected2 = {16.00, 0.00};
    assertArrayEquals(expected2, ops2);
  }

}
