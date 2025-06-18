package com.ejercicios.guiaIterables.Ejercicio14;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReversedIterator<T> implements Iterable<T> {

  private final T[] iterable;

  public ReversedIterator(T[] iterable) {
    this.iterable = iterable;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      private int idx = iterable.length - 1;

      @Override
      public boolean hasNext() {
        return idx < 0;
      }

      @Override
      public T next() {
        if (!hasNext())
          throw new NoSuchElementException();
        return iterable[idx--];
      }

    };
  }

}
