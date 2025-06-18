package com.ejercicios.guiaGenerics.Ejercicio11;

public class InvalidGradeException extends Exception {
  @Override
  public String getMessage() {
    return "Grado Invalido";
  }
}
