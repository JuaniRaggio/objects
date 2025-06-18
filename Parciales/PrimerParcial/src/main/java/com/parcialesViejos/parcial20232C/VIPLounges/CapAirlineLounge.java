package com.parcialesViejos.parcial20232C.VIPLounges;

public class CapAirlineLounge extends CapLounge {

  protected String airlineName;

  public CapAirlineLounge(LoungeCentral associatedCentral, String name, int cap, String airlineName) {
    super(associatedCentral, name, cap);
    this.airlineName = airlineName;
  }

  @Override
  public void enter(Passenger customer) {
    checkRequirements(() -> customer.getAirline().equals(airlineName));
    super.enter(customer);
  }

  @Override
  public String toString() {
      return "%s ".formatted(airlineName) + super.toString();
  }
  
}
