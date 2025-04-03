package com.ejercicios.guiaGenerics.Ejercicio10;

public class FriendsException extends Exception {

  protected String friend, msg;

  public FriendsException(String friend, String msg) {
    this.friend = friend;
    this.msg = msg;
  }

  @Override
  public String getMessage() {
    return String.format("Error for number %s: %s", friend, msg);
  }

}
