package com.ejercicios.guiaIterables.Ejercicio12;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LocalDateInterval implements Iterable<LocalDate> {

  private final LocalDate start, finish;
  private final long stepSize;

  public LocalDateInterval(LocalDate startingDay, LocalDate finishingDay, long stepSize) {
    if (stepSize == 0)
      throw new IllegalArgumentException();
    this.start = startingDay;
    this.finish = finishingDay;
    this.stepSize = stepSize;
  }

  @Override
  public Iterator<LocalDate> iterator() {
    return new Iterator<LocalDate>() {

      private LocalDate currentIdDate = start;

      @Override
      public boolean hasNext() {
        return currentIdDate.isBefore(finish) || currentIdDate.isEqual(finish);
      }

      @Override
      public LocalDate next() {
        if (!hasNext())
          throw new NoSuchElementException();
        LocalDate returnValue = currentIdDate;
        currentIdDate = currentIdDate.plusDays(stepSize);
        return returnValue;
      }

    };
  }

}
