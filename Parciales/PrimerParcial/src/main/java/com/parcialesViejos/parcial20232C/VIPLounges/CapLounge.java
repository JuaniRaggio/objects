package com.parcialesViejos.parcial20232C.VIPLounges;

public class CapLounge extends Lounge {

  private int cap;

  public CapLounge(LoungeCentral associatedCentral, String name, int cap) {
    super(associatedCentral, name);
    this.cap = cap;
  }

  @Override
  public void enter(Passenger customer) {
    checkRequirements(() -> cap > passengersEntered);
    super.enter(customer);
  }

  @Override
  public String toString() {
      return super.toString() + " up to %d guests".formatted(cap);
  }
  
}
