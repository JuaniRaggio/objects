package com.collections.tp7.IterableBag;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IterableBagImpl<E extends Comparable<? super E>>  extends BagImpl<E> implements IterableBag <E>{

  public IterableBagImpl() {
    bag = new TreeMap<>(Comparator.reverseOrder());
  }

  /*
  ** Para iterar, en orden descendente, por todos los elementos que hay en la bolsa.
  */
  Iterable<E> elements() {
    List<E> fullMaximizedBag = new ArrayList<>();
    for (Map.Entry<E, Integer> elements : bag.entrySet()) {
      for (int i = 0; i < elements.getValue(); i++) {
        fullMaximizedBag.add(elements.getKey());
      }
    }
    return fullMaximizedBag;
  }

  /*
  ** Para iterar, en orden descendente, por todos los elementos distintos
  ** que hay en la bolsa.
  */
  public Iterable<E> elementsDistinct() {
    return bag.keySet();
  }
}
