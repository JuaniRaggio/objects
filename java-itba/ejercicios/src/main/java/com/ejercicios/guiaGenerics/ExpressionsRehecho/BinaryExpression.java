package com.ejercicios.guiaGenerics.ExpressionsRehecho;

public abstract class BinaryExpression extends Expression {

  protected Expression left, right;

  protected BinaryExpression(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  public abstract boolean evaluate();
  
}
