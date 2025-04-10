package com.talleres.tallerAirport;

public class AirportTest {

  public void main() {

    // Se instancia un aeropuerto
    AirPort airPort = new AirPort();

    // Se instancia el mostrador 0 para Air Canada e inicia libre
    Counter counter0 = airPort.addCounter("Air Canada");
    System.out.println(counter0); // Counter 0 for Air Canada is idle
    Counter counter1 = airPort.addCounter("American Airlines");
    System.out.println(counter1); // Counter 1 for American Airlines is idle
    Counter counter2 = airPort.addCounter("American Airlines");
    System.out.println(counter2); // Counter 2 for American Airlines is idle
    airPort.addCounter("Air Canada");
    airPort.addCounter("LATAM");

    // Se inicia el check-in en el mostrador 1
    counter1.checkIn();
    System.out.println(counter1); // Counter 1 for American Airlines is checking in

    // Se obtienen los mostradores en orden alfabético por aerolínea
    // y desempata ascendente por número
    for(Counter counter : airPort.airlineOrderCounters()) {
      System.out.println(counter);
    }
    // Counter 0 for Air Canada is idle
    // Counter 3 for Air Canada is idle
    // Counter 1 for American Airlines is checking in
    // Counter 2 for American Airlines is idle
    // Counter 4 for LATAM is idle

    // Se obtienen los mostradores en orden descendente por aerolínea
    // y desempata descendente por número
    for(Counter counter : airPort.airlineDescendingOrderCounters()) {
      System.out.println(counter);
    }
    // Counter 4 for LATAM is idle
    // Counter 2 for American Airlines is idle
    // Counter 1 for American Airlines is checking in
    // Counter 3 for Air Canada is idle
    // Counter 0 for Air Canada is idle

    // Se inicia el check-in en el primer mostrador (en orden de inserción)
    // que cumpla las siguientes condiciones:
    // - No inició check-in
    // - La aerolínea empieza con la letra "A"
    // Si ningún mostrador cumple las condiciones no hace nada
    .......... idleAndStartsWithA = .............................................................................................;
    airPort.counterCheckIn(idleAndStartsWithA);
    System.out.println(counter0); // Counter 0 for Air Canada is checking in
    System.out.println(counter1); // Counter 1 for American Airlines is checking in
    System.out.println(counter2); // Counter 2 for American Airlines is idle

    airPort.counterCheckIn(idleAndStartsWithA);
    System.out.println(counter0); // Counter 0 for Air Canada is checking in
    System.out.println(counter1); // Counter 1 for American Airlines is checking in
    System.out.println(counter2); // Counter 2 for American Airlines is checking in
  }

}
