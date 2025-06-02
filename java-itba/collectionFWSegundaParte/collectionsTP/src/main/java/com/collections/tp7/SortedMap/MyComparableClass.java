package com.collections.tp7.SortedMap;

public class MyComparableClass implements Comparable<MyComparableClass> {

  private String elem;
  public String sortableIdentifier;

  public MyComparableClass(String comparableElement) {
    this.elem = comparableElement;
  }

  @Override
  public int compareTo(MyComparableClass other) {
    return this.sortableIdentifier.compareTo(other.sortableIdentifier);
  }

  @Override
  public String toString() {
    return "%s - (%s)".formatted(elem, sortableIdentifier);
  }

}
