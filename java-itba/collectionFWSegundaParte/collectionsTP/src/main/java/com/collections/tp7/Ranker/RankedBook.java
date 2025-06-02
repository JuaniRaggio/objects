package com.collections.tp7.Ranker;

public class RankedBook implements Comparable <RankedBook> {

  private int points;
  private Genre genre;
  private Book book;

  public RankedBook(Book book, Genre genre) {
    this.book = book;
    this.genre = genre;
    this.points = 0;
  }

  public void rankUp() { ++points; }

  @Override
  public boolean equals(Object other) {
    return other instanceof RankedBook rb && points.equals(rb.points) && book.equals(rb.equals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points, book);
  }

  @Override
  public int compareTo(RankedBook other) {
    return Integer.compare(points, other.points);
  }

}
