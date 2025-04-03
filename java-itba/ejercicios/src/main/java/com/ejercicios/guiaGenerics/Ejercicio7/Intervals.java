package com.ejercicios.guiaGenerics.Ejercicio7;

public abstract class Intervals {

  protected boolean isGreaterEq(double a, double b) {
    return Double.compare(a, b) <= 0;
  }

  protected void exceptionIfGreater
    (double a, String aDescription, double b, String bDescription) {
    if (isGreaterEq(a, b))
      throw new IllegalArgumentException(String.format("%s is lower than %s", aDescription, bDescription));
  }

}
