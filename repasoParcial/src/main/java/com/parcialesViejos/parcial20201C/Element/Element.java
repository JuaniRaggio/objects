package com.parcialesViejos.parcial20201C.Element;

public abstract class Element {

  public abstract String getContents();

  @Override
  public String toString() {
    return getContents();
  }

  public Element above(Element element) {
    return new BinaryElement(element, this);
  }

  public Element below(Element element) {
    return new BinaryElement(this, element);
  }

  public Element RepeatableElement(int times) {
    return new RepeatableElement(this, times);
  }

}
