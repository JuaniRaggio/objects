package com.parcialesViejos.repasoPrimerParcial.Ejercicio2;

public class Pair<T> {

  private T firstPair, secondPair;

  public Pair(T firstPair, T secondPair) {
    this.firstPair = firstPair;
    this.secondPair = secondPair;
  }

  @Override
  public String toString() {
    return "{%s,%s}".formatted(firstPair, secondPair);
  }
  
}
