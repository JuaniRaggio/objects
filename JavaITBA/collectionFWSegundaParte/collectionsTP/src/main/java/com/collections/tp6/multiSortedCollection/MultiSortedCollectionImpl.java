package com.collections.tp6.multiSortedCollection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MultiSortedCollectionImpl<T> implements MultiSortedCollection<T> {

  // Como los comparators con los que se desea acceder son la misma instancia que se pasa
  // cuando se agregan, podemos usar los Comparator<T> como llaves
  private Set<T> currentSet = new HashSet<>();
  private Map<Comparator<T>, Set<T>> comparators = new HashMap<>();

  @Override
  public void add(Comparator<T> comp) {
    Set<T> toAdd = new TreeSet<>(comp);
    if (currentSet.isEmpty())
      toAdd.addAll(currentSet);
    comparators.putIfAbsent(comp, toAdd);
  }

  @Override
  public void add(T elem) {
    currentSet.add(elem);
    for (Set<T> values : comparators.values()) {
      values.add(elem);
    }
    // Otra forma seria:
    // comparators.values().forEach(set -> set.add(elem));
  }

  /**
   ,* Elimina un elemento de la colección. Si el mismo no existe, no hace nada.
   ,*/
  @Override
  public void remove(T elem) {
    currentSet.remove(elem);
    for (Set<T> values : comparators.values()) {
      values.remove(elem);
    }
    // Otra forma seria:
    // comparators.values().forEach(set -> set.remove(elem));
  }

  /**
   ,* Devuelve un objeto iterable en base al comparador pedido.
   ,* Arroja IllegalArgumentException si el comparador no pertenece a la colección.
   ,*/
  @Override
  public Iterable<T> iterable(Comparator<T> comp) {
    if (!comparators.containsKey(comp)) {
      throw new IllegalArgumentException("El comparador no pertenece a la coleccion");
    }
    return comparators.get(comp);
  }

}
