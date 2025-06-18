package com.ejercicios.guiaGenerics.Ejercicio4;

public class ItalicText extends Tag {

  private static final String tagName = "i";

  public ItalicText(HTMLText text) {
    super(text, tagName);
  }

}
