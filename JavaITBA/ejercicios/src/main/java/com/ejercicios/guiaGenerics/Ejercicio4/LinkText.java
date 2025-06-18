package com.ejercicios.guiaGenerics.Ejercicio4;

public class LinkText extends Tag {

  private static final String tagName = "a";

  public LinkText(HTMLText text, String href) {
    super(text, tagName, href);
  }

}

