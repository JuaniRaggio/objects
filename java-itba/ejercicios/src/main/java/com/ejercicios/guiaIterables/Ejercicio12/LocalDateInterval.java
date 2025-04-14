package com.ejercicios.guiaIterables.Ejercicio12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LocalDateInterval implements Iterable<LocalDate> {

  private LocalDate[] interval;

  private void create(LocalDate startingDay, LocalDate finishingDay, long stepSize) {
    // The plus 1 if so that the last day is included
    int days = ((int) Math.divideExact(ChronoUnit.DAYS.between(startingDay, finishingDay), stepSize)) + 1;
    interval = new LocalDate[days];
  }

  private void setDates(LocalDate startingDay, LocalDate finishingDay, long stepSize) {
    LocalDate dates = LocalDate.of(startingDay.getYear(), startingDay.getMonth(), startingDay.getDayOfMonth());
    for (int i = 0; i < interval.length; ++i) {
      interval[i] = dates.plusDays(i * stepSize);
    }
  }

  public LocalDateInterval(LocalDate startingDay, LocalDate finishingDay, long stepSize) {
    create(startingDay, finishingDay, stepSize);
    setDates(startingDay, finishingDay, stepSize);
  }

  @Override
  public Iterator<LocalDate> iterator() {
      return new Iterator<LocalDate>() {

        private int currentIdx = 0;

        @Override
        public boolean hasNext() {
            return currentIdx < interval.length;
        }

        @Override
        public LocalDate next() {
          if (!hasNext())
            throw new NoSuchElementException();
          return interval[currentIdx++];
        }

      };
  }

}
