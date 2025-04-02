package com.ejercicios.guiaGenerics.Ejercicio10;

public class AlreadyExistsFriendException extends FriendsException {

  private static final String msg = "Friend already exists";

  public AlreadyExistsFriendException(String friend) {
    super(friend, msg);
  }

}
