package com.collections.tp7.FilterList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArrayFilterList<T> extends ArrayList<T> implements FilterList<T> {

  public List<T> filter(Predicate <T> crit) {
    return this.stream().filter(crit).collect(Collectors.toList());
  }

}
