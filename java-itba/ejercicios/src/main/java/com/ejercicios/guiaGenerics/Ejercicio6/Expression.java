package com.ejercicios.guiaGenerics.Ejercicio6;

public class Expression {

  private SimpleExpression prop;

  public Expression(SimpleExpression ex) {
    prop = ex;
  }

  public boolean evaluate() {
    return prop.evaluate();
  }

  public Expression not();

  public Expression or(Expression ex) {

  }

  public Expression and(Expression ex) {

  }

}
