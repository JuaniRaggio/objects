package com.parcialesViejos.parcial20222C.TVEpisode;

import java.time.LocalDate;
import java.util.Comparator;

public class TVEpisode {

  private final int id;
  private final String title;
  private final double rating;
  private final LocalDate airedDate;

  public TVEpisode(int id, String title, double rating, LocalDate airedDate) {
    this.id = id;
    this.title = title;
    this.rating = rating;
    this.airedDate = airedDate;
  }

  public static int idAscendingOrder(TVEpisode ep1,TVEpisode ep2) {
    return ep1.id - ep2.id;
  }

  public static int dateAscendingOrder(TVEpisode ep1, TVEpisode ep2) {
    int cmp = ep1.airedDate.compareTo(ep2.airedDate);
    if (cmp == 0) {
      return idAscendingOrder(ep1, ep2);
    }
    return cmp;
  }

  public static int nameAscendingOrder(TVEpisode ep1, TVEpisode ep2) {
    int cmp = ep1.title.compareTo(ep2.title);
    if (cmp == 0) {
      return idAscendingOrder(ep1, ep2);
    }
    return cmp;
  }

  public static int ratingDescendingOrder(TVEpisode ep1, TVEpisode ep2) {
    int cmp = Double.compare(ep2.rating, ep1.rating);
    if (cmp == 0) {
      return idAscendingOrder(ep1, ep2);
    }
    return cmp;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public double getRating() {
    return rating;
  }

  public LocalDate getAiredDate() {
    return airedDate;
  }
}
