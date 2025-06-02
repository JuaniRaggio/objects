package com.collections.tp7.ConcatIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConcatIterator<T> implements Iterator<T> {

  private Iterator<T> firstToIterate, secondToIterate;

  public ConcatIterator(Iterator<T> it1, Iterator<T> it2) {
    firstToIterate = it1;
    secondToIterate = it2;
  }

  public boolean hasNext() {
    return firstToIterate.hasNext() || secondToIterate.hasNext();
  }

  public T next() {
    if (firstToIterate.hasNext()) {
      return firstToIterate.next();
    } else if (secondToIterate.hasNext()) {
      return secondToIterate.next();
    }
    throw new NoSuchElementException("No more elements to iterate");
  }

}
