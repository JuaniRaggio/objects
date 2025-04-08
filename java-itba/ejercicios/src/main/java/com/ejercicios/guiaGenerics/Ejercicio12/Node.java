package com.ejercicios.guiaGenerics.Ejercicio12;

public class Node {

  private Object currentValue;

  private Node next;

  public Node(Object o) {
    setNodeValue(o);
    next = null;
  }

  public Node getNext() {
    return next;
  }

  public Node rmNodeAtIndex(int i) {
    if (i == 0 || next == null) {
      return next;
    }
    next.rmNodeAtIndex(i - 1);
    return this;
  }

  public void setNodeValueAtIndex(int i, Object o) {
    if (i == 0) {
      setNodeValue(o);
      return;
    }
    next.setNodeValueAtIndex(i - 1, o);
    return;
  }

  public Node addAndReturn(Object o) {
    if (next == null) {
      next = new Node(o);
      return next;
    }
    // This shouldn't happen in our implementation but just in case
    return next.addAndReturn(o);
  }

  private void setNodeValue(Object o) {
    currentValue = o;
  }

  public Object getNodeValue() {
    return currentValue;
  }

}
