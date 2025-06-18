package com.collections.tp7.HelpDesk;

import org.junit.jupiter.api.Test;

public class HelpDeskTest {

  @Test
  public void HDTest() {
    HelpDesk helpDesk = new HelpDesk();

    // Abre un ticket para un cliente Business de nombre ITBA con la pregunta Question 1
    helpDesk.openTicket(ClientType.BUSINESS, "ITBA", "Question 1");

    helpDesk.openTicket(ClientType.RESIDENTIAL, "Foo", "Question 2")
      .openTicket(ClientType.BUSINESS, "ACME", "Question 3")
      .openTicket(ClientType.GOVERNMENT, "Arg", "Question 4")
      .openTicket(ClientType.RESIDENTIAL, "Bar", "Question 5")
      .openTicket(ClientType.RESIDENTIAL, "Foo", "Question 6");

    // Obtiene el próximo ticket a resolver para los clientes Business
    // en orden de apertura de los tickets y luego se lo elimina
    HelpDesk.HelpTicket ticket = helpDesk.getNextTicket(ClientType.BUSINESS);
    System.out.println(ticket); // HelpTicket for ITBA asking Question 1

    ticket = helpDesk.getNextTicket(ClientType.BUSINESS);
    System.out.println(ticket); // HelpTicket for ACME asking Question 3

    try {
      ticket = helpDesk.getNextTicket(ClientType.BUSINESS);
    } catch (Exception ex) {
      System.out.println(ex.getClass()); // class java.util.NoSuchElementException
    }

    // Obtiene el próximo ticket a resolver para los clientes de todas las categorías
    // tomando primero los clientes Government, luego Business y por último Residential
    // y desempata por orden de apertura de los tickets
    // y luego se lo elimina
    while(helpDesk.hasTickets()) {
      ticket = helpDesk.getNextTicket();
      System.out.println(ticket);
    }
    /**
         * HelpTicket for Arg asking Question 4
         * HelpTicket for Foo asking Question 2
         * HelpTicket for Bar asking Question 5
         * HelpTicket for Foo asking Question 6
         */
  }

}
