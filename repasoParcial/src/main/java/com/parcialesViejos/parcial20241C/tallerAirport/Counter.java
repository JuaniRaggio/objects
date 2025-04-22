package com.talleres.tallerAirport;

public class Counter implements Comparable<Counter> {

  private String airlineName;
  private int counterNumberAssigned;
  private boolean checkingIn;

  public Counter(String airlineName, int counterNumberAssigned) {
    this.checkingIn = false;
    this.airlineName = airlineName;
    this.counterNumberAssigned = counterNumberAssigned;
  }

  public void checkIn() { checkingIn = true; }

  public boolean isCheckingIn() { return checkingIn; }

  public String getAirlineName() { return airlineName; }

  @Override
  public String toString() {
    return String.format("Counter %d for %s is %s", counterNumberAssigned,
        airlineName, checkingIn ? "checking in" : "idle");
  }

  @Override
  public int compareTo(Counter other) {
    int cmp = airlineName.compareTo(other.airlineName);
    if (cmp == 0) {
      return counterNumberAssigned - other.counterNumberAssigned;
    }
    return cmp;
  }

}
