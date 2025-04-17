package com.parcialesViejos.repasoPrimerParcial.Ejercicio2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParallelIterator<T> implements Iterable<Pair<T>> {

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

  public Iterator<Pair<T>> iterator() {
    return new Iterator<Pair<T>>() {
      private int ACurrent = 0, BCurrent = 0;

      @Override
      public boolean hasNext() {
        return ACurrent != A.length && BCurrent != B.length;
      }

      @Override
      public Pair<T> next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return new Pair<>(A[ACurrent++], B[BCurrent++]);
      }
    };
  }

}
