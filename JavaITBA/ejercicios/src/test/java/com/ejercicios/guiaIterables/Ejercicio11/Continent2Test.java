package com.ejercicios.guiaIterables.Ejercicio11;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.ejercicios.guiaGenerics.Ejercicio14.*;

public class Continent2Test {

  @Test
  public void mainTest() {
    Continent[] continents = new Continent[] {
        Continent.OCEANIA,
        Continent.AMERICA,
        Continent.EUROPE };
    Arrays.sort(continents, (a, b) -> Integer.compare(a.getPopulation(), b.getPopulation()));
    Continent[] expected = new Continent[]{Continent.OCEANIA, Continent.EUROPE, Continent.AMERICA};
    assertArrayEquals(expected, continents);
  }

}
