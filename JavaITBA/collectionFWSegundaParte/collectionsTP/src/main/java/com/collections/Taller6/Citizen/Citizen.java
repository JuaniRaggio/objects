package com.collections.Taller6.Citizen;

public class Citizen {

  private String dni, name, surname;

  public Citizen(String dni, String name, String surname) {
    this.dni = dni;
    this.name = name;
    this.surname = surname;
  }

  public String getDni() {
      return dni;
  }

  public String getName() {
      return name;
  }

  public String getSurname() {
      return surname;
  }
  
}
