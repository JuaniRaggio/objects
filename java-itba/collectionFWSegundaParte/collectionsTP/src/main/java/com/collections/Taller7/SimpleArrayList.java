package com.collections.Taller7;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class SimpleArrayList <T> extends ArrayList <T> {

  public SimpleArrayList <T> map(UnaryOperator <T> operation) {
    // SimpleArrayList <T> ret = new SimpleArrayList<>();
    // for (T el : this)
    //   ret.add(operation.apply(el));
    // return ret;
    return map((Function<T, T>) operation);
  }

  public <R> SimpleArrayList <R> map(Function<T, R> operation) {
    SimpleArrayList <R> ret = new SimpleArrayList<>();
    for (T el : this)
      ret.add(operation.apply(el));
    return ret;
  }

}
