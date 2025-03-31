package com.ejercicios.guiaGenerics.Ejercicio7;

public class Interval {

  private Interval[] interval;

  private long size;

  private double increment, start, end;

  private boolean isGreaterEq(double a, double b) {
    return Double.compare(a, b) <= 0;
  }
  
  private void validateEndPoints(double start, double end) {
    if (isGreaterEq(start, end))
      throw new IllegalArgumentException("Start is lower than end");
  }

  private void validateIncrement(double increment) {
    if (isGreaterEq(0, increment))
      throw new IllegalArgumentException("Invalid increment value");
  }

  // Chequear si start es mayor que end y si increment es negativo
  public Interval(double start, double end) {
    this(start, end, 1);
  }

  public Interval(double start, double end, double increment) {
    validateEndPoints(start, end);
    validateIncrement(increment);
    this.start = start;
    this.end = end;
    this.increment = increment;
    this.size = 0;
    this.interval = new Interval[(int) Math.floor((end - start) / increment)];
  }

  public long size() { return size; }

  public double at(long index) {
    if (isGreaterEq(index, size) || isGreaterEq(0, index))
      throw new IllegalArgumentException("Invalid index");
    return interval[index];
  }

  public long indexOf(double value) {}

  public boolean includes(double valor) {}

  public String toString() {}

  public boolean equals(Object other) {}

  public int hashCode() {}

}
