package com.ejercicios.guiaGenerics.Ejercicio2;

public class CompositeFunction implements Function {

  Function f;

  Function g;

  @Override
  public double evaluate(double x) {
    return g.evaluate(f.evaluate(x));
  }

  public CompositeFunction(Function f, Function g) {
    this.f = f;
    this.g = g;
  }

} 
