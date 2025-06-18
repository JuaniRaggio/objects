package com.collections.tp7.MultiMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class MultiMapImpl<K, V extends Comparable<V>> extends HashMap<K, Set<V>> implements MultiMap<K, V> {

  public void put(K key, V value) {
    if (!this.containsKey(key)) {
      // Ojo con poner this aca, aunque justo en este caso esta OK porque la signature es distinta
      super.put(key, new TreeSet<>(Comparator.reverseOrder()));
    }
    // Ojo con poner this aca
    super.get(key).add(value);
  }

  public int size(K key) {
    return super.get(key).size();
  }

  public void remove(K key, V value) {
    if (this.containsKey(key)) {
      // Ojo con haber puesto this aca
      super.get(key).remove(value);
    }
  }

}
