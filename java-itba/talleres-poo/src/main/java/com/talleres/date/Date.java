package com.talleres.date;

public class Date implements Comparable<Date> {
  private final int day, month, year;

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  @Override
  public int compareTo(Date other) {
    int cmp = year - other.year;
    if (cmp == 0) {
      cmp = month - other.month;
      if (cmp == 0) {
        cmp = day - other.day;
      }
    }
    return cmp;
  }

  @Override
  public String toString() { return "%d/%d/%d".formatted(day, month, year); }

}
