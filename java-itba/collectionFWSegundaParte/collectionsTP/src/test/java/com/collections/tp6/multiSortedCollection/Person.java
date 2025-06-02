package com.collections.tp6.multiSortedCollection;

import java.util.Objects;

public class Person {
  private int age;
  private String name;

  public Person(String name, int age) {
    this.age = age;
    this.name = name;
  }

  public String getName() { return name; }

  public int getAge() { return age; }

  public String toString() { return "%s age: %d".formatted(name, age); }


  @Override
  public boolean equals(Object o) {
    return o instanceof Person person && name.equals(person.name) && age == person.age;
  }


  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}

