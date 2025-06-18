package com.ejercicios.guiaGenerics.Ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HTMLTest {

  @Test
  public void testHTML() {
    PlainText text = new PlainText("Hola");
    HTMLText boldText = new BoldText(text);
    HTMLText italicText = new ItalicText(text);

    assertEquals("<b>Hola</b>", boldText.toString());
    assertEquals("<i>Hola</i>", italicText.toString());

    HTMLText boldItalicText = new BoldText(italicText);
    assertEquals("<b><i>Hola</i></b>", boldItalicText.toString());

    text.setText("ITBA");
    // Aca me esta diciendo ojo que si cambio el plain text, cambia en bold
    // entonces si o si bold tiene un puntero a plain text
    assertEquals("<b>ITBA</b>", boldText.toString());
    assertEquals("<i>ITBA</i>", italicText.toString());
    assertEquals("<b><i>ITBA</i></b>", boldItalicText.toString());

    HTMLText linkText = new LinkText(text, "itba.edu.ar");
    HTMLText linkBoldText1 = new LinkText(boldItalicText, "itba.edu.ar");
    HTMLText linkBoldText2 = new BoldText(linkText);
    assertEquals("<a href:itba.edu.ar>ITBA</a>", linkText.toString());
    assertEquals("<a href:itba.edu.ar><b><i>ITBA</i></b></a>",
      linkBoldText1.toString());
    assertEquals("<b><a href:itba.edu.ar>ITBA</a></b>",
      linkBoldText2.toString());
    text.setText("Ejemplo");
    assertEquals("<a href:itba.edu.ar><b><i>Ejemplo</i></b></a>",
      linkBoldText1.toString());
    assertEquals("<b><a href:itba.edu.ar>Ejemplo</a></b>",
      linkBoldText2.toString());
  }

}
