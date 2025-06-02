package com.collections.tp7.FilterList;

import java.util.List;
import java.util.function.Predicate;

public interface FilterList<T> extends List<T> {
  // Como list tambien es una interfaz, no podemos hacer este metodo default
  List<T> filter(Predicate<T> crit);
}
