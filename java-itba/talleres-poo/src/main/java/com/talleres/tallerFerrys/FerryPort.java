package com.talleres.tallerFerrys;

import java.time.LocalTime;

public class FerryPort extends Port {

  public FerryPort(String name, FerryCompany company, int docks) {
    super(name, company, docks);
  }

  public void dock(Ferry ferry, LocalTime time) {
    super.dock(() -> canDock(ferry));
  }

  public void undock(Ferry ferry, LocalTime time) {
    super.undock(() -> canUndock(ferry));
  }

}
