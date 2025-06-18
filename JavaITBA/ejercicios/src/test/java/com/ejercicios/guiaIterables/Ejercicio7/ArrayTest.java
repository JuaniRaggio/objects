package com.ejercicios.guiaIterables.Ejercicio7;

import com.ejercicios.guiaIterables.Ejercicio1.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Comparator;

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
    Arrays.sort(pairArray, Comparator.reverseOrder());
    assertEquals("[{hola, mundo}, {hola, adiós}, {buen, día}]", Arrays.toString(pairArray));
    Pair<String, String>[] otherPairArray = new Pair[4];
    otherPairArray[1] = stringPair1;
    otherPairArray[2] = stringPair2;
    otherPairArray[3] = stringPair3;
    // Esto deberia abortar porque el primer pair es null por lo que va a tirar un
    // null pointer exception
    assertThrows(NullPointerException.class, () -> Arrays.sort(otherPairArray));
    assertEquals("[null, {hola, mundo}, {hola, adiós}, {buen, día}]", Arrays.toString(otherPairArray));
    Arrays.sort(intArray, (Integer o1, Integer o2) -> o2.compareTo(o1));
    assertEquals("[9, 7, 5, 3, 1]", Arrays.toString(intArray));
  }

}
