package com.collections.tp7.IterableBag;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class IterableBagImpl<E extends Comparable<? super E>> extends BagImpl<E> implements IterableBag <E>{

  /*
  ** Para iterar, en orden descendente, por todos los elementos que hay en la bolsa.
  */
  Iterable<E> elements() {
  }

  /*
  ** Para iterar, en orden descendente, por todos los elementos distintos
  ** que hay en la bolsa.
  */
  Iterable<E> elementsDistinct();
}
