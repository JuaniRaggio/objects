package com.parcialesViejos.parcial2021.Ejercicio2;

public class TVShow {

  private final String name;
  private final double rating;

  public TVShow(String name, double rating) {
    this.name = name;
    if (!validateRating(rating)) {
      throw new IllegalArgumentException();
    }
    this.rating = rating;
  }

  public static boolean validateRating(double rating) {
    return rating >= 0 && rating <= 10;
  }

  public String getName() {
    return name;
  }

  public double getRating() {
    return rating;
  }

  @Override
  public String toString() {
    return String.format("### %20s : %.2f ###", name, rating);
  }

}
