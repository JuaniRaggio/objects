package com.parcialesViejos.parcial20201C.MathFunction;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MathFunctionalInterval <T extends Comparable<? super T>> implements Iterable <T> {

  private final MathFunction<T> stepFunction;
  private final T from, to;

  private boolean validLimits(T from, T to) {
    return from.compareTo(to) > 0;
  }

  public MathFunctionalInterval(T from, T to, MathFunction<T> function) {
    if (validLimits(from, to)) {
      throw new IllegalArgumentException("Start no es menor que end");
    }
    this.from = from;
    this.to = to;
    this.stepFunction = function;
  }

  public Iterator<T> iterator() {
    return new Iterator<>() {

      // No me guardo la stepFunction porque no hay setter
      // No me guardo to porque tambien es final
      private T current = from;

      @Override
      public boolean hasNext() {
        return current.compareTo(to) <= 0;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return stepFunction.evaluate(current);
      }

    };
  }
  
}
