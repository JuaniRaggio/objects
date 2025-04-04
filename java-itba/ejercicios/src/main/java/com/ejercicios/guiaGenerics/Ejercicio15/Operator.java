package com.ejercicios.guiaGenerics.Ejercicio15;

import java.util.function.BinaryOperator;

public class Operator {

  private final String operand;

  private final BinaryOperator<Double> operation;
  
  public Operator(String operand, BinaryOperator<Double> operation) {
    this.operand = operand;
    this.operation = operation;
  }

  public String toString() { return operand; }

  public double apply(double x, double y) {
    return operation.apply(x, y);
  }

}
