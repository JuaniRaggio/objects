package com.ejercicios.guiaGenerics.Ejercicio4;

public class BoldText extends Tag {

  private static final String tagName = "b";

  public BoldText(HTMLText text) {
    super(text, tagName);
  }

}

