package com.talleres.tallerAirport;

import java.util.Arrays;
import java.util.function.Function;

public class AirPort {

  private Counter[] counters;
  private int initialSize = 10, ocupiedCounters = 0;

  public AirPort() {
    counters = new Counter[initialSize];
  }

  public Counter addCounter(String airlineName) {
    if (ocupiedCounters == counters.length) {
      counters = Arrays.copyOf(counters, counters.length + initialSize);
    }
    counters[ocupiedCounters] = new Counter(airlineName, ocupiedCounters);
    return counters[ocupiedCounters++];
  }

  public Counter[] airlineOrderCounters() {
    Counter[] sortedCounters = Arrays.copyOf(counters, ocupiedCounters);
    Arrays.sort(sortedCounters);
    return sortedCounters;
  }
  
  public Counter[] airlineDescendingOrderCounters() {
    Counter[] sortedCounters = Arrays.copyOf(counters, ocupiedCounters);
    Arrays.sort(sortedCounters, (a, b) -> { return b.compareTo(a); });
    return sortedCounters;
  }

  public void counterCheckIn(Function<Counter, Boolean> conditionToCheckIn) {
    for (int i = 0; i < ocupiedCounters; ++i) {
      if (conditionToCheckIn.apply(counters[i])) {
        counters[i].checkIn();
        return;
      }
    }
  }

}
