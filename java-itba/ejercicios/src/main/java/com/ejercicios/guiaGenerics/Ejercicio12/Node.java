package com.ejercicios.guiaGenerics.Ejercicio12;

public class Node {

  private Object currentValue;

  private Node next;

  public Node(Object o) {
    setNodeValue(o);
  }

  private void setNodeValue(Object o) {
    currentValue = o;
  }

  public Object getNodeValue() {
    return currentValue;
  }

}
