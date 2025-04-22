package com.talleres.tallerFerrys;

import java.util.function.Supplier;

public abstract class Port {

  protected String name;
  protected FerryCompany company;
  protected int docks, ocupiedDocks = 0;

  protected Port(String name, FerryCompany company, int docks) {
    this.name = name;
    this.company = company;
    this.docks = docks;
  }

  private Boolean isEmptyFerryPort() { return ocupiedDocks == 0; }
  
  private Boolean isFullFerryPort() { return ocupiedDocks == docks; }

  private Boolean isCertifiedCompany(Ferry ferry) {
    return ferry.getCompany().equals(company);
  }

  protected Boolean canDock(Ferry ferry) {
    return !isFullFerryPort() && isCertifiedCompany(ferry);
  }

  protected Boolean canUndock(Ferry ferry) {
    return !isEmptyFerryPort() && isCertifiedCompany(ferry);
  }

  protected void dock(Supplier<Boolean> conditionToDock) {
    if (!conditionToDock.get()) {
      throw new RuntimeException();
    }
    ++ocupiedDocks;
  }

  protected void undock(Supplier<Boolean> conditionToUndock) {
    if (!conditionToUndock.get()) {
      throw new RuntimeException();
    }
    --ocupiedDocks;
  }

}
