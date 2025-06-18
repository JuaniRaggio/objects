package com.ejercicios.guiaGenerics.ExpressionsRehecho;

public class NotExpression extends Expression {

  private Expression exp;

  public NotExpression(Expression exp) {
    this.exp = exp;
  }

  @Override
  public boolean evaluate() {
    return !exp.evaluate();
  }
  
}
