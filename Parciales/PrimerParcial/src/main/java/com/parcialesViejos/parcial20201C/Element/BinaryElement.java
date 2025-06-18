package com.parcialesViejos.parcial20201C.Element;

public class BinaryElement extends Element {

  private Element below, above;

  public BinaryElement(Element above, Element below) {
    this.above = above;
    this.below = below;
  }
  
  @Override
  public String getContents() {
    return "%s\n%s".formatted(above.getContents(), below.getContents());
  }

}
