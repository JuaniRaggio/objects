package com.ejercicios.guiaGenerics.Ejercicio12;

public class LinearListHeader {

  private Node head;

  private LinearListHeader(Object o) {
    head = new Node(o);
  }

  LinearListHeader add(Object toAdd) {
    int cmp = Integer.compare(currentValue.hashCode(), toAdd.hashCode());
    if (cmp < 0) {
      next = next.add(toAdd);
    } else if (cmp > 0) {
    }
  }

}

