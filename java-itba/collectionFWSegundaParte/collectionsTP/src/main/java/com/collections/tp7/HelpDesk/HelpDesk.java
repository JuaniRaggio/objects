package com.collections.tp7.HelpDesk;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class HelpDesk {

  // No es una PriorityQueue porque el mapa ya mantiene ordenado por el orden ordial del Enum
  private Map<ClientType, LinkedList<HelpTicket>> helpTickets = new TreeMap<>(Comparator.reverseOrder());

  public HelpDesk openTicket(ClientType type, String ticketName, String question) {
    if (!helpTickets.containsKey(type)) {
      helpTickets.put(type, new LinkedList<>());
    }
    helpTickets.get(type).addLast(new HelpTicket(ticketName, question));
    return this;
  }

  public boolean hasTickets(ClientType type) {
    return helpTickets.containsKey(type) && !helpTickets.get(type).isEmpty();
  }

  public boolean hasTickets() {
    for (ClientType ht : ClientType.values()) {
        if (hasTickets(ht)) return true;
    }
    return false;
  }

  public HelpTicket getNextTicket(ClientType type) {
    if (!hasTickets(type)) {
      throw new NoSuchElementException();
    }
    return helpTickets.get(type).pop();
  }

  public HelpTicket getNextTicket() {
    for (LinkedList<HelpTicket> helpTicketsGetter : helpTickets.values()) {
      if (!helpTicketsGetter.isEmpty()) {
        return helpTicketsGetter.pop();
      }
    }
    throw new NoSuchElementException();
  }

  public class HelpTicket {

    private final String name, question;

    public HelpTicket(String name, String question) {
      this.name = name;
      this.question = question;
    }

    public String toString() {
      return "%s asking %s".formatted(name, question);
    }

  }

}
