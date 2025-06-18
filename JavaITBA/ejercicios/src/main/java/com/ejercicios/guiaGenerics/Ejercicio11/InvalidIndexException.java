package com.ejercicios.guiaGenerics.Ejercicio11;

public class InvalidIndexException extends Exception {
  @Override
  public String getMessage() {
    return "Indice Invalido";
  }
}
