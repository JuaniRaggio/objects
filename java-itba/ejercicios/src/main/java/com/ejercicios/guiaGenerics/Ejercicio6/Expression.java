package com.ejercicios.guiaGenerics.Ejercicio6;

public abstract class Expression {

  private boolean proposition;

  public void setValue(boolean p) {
    proposition = p;
  }

  public boolean evaluate() { return proposition; }

  public abstract Expression not();

  public abstract Expression or(Expression ex);

  public abstract Expression and(Expression ex);

}
