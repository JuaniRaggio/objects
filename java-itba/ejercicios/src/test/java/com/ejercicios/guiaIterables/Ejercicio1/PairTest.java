package com.ejercicios.guiaIterables.Ejercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PairTest {

  @Test
  public void pairTest() {
    Pair<String, Double> stringDoublePair = new Pair<>("hola", 0.1);
    assertEquals("{hola, 0.1}", stringDoublePair.toString());
    Pair<Integer, Integer> integerIntegerPair = new Pair<>(1, 2);
    assertEquals("{1, 2}", integerIntegerPair.toString());
    assertTrue(stringDoublePair.equals(new Pair<>("hola", 0.1)));
    Pair otherPair = new Pair(1f, "mundo");
    System.out.println(otherPair);
  }
  
}
