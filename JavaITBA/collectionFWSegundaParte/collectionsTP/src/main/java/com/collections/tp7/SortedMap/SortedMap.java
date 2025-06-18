package com.collections.tp7.SortedMap;

import java.util.Map;
import java.util.NavigableMap;

// Mapa ordenado por las claves y permite obtener la primera clave y el valor asociado
// Como las claves estan ordenadas hay que exigirle a K que sea comparable
public interface SortedMap<K extends Comparable<K>,V> extends Map<K, V>, Iterable<Map.Entry<K, V>> {
  K firstKey();
  V firstValue();
}
