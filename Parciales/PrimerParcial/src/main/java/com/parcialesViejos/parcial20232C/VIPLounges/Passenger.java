package com.parcialesViejos.parcial20232C.VIPLounges;

public class Passenger {

  private final String name;
  private final String airline;
  private int passes;

  public Passenger(String name, String airline, int passes) {
    if (passes < 0) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.airline = airline;
    this.passes = passes;
  }

  public String getName() { return name; }

  public String getAirline() { return airline; }

  public void consumePass() {
    if (passes <= 0) {
      throw new IllegalStateException();
    }
    --passes;
  }

  public int availablePasses() { return passes; }
  
}
