package com.ejercicios.guiaIterables.Ejercicio7;

import com.ejercicios.guiaIterables.Ejercicio1.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArrayTest {

  @Test
  public void ArrTest() {
    Integer[] intArray = new Integer[] { 7, 3, 1, 5, 9 };
    assertEquals("[7, 3, 1, 5, 9]", Arrays.toString(intArray));
    Arrays.sort(intArray);
    assertEquals("[1, 3, 5, 7, 9]", Arrays.toString(intArray));
    Pair<String, String> stringPair1 = new Pair<>("hola",
        "mundo");
    Pair<String, String> stringPair2 = new Pair<>("hola",
        "adiós");
    Pair<String, String> stringPair3 = new Pair<>("buen",
        "día");
    Pair pairArray[] = new Pair[] { stringPair1, stringPair2, stringPair3 };
    Arrays.sort(pairArray);
    assertEquals("[{buen, día}, {hola, adiós}, {hola, mundo}]", Arrays.toString(pairArray));
  }

}
