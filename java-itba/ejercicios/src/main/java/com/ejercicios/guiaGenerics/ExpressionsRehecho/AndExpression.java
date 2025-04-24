package com.ejercicios.guiaGenerics.ExpressionsRehecho;

public class AndExpression extends BinaryExpression {

  public AndExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public boolean evaluate() {
    return left.evaluate() && right.evaluate();
  }

}
