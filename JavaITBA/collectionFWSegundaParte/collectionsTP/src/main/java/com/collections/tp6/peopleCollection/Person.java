package com.collections.tp6.peopleCollection;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

  private final String firstName, lastName;
  private final LocalDate bornDate;

  public Person(String firstName, String lastName, LocalDate bornDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.bornDate = bornDate;
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof Person person &&
      firstName.equals(person.firstName) &&
      lastName.equals(person.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return "Person{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", bornDate=" + bornDate +
      '}';
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

}
