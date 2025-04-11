package com.ejercicios.guiaIterables.Ejercicio1;

import java.util.Objects;

public class Pair<A extends Comparable<A>, B extends Comparable<B>> {

  private A a;
  private B b;

  public Pair(A a, B b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public String toString() {
    return String.format("{%s, %s}", a.toString(), b.toString());
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof Pair<?, ?> pair && a.equals(pair.a) && b.equals(pair.b);
  }

  @Override
  public int hashCode() {
    return Objects.hash(a, b);
  }

}
