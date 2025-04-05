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
  }){
    @Override
    public void hola() {
      // Aca iria la implementacion
      return;
    }
  },
  MOD("%", (x, y) -> x % y) {
    @Override
    public void hola() {
      // Aca iria la implementacion
      return;
    }
  };

  public abstract void hola();

  private final Operator op;

  private ExtendedOperation(String operand, BinaryOperator<Double> operation) {
    op = new Operator(operand, operation);
  }

  public String toString() { return op.toString(); }

  public double apply(double x, double y) { return op.apply(x, y); }

}
