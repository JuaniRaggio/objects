package com.parcialesViejos.parcial20232C.VIPLounges;

import java.util.function.Supplier;

public class Lounge {

  protected LoungeCentral associatedCentral;
  protected final String name;
  protected int passengersEntered;

  protected boolean hasPassesLeft(Passenger customer) {
    return customer.availablePasses() > 0;
  }

  protected void checkRequirements(Supplier<Boolean> requirements) {
    if (requirements.get()) {
      return;
    }
    throw new RuntimeException("Cannot enter Lounge");
  }

  public Lounge(LoungeCentral associatedCentral, String name) {
    this.associatedCentral = associatedCentral;
    this.name = name;
  }

  public void enter(Passenger customer) {
    checkRequirements(() -> associatedCentral.isOpen() &&
                            hasPassesLeft(customer));
    customer.consumePass();
    ++passengersEntered;
  }

  public void exit() {
    exit(1);
  }

  public void exit(int amount) {
    if (passengersEntered < amount) {
      throw new IllegalStateException("Lounge is empty");
    }
    passengersEntered = passengersEntered - amount;
  }

  @Override
  public String toString() {
      return "%s has %d guests".formatted(name, passengersEntered);
  }
  
}
