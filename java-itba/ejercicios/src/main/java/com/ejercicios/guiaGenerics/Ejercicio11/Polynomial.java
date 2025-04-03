package com.ejercicios.guiaGenerics.Ejercicio11;

public class Polynomial {

  private double[] pol;

  public Polynomial(int a) throws InvalidGradeException {
    if (a < 0)
      throw new InvalidGradeException();
    pol = new double[a + 1];
  }

  public double eval(double x) {
    double answer = 0;
    for (int i = 0; i < pol.length; ++i) {
      answer += pol[i] * Math.pow(x, i);
    }
    return answer;
  }

  public void set(int grade, double coef) throws InvalidIndexException {
    if (grade < 0 || grade >= pol.length)
      throw new InvalidIndexException();
    pol[grade] = coef;
  }

}
