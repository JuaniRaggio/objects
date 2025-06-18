package com.ejercicios.guiaGenerics.Ejercicio15;

import java.util.function.BinaryOperator;

public enum BasicOperation {
  // + - * /
  SUM("+", (x, y) -> x + y),
  SUB("-", (x, y) -> x - y),
  MULT("*", (x, y) -> x * y),
  DIV("/", (x, y) -> x / y);

  private Operator op;

  private BasicOperation(String operand, BinaryOperator<Double> operation) {
    op = new Operator(operand, operation);
  }

  public String toString() { return op.toString(); }

  public double apply(double x, double y) { return op.apply(x, y); }

}
