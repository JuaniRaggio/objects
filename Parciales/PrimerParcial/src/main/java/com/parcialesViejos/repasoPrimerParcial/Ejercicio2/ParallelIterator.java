package com.parcialesViejos.repasoPrimerParcial.Ejercicio2;

import java.util.NoSuchElementException;

public class ParallelIterator<T> {

  private int ACurrent, BCurrent;
  private T[] A, B;

  private void verifyNonNullCollection(T[] param, String description) {
    if (param == null) {
      throw new RuntimeException("%s collection missing".formatted(description));
    }
  }

  public ParallelIterator(T[] collectionA, T[] collectionB) {
    verifyNonNullCollection(collectionA, "First");
    verifyNonNullCollection(collectionB, "Second");
    A = collectionA;
    B = collectionB;
    ACurrent = BCurrent = 0;
  }

  public boolean hasNext() {
    return ACurrent != A.length && BCurrent != B.length;
  }

  public Pair<T> next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return new Pair<>(A[ACurrent++], B[BCurrent++]);
  }

}
