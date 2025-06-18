package com.parcialesViejos.parcial20232C.slots;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParkRide implements Iterable<ParkSlot> {

  private String name;
  private LocalTime opening, closing;
  private long timePerSlot;

  private void throwsIfTrue(boolean proposition, String errorMsg) {
    if (proposition) {
      throw new IllegalArgumentException(errorMsg);
    }
  }

  public ParkRide(String name, LocalTime opening, LocalTime closing, long timePerSlot) {
    throwsIfTrue(timePerSlot <= 0, "Time per slot must be greater than 0");
    throwsIfTrue(opening.isAfter(closing), "Opening hours should be before closing hours");
    this.name = name;
    this.opening = opening;
    this.closing = closing;
    this.timePerSlot = timePerSlot;
  }

  public Iterator<ParkSlot> iterator() {
    return new Iterator<ParkSlot>() {
      private LocalTime currentSlot = opening, lastSlot = closing;

      @Override
      public ParkSlot next() {
        if (!hasNext())
          throw new NoSuchElementException();
        ParkSlot returnValue = new ParkSlot(currentSlot);
        currentSlot.plusMinutes(timePerSlot);
        return returnValue;
      }

      @Override
      public boolean hasNext() {
        return currentSlot.isAfter(lastSlot);
      }
    };
  }

}
