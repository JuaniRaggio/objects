package com.ejercicios.guiaGenerics.Ejercicio14;

public enum Continent {

  AFRICA("África", 1100, 30),
  AMERICA("América", 990, 42),
  ASIA("Asia", 4400, 43),
  EUROPE("Europa", 730, 10),
  OCEANIA("Oceanía", 39, 9);

  private String name;
  private int population;
  private int area;

  Continent(String name, int population, int area) {
    this.name = name;
    this.population = population;
    this.area = area;
  }

  public int getPopulation() {
      return population;
  }

  public double getPopulationRatio() {
    return (double) population / area;
  }

  @Override
  public String toString() {
    return name;
  }

}
