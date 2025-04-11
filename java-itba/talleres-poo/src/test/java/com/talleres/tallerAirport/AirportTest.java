package com.talleres.tallerAirport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class AirportTest {

  @Test
  public void main() {

    // Se instancia un aeropuerto
    AirPort airPort = new AirPort();

    // Se instancia el mostrador 0 para Air Canada e inicia libre
    Counter counter0 = airPort.addCounter("Air Canada");
    assertEquals(counter0.toString(),"Counter 0 for Air Canada is idle" ); // Counter 0 for Air Canada is idle
    Counter counter1 = airPort.addCounter("American Airlines");
    assertEquals(counter1.toString(),"Counter 1 for American Airlines is idle" ); // Counter 1 for American Airlines is idle
    Counter counter2 = airPort.addCounter("American Airlines");
    assertEquals(counter2.toString(),"Counter 2 for American Airlines is idle" ); // Counter 2 for American Airlines is idle
    airPort.addCounter("Air Canada");
    airPort.addCounter("LATAM");

    // Se inicia el check-in en el mostrador 1
    counter1.checkIn();
    assertEquals(counter1.toString(),"Counter 1 for American Airlines is checking in" ); // Counter 1 for American Airlines is checking in

    // Se obtienen los mostradores en orden alfabético por aerolínea
    // y desempata ascendente por número
    String[] str = {
      "Counter 0 for Air Canada is idle",
      "Counter 3 for Air Canada is idle",
      "Counter 1 for American Airlines is checking in",
      "Counter 2 for American Airlines is idle",
      "Counter 4 for LATAM is idle"
    };
    int i = 0;
    for(Counter counter : airPort.airlineOrderCounters()) {
      assertEquals(counter.toString(), str[i++]);
    }

    // Se obtienen los mostradores en orden descendente por aerolínea
    // y desempata descendente por número
    String[] str2 = {
      "Counter 4 for LATAM is idle",
      "Counter 2 for American Airlines is idle",
      "Counter 1 for American Airlines is checking in",
      "Counter 3 for Air Canada is idle",
      "Counter 0 for Air Canada is idle"
    };
    i = 0;
    for(Counter counter : airPort.airlineDescendingOrderCounters()) {
      assertEquals(counter.toString(), str2[i++]);
    }

    // Se inicia el check-in en el primer mostrador (en orden de inserción)
    // que cumpla las siguientes condiciones:
    // - No inició check-in
    // - La aerolínea empieza con la letra "A"
    // Si ningún mostrador cumple las condiciones no hace nada
    Function<Counter, Boolean> idleAndStartsWithA = (a) -> {
      return !a.isCheckingIn() && a.getAirlineName().startsWith("A");
    };
    airPort.counterCheckIn(idleAndStartsWithA);
    assertEquals(counter0.toString(),"Counter 0 for Air Canada is checking in" ); // Counter 0 for Air Canada is checking in
    assertEquals(counter1.toString(),"Counter 1 for American Airlines is checking in" ); // Counter 1 for American Airlines is checking in
    assertEquals(counter2.toString(),"Counter 2 for American Airlines is idle" ); // Counter 2 for American Airlines is idle

    airPort.counterCheckIn(idleAndStartsWithA);
    assertEquals(counter0.toString(),"Counter 0 for Air Canada is checking in" ); // Counter 0 for Air Canada is checking in
    assertEquals(counter1.toString(),"Counter 1 for American Airlines is checking in" ); // Counter 1 for American Airlines is checking in
    assertEquals(counter2.toString(),"Counter 2 for American Airlines is checking in" ); // Counter 2 for American Airlines is checking in
  }

}
