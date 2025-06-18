package com.ejercicios.guiaGenerics.Ejercicio4;

public class Tag implements HTMLText {

  private HTMLText txt;

  private String tagName, reference;

  public Tag(HTMLText txt, String tagName) {
    this.txt = txt;
    this.tagName = tagName;
    this.reference = "";
  }


  public Tag(HTMLText txt, String tagName, String reference) {
    this(txt, tagName);
    this.reference = String.format(" href:%s", reference);
  }

  @Override
  public String toString() {
    return String.format("<%s%s>%s</%s>", tagName, reference, txt, tagName);
  }

  @Override
  public String source() {
    return toString();
  }

}
