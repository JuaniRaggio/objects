package com.parcialesViejos.repasoPrimerParcial.Ejercicio2;

public class ParallelIterator<T> {

  private T[] A, B;

  private void verifyNonNullCollection(Object param, String description) {
    if (param == null)
      throw new RuntimeException("%s collection missing".formatted(description));
  }

  public ParallelIterator(T[] collectionA, T[] collectionB) {
    verifyNonNullCollection(A, "First");
    verifyNonNullCollection(B, "Second");
    A = collectionA;
    B = collectionB;
  }
  
}
