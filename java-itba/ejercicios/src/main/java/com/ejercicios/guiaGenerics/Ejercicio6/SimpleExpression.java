package com.ejercicios.guiaGenerics.Ejercicio6;

public class SimpleExpression {

  private Expression proposition;

  public SimpleExpression(boolean p) { setValue(p); }

  public SimpleExpression(Expression ex) {
    proposition = ex;
  }

  public Expression not() {
    return new SimpleExpression(!proposition.evaluate());
  }

  public Expression or(Expression ex) {
    return new SimpleExpression(proposition.evaluate() || ex.evaluate());
  }

  public Expression and(Expression ex) {
    return new SimpleExpression(proposition.evaluate() && ex.evaluate());
  }

  public Expression evaluate() {
    return proposition;
  }

  @Override
  public void setValue(boolean p) { proposition.setValue(p); }

}
