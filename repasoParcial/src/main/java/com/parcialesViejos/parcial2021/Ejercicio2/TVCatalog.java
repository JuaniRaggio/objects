package com.parcialesViejos.parcial2021.Ejercicio2;

public interface TVCatalog extends Iterable<TVResponse>{

  TVCatalog addTVShow(String name, double rating);

  void setRatingRange(double min, double max);

}
