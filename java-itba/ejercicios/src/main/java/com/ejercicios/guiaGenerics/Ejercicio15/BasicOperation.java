package com.ejercicios.guiaGenerics.Ejercicio15;

import java.util.function.BinaryOperator;

public enum BasicOperation {
  // + - * /
  SUM("+", (x, y) -> x + y),
  SUB("-", (x, y) -> x - y),
  MULT("*", (x, y) -> x * y),
  DIV("/", (x, y) -> x / y);

  private final String operand;

  private final BinaryOperator<Double> operation;
  
  private BasicOperation(String operand, BinaryOperator<Double> operation) {
    this.operand = operand;
    this.operation = operation;
  }

  public String toString() { return operand; }

  public double apply(double x, double y) {
    return operation.apply(x, y);
  }

}
