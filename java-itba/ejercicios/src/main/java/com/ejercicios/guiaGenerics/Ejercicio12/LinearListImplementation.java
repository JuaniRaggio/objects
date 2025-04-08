package com.ejercicios.guiaGenerics.Ejercicio12;

// DISCLAMER! Es medio raro que te pidan que implementes una Linked List
// pero que a su vez te pidan un get por indice, un set por indice, un rm por
// indice, etc. Por eso la primer implementacion que habia hecho habia sido
// en forma de Array

public class LinearListImplementation implements LinearList {

  private int size;

  private Node head, last, iterator;

  private void resetIterator() {
    iterator = head;
  }

  private boolean emptyList() {
    return size == 0;
  }

  public LinearListImplementation() {
    size = 0;
    head = last = iterator = null;
  }

  public void add(Object obj) {
    if (emptyList()) {
      head = last = iterator = new Node(obj);
    } else {
      last = last.addAndReturn(obj);
    }
    size++;
  }

  public Object get(int i) {
    if (i >= size) {
      return null;
    }
    resetIterator();
    while (i-- > 0) {
      try {
        iterator = iterator.getNext();
      } catch (NullPointerException e) {
        return null;
      }
    }
    // If a leq 0 index is sent, the first item will be returned
    return iterator.getNodeValue();
  }

  /**
   * Modifica el i-ésimo elemento de la lista colocando un nuevo valor.
   */
  public void set(int i, Object obj) {
    if (i < 0 || obj == null) return;
    head.setNodeValueAtIndex(i, obj);
  }

  /**
   * Elimina el i-ésimo elemento de la lista.
   */
  public void remove(int i) {
    if (i < 0 || i > size || emptyList()) return;
    head = head.rmNodeAtIndex(i);
    /* TODO -> size is deacreasing everytime, so how could we change that 
     * also last is not updating correctly */
    size--;
  }

  /**
   * Busca el índice de la primer ocurrencia de un objeto en la lista.
   */
  public int indexOf(Object obj) {
    resetIterator();
    for (int i = 0; i < size; ++i) {
      if (iterator.getNodeValue().equals(obj)) {
        return i;
      }
      iterator = iterator.getNext();
    }
    return -1;
  }

  /**
   * Retorna el tamaño de la lista.
   */
  public int size() {
    return size;
  }

}
