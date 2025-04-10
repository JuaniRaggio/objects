package com.talleres.tallerFerrys;

import java.time.LocalTime;

public class TimeLimitedFerryPort extends Port {

  private LocalTime open, close;

  public TimeLimitedFerryPort(String name, FerryCompany company, int docks,
      LocalTime open, LocalTime close) {
    super(name, company, docks);
    this.open = open;
    this.close = close;
  }

  private boolean isOpened(LocalTime time) {
    return time.compareTo(open) > 0 && time.compareTo(close) < 0;
  }

  @Override
  public void dock(Ferry ferry, LocalTime time) {
    if (!canDock(ferry) || !isOpened(time)) {
      throw new RuntimeException();
    }
    ++ocupiedDocks;
  }

  @Override
  public void undock(Ferry ferry, LocalTime time) {
    if (!canDock(ferry) || !isOpened(time)) {
      throw new RuntimeException();
    }
    --ocupiedDocks;
  }

}
