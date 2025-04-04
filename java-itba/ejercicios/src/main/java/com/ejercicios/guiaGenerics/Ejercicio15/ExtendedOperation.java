package com.ejercicios.guiaGenerics.Ejercicio15;

import java.util.function.BinaryOperator;

public enum ExtendedOperation {
  // ^ %
  POW("^", (x, y) -> {
    double result = 1;
    while (y > 0) {
      result = BasicOperation.MULT.apply(x, result);
      y--;
    }
    return result;
  }),
  MOD("%", (x, y) -> x % y);

  private final String operand;

  private final BinaryOperator<Double> operation;

  private ExtendedOperation(String operand, BinaryOperator<Double> operation) {
    this.operand = operand;
    this.operation = operation;
  }

  public String toString() { return operand; }

  public double apply(double x, double y) {
    return operation.apply(x, y);
  }

}
