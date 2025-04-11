package com.talleres.tallerFerrys;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Time;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

// Este ejercicio es muy malo, no tiene ningun sentido
public class PuertosTest {

  @Test
  public void puertoTest() {

    // Ejemplo de uso de la clase java.time.LocalTime
    assertTrue(LocalTime.of(12, 15).isAfter(LocalTime.of(11, 15))); // true
    assertTrue(!LocalTime.of(12, 15).isBefore(LocalTime.of(11, 15))); // false

    // Se instancia una compañía de ferry TransLink
    FerryCompany transLink = new FerryCompany("Translink");

    // Se instancia un ferry Beaver de la compañía TransLink
    Ferry beaver = new Ferry("Beaver", transLink);
    Ferry otter = new Ferry("Otter II", transLink);
    Ferry pacificBreeze = new Ferry("Pacific Breeze", transLink);

    // Se instancia un puerto Waterfront de la compañía TransLink con 2 muelles
    // donde se pueden amarrar ferrys las 24hs
    FerryPort waterfront = new FerryPort("Waterfront", transLink, 2);
    // Beaver se amarra a un muelle del puerto Waterfront a las 09:00
    waterfront.dock(beaver, LocalTime.of(9, 0));
    // Ferry Beaver docked at Port Waterfront
    // Beaver se desamarra de un muelle del puerto Waterfront a las 09:05
    waterfront.undock(beaver, LocalTime.of(9, 5));
    // Ferry Beaver undocked at Port Waterfront
    // Falla porque todos los muelles de Waterfront están desocupados
    assertThrows(RuntimeException.class, () -> waterfront.undock(beaver, LocalTime.of(10, 10)));
    waterfront.dock(beaver, LocalTime.of(10, 0));
    // Ferry Beaver docked at Port Waterfront
    waterfront.dock(otter, LocalTime.of(10, 15));
    // Ferry Otter II docked at Port Waterfront
    // Falla porque todos los muelles están ocupados
    assertThrows(RuntimeException.class, () -> waterfront.dock(pacificBreeze, LocalTime.of(10, 10)));
    // No corresponde verificar que un ferry tuvo que ser amarrado para ser
    // desamarrado
    waterfront.undock(pacificBreeze, LocalTime.of(10, 20));
    // Ferry Pacific Breeze undocked at Port Waterfront
    // Falla porque las compañías no coincidden
    assertThrows(RuntimeException.class,
        () -> waterfront.dock(new Ferry("Spirit of Vancouver", new FerryCompany("BC Ferries")), LocalTime.of(10, 10)));
    // Se desamarra un ferry de una compañía distinta a la del puerto

    assertThrows(RuntimeException.class, () -> waterfront.undock(new Ferry("Spirit of Vancouver", new FerryCompany("BC Ferries")),
        LocalTime.of(10, 20)));
    // Ferry Spirit of Vancouver undocked at Port Waterfront
    // No corresponde verificar que un ferry amarrado no puede volver a amarrarse
    waterfront.dock(beaver, LocalTime.of(10, 0));
    // Ferry Beaver docked at Port Waterfront

    // Se instancia un puerto Lonsdale Quay de la compañía Translink con 3 muelles
    // donde se pueden amarrar ferrys entre las 09:00 y las 14:00
    TimeLimitedFerryPort londsdaleQuay = new TimeLimitedFerryPort("Lonsdale Quay",
        new FerryCompany("Translink"), 3, LocalTime.of(9, 0), LocalTime.of(14, 0));
    londsdaleQuay.dock(beaver, LocalTime.of(9, 0));
    // Ferry Beaver docked at Port Lonsdale Quay
    londsdaleQuay.dock(otter, LocalTime.of(12, 15));
    // Ferry Otter II docked at Port Lonsdale Quay
    // Falla porque no respeta los horarios de apertura y cierre
    assertThrows(RuntimeException.class, () -> londsdaleQuay.dock(beaver, LocalTime.of(15, 10)));
    londsdaleQuay.dock(beaver, LocalTime.of(14, 0));
    // Ferry Beaver docked at Port Lonsdale Quay
    // Se desamarra un ferry fuera de los horarios de apertura y cierre para los
    // amarres
    londsdaleQuay.undock(beaver, LocalTime.of(23, 0));
    // Ferry Beaver undocked at Port Lonsdale Quay

    // Se instancia un puerto Stanley Park de la compañía Translink con 3 muelles
    // donde se pueden amarrar ferrys entre las 09:00 y las 14:00
    // y sólo se puede desamarrar el último ferry amarrado (si es que se amarró uno)
    LastDockedFerry stanleyPark = new LastDockedFerry("Stanley Park", transLink, 3, LocalTime.of(9, 0),
        LocalTime.of(14, 0));
    // Falla porque no se amarró ningún ferry
    assertThrows(RuntimeException.class, () -> stanleyPark.undock(beaver, LocalTime.of(15, 10)));
    stanleyPark.dock(beaver, LocalTime.of(12, 10));
    // Ferry Beaver docked at Port Stanley Park
    stanleyPark.dock(otter, LocalTime.of(12, 15));
    // Ferry Otter II docked at Port Stanley Park
    // Falla porque el ferry a desamarrar no es el último amarrado
    assertThrows(RuntimeException.class, () -> stanleyPark.undock(beaver, LocalTime.of(15, 10)));
    stanleyPark.undock(otter, LocalTime.of(13, 10));
    // Ferry Otter II undocked at Port Stanley Park
    // Falla porque no se amarró ningún ferry después de desamarrar uno
    assertThrows(RuntimeException.class, () -> stanleyPark.undock(beaver, LocalTime.of(15, 10)));
  }
}
