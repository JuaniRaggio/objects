package com.ejercicios.guiaGenerics.Ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LinearListTest {

 @Test
  public void linearList() {
    LinearList list = new LinearListImplementation();
    Object o1 = new Object();
    Object o2 = new Object();
    Object o3 = new Object();
    Object o4 = new Object();
    Object o5 = new Object();
    list.add(o1);
    assertEquals(list.size(), 1);
    assertEquals(list.get(0), o1);
    assertEquals(list.indexOf(o1), 0);
    assertEquals(list.get(1), null);
    list.set(0, o2);
    assertEquals(list.get(0), o2);
    assertEquals(list.indexOf(o2), 0);
    // It shouldn't change it
    list.set(0, null);
    assertEquals(list.get(0), o2);
    assertEquals(list.size(), 1);
    list.remove(2);
    assertEquals(list.size(), 1);
    list.add(o2);
    assertEquals(list.size(), 2);
    list.add(o4);
    list.add(o3);
    list.add(o1);
    assertEquals(list.get(0), o2);
    assertEquals(list.indexOf(o2), 0);
    assertEquals(list.get(1), o2);
    assertEquals(list.indexOf(o4), 2);
    assertEquals(list.get(3), o3);
    assertEquals(list.indexOf(o3), 3);
    assertEquals(list.get(4), o1);
    assertEquals(list.indexOf(o1), 4);
    assertEquals(list.get(5), null);
    assertEquals(list.size(), 5);
    list.add(o5);
    assertEquals(list.size(), 6);
    assertEquals(list.get(5), o5);
    assertEquals(list.indexOf(o5), 5);
    assertEquals(list.get(6), null);
    assertEquals(list.get(500), null);
    list.remove(5);
    assertEquals(list.size(), 5);
    list.remove(4);
    assertEquals(list.size(), 4);
    list.remove(3);
    assertEquals(list.size(), 3);
  }

}

