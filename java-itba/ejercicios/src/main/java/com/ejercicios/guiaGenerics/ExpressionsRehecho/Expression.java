package com.ejercicios.guiaGenerics.ExpressionsRehecho;

public abstract class Expression {

  public NotExpression not() {
    return new NotExpression(this);
  }

  public OrExpression or(Expression exp) {
    return new OrExpression(this, exp);
  }

  public Expression and(Expression exp) {
    return new AndExpression(this, exp);
  }

  public abstract boolean evaluate();

}
