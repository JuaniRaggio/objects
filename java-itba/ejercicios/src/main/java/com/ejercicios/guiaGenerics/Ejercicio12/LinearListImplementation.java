package com.ejercicios.guiaGenerics.Ejercicio12;

import java.util.Arrays;

public class LinearListImplementation implements LinearList {

  private Object[] linearL;

  private int elementsInList, size;

  private final int stepSize = 10;

  public LinearListImplementation(int initialSize) {
    size = initialSize;
    linearL = new Object[size];
    elementsInList = 0;
  }

  public void add(Object obj) {
    if (elementsInList == size) {
      linearL = Arrays.copyOf(linearL, size + stepSize);
    }
    linearL[elementsInList++] = obj;
  }

  public Object get(int i) {
    try {
      return linearL[i];
    } catch (IndexOutOfBoundsException e) {
      System.err.println(e.getMessage());
      return null;
    }
  }

  public void set(int i, Object obj) {
    try {
      linearL[i] = obj;
      if (obj == null) elementsInList--;
    } catch (IndexOutOfBoundsException e) {
      System.err.println(e.getMessage());
    }
  }

  public void remove(int i) {
    try {
      if (linearL[i] != null) {
        linearL[i] = null;
        elementsInList--;
      }
    } catch (IndexOutOfBoundsException e) {
      System.err.println(e.getMessage());
    }
  }

  public int indexOf(Object obj) {
    for (int i = 0; i < size; ++i) {
      if (linearL[i] == obj) return i;
    }
    return -1;
  }

  public int size() {
    return elementsInList;
  }

}
