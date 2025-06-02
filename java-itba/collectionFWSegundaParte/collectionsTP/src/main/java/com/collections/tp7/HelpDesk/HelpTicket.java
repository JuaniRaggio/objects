package com.collections.tp7.HelpDesk;

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
