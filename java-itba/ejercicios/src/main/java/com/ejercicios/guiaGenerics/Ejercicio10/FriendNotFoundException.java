package com.ejercicios.guiaGenerics.Ejercicio10;

public class FriendNotFoundException extends FriendsException {

  private static final String msg = "Friend not found";

  public FriendNotFoundException(String friend) {
    super(friend, msg);
  }

}
