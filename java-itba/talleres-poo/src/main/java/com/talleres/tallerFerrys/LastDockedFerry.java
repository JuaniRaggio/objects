package com.talleres.tallerFerrys;

import java.time.LocalTime;
import java.util.ArrayList;

public class LastDockedFerry extends TimeLimitedFerryPort {

  private Ferry lastFerry;

  public LastDockedFerry(String name, FerryCompany company, int docks,
      LocalTime open, LocalTime close) {
    super(name, company, docks, open, close);
  }

  @Override
  public void dock(Ferry ferry, LocalTime time) {
    super.dock(ferry, time);
    lastFerry = ferry;
  }
  
  @Override
  public void undock(Ferry ferry, LocalTime time) {
    // No tieen ningun tipo de sentido esto pero es lo que pide el ejercicio
    if (!ferry.equals(lastFerry)) {
      throw new RuntimeException();
    }
    super.undock(ferry, time);
    lastFerry = null;
  }

}
