package com.collections.tp6.peopleCollection;

import java.util.List;

public interface PersonCollection {

  void addPerson(Person aPerson);

  List<Person> findByLastName(String lastName);

  Person findByName(String firstName, String lastName);

}
