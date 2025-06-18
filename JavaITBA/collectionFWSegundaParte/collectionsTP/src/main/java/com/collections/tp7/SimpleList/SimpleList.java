package com.collections.tp7.SimpleList;

import java.util.function.BiFunction;

public interface SimpleList<T> {

  boolean add(T element);

  int size();

  boolean contains(T element);

  <R> R reduce(R initValue, BiFunction<R, T, R> operation);

}
