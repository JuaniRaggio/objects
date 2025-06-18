package com.ejercicios.guiaGenerics.Ejercicio10;

public class TooManyFriendsException extends FriendsException {

  private static final String msg = "Too many friends";

  public TooManyFriendsException(String friend) {
    super(friend, msg);
  }

}
