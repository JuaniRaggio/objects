package com.collections.tp7.SimpleList;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class SimpleArrayList<T> extends ArrayList<T> implements SimpleList<T> {

  public <R> R reduce(R initValue, BiFunction<R, T, R> operation) {
    R result = initValue;
    for (T element : this) {
      result = operation.apply(result, element);
    }
    return result;
  }

}
