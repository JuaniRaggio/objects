package com.ejercicios.guiaIterables.Ejercicio15;

import java.util.NoSuchElementException;

// No implementamos Iterable porque en si es un iterador el
// ciclic window iterator
public class CiclicWindowIterator<T> {

  private final T[] collection;
  private final int stepSize;
  private int position = 0;

  public CiclicWindowIterator(T[] collection, int stepSize) {
    this.stepSize = stepSize;
    this.collection = collection;
  }

  public boolean hasNext() {
    return collection.length == 0;
  }

  @SuppressWarnings("unchecked")
  public T[] next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    T[] returnArray = (T[]) new Object[stepSize];
    for (int i = 0; i < returnArray.length; ++i) {
      returnArray[i] = collection[(position + i) % collection.length];
    }
    ++position;
    return returnArray;
  }

}
