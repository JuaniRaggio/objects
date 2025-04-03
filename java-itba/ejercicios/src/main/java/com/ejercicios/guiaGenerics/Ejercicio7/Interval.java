package com.ejercicios.guiaGenerics.Ejercicio7;

import java.util.Objects;

public class Interval {

  // Cada espacio va a guardar la cantidad de elementos repetidos en ese lugar
  // que tenemos
  private long[] interval;

  private long size;

  private double increment, start, end;

  private boolean isGreaterEq(long a, long b) {
    return Long.compare(a, b) <= 0;
  }

  private boolean isGreaterEq(double a, double b) {
    return Double.compare(a, b) <= 0;
  }

  private void exceptionIfGreater
    (double a, String aDescription, double b, String bDescription) {
    if (isGreaterEq(a, b))
      throw new IllegalArgumentException
            (String.format("%s is lower than %s", aDescription, bDescription));
  }

  private void validateEndPoints(double start, double end) {
    exceptionIfGreater(start, "Start", end, "End");
  }

  private void validateIncrement(double increment) {
    exceptionIfGreater(0, "0", increment, "Increment");
  }

  private void validateIndex(long index) {
    if (isGreaterEq(index, (long) Math.floor((end - start) / increment)) ||
        isGreaterEq(0, index))
      throw new IllegalArgumentException("Invalid index");
  }

  private void setValidInterval(double start, double end, double increment) {
    this.start = start;
    this.end = end;
    this.increment = increment;
    this.size = 0;
    interval = new long[(int) Math.floor((end - start) / increment)];
  }

  public Interval(double start, double end) {
    validateEndPoints(start, end);
    setValidInterval(start, end, 1);
  }

  public Interval(double start, double end, double increment) {
    validateEndPoints(start, end);
    validateIncrement(increment);
    setValidInterval(start, end, increment);
  }

  public long size() { return size; }

  public double at(long index) {
    validateIndex(index);
    return start + index*increment;
  }

  public long indexOf(double value) {
    if (!includes(value)) {
      return 0;
    }
    return (long) Math.floor((value - start) / increment);
  }

  public boolean includes(double value) {
    return Double.compare(start, value) == 1 ||
            Double.compare(value, end) == 1;
  }

  public String toString() {
    StringBuilder strInterval = new StringBuilder();
    for (int i = 0; i < Math.floor((end - start)/increment); ++ i) {
      strInterval.append(String.format("{%g: %d}",
        start + increment * i,
        interval[i]));
    }
    return strInterval.toString();
  }

  public boolean equals(Object other) {
    return other.hashCode() == hashCode();
  }

  public int hashCode() {
    return Objects.hash(interval, increment, start, end);
  }

}
