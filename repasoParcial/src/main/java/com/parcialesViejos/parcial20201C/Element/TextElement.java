package com.parcialesViejos.parcial20201C.Element;

public class TextElement extends Element {

  private final String text;

  public TextElement(String text) {
    this.text = text;
  }

  @Override
  public String getContents() {
    return text;
  }
  
}
