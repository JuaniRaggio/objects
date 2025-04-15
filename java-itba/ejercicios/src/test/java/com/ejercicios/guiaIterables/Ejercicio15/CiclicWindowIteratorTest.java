package com.ejercicios.guiaIterables.Ejercicio15;

import org.junit.jupiter.api.Test;

public class CiclicWindowIteratorTest {

  @Test
  public void CiclicWindowTest() {
    String[] words = new String[] { "hola", "que", "tal" };
    CyclicWindowIterator<String> iterator = new CyclicWindowIterator<>(words, 2);
    for (int i = 0; i < 5; i++) {
      System.out.println(Arrays.toString(iterator.next()));
    }
    Integer[] empty = new Integer[0];
    CyclicWindowIterator<Integer> emptyIterator = new CyclicWindowIterator<>(empty, 2);
    System.out.println(emptyIterator.hasNext());
    try {
      emptyIterator.next();
    } catch (Exception ex) {
      System.out.println(ex.getClass());
    }
  }

}
