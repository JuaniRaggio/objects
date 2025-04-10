package com.talleres.tallerFerrys;

import java.time.LocalTime;

public abstract class Port {

  protected String name;
  protected FerryCompany company;
  protected int docks, ocupiedDocks = 0;

  protected Port(String name, FerryCompany company, int docks) {
    this.name = name;
    this.company = company;
    this.docks = docks;
  }

  private boolean isEmptyFerryPort() { return ocupiedDocks == 0; }
  
  private boolean isFullFerryPort() { return ocupiedDocks == docks; }

  private boolean isCertifiedCompany(Ferry ferry) {
    return ferry.getCompany().equals(company);
  }

  protected boolean canDock(Ferry ferry) {
    return !isFullFerryPort() && isCertifiedCompany(ferry);
  }

  protected boolean canUndock(Ferry ferry) {
    return !isEmptyFerryPort() && isCertifiedCompany(ferry);
  }

  public abstract void dock(Ferry ferry, LocalTime time);

  public abstract void undock(Ferry ferry, LocalTime time);

}
