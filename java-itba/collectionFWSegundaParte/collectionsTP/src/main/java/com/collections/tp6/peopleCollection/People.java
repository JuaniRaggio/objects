package com.collections.tp6.peopleCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class People implements PersonCollection {

  private Map<String, Map<String, Person>> people = new HashMap<>();

  public void addPerson(Person aPerson) {
    people.putIfAbsent(aPerson.getLastName(), new HashMap<String, Person>());
    people.get(aPerson.getLastName()).putIfAbsent(aPerson.getFirstName(), aPerson);
  }

  public List<Person> findByLastName(String lastName) {
    return new ArrayList<>(people.get(lastName).values());
  }

  public Person findByName(String firstName, String lastName) {
    return people.get(lastName) == null ? null: people.get(lastName).getOrDefault(firstName, null);
  }

}
