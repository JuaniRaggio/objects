package com.ejercicios.guiaGenerics.ExpressionsRehecho;

public class OrExpression extends BinaryExpression {

  public OrExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public boolean evaluate() {
    return left.evaluate() || right.evaluate();
  }
  
}
