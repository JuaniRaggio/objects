package com.parcialesViejos.repasoPrimerParcial.Ejercicio2;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
    
    assertThrows(NoSuchElementException.class, () -> myIterator.next());

    System.out.println("##########");

    assertThrows(RuntimeException.class, () -> new ParallelIterator<String>(null, v2));
    
    System.out.println("##########");
    
    assertThrows(RuntimeException.class, () -> new ParallelIterator<>(v1, null));
  }

}
