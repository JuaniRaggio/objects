package com.parcialesViejos.parcial20201C.Element;

public class RepeatableElement extends Element {

  private Element element;
  private int repetitions;

  public RepeatableElement(Element element, int times) {
    if (repetitions <= 0) {
      throw new IllegalArgumentException();
    }
    this.element = element;
    this.repetitions = times;
  }

  @Override
  public String getContents() {
    StringBuilder returnValue = new StringBuilder();
    for (int i = repetitions; i > 0; --i) {
      returnValue.append(element.getContents());
      if (i - 1 > 0) {
        returnValue.append('\n');
      }
    }
    return returnValue.toString();
  }

}
