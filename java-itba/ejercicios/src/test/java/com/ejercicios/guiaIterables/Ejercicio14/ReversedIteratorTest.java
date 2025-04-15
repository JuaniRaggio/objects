package com.ejercicios.guiaIterables.Ejercicio14;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ReversedIteratorTest {

  @Test
  public void mainTest() {
    String[] words = new String[]{"hola", "que", "tal"};
    String[] expectedOrder = new String[]{"tal", "que", "hola"};
    ReversedIterator<String> arrayReversedIterator = new ReversedIterator<>(words);
    assertArrayEquals(expectedOrder, arrayReversedIterator);
    assertThrows(NoSuchElementException.class, () -> arrayReversedIterator.next());
  }
}
