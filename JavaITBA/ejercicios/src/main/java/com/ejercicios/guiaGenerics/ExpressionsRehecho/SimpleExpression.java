package com.ejercicios.guiaGenerics.ExpressionsRehecho;

public class SimpleExpression extends Expression {

  private boolean value;

  public SimpleExpression(boolean value) {
    setValue(value);
  }

  public void setValue(boolean value) {
    this.value = value;
  }

  @Override
  public boolean evaluate() {
    return value;
  }
  
}
