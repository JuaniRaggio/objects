package com.parcialesViejos.repasoPrimerParcial.Ejercicio2;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ParallelIteratorTest {

  @Test
  public void mainTest() {
    String[] v1 = new String[] { "hola", "mundo", "adios" };
    String[] v2 = new String[] { "hello", "world" };

    ParallelIterator<String> myIterator = new ParallelIterator<>(v1, v2);
    System.out.println(myIterator.next());
    System.out.println(myIterator.next());
    try {
      System.out.println(myIterator.next());
    } catch (NoSuchElementException ex) {
      System.out.println(ex.getClass());
    }

    System.out.println("##########");

    try {
      new ParallelIterator<>(null, v2);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

    System.out.println("##########");

    try {
      new ParallelIterator<>(v1, null);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

}
