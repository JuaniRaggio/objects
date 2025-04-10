package com.talleres.tallerFerrys;

import java.time.LocalTime;

// Este ejercicio es muy malo, no tiene ningun sentido
public class PuertosTest {

  public void puertoTest() {

    // Ejemplo de uso de la clase java.time.LocalTime
    System.out.println(LocalTime.of(12, 15).isAfter(LocalTime.of(11, 15))); // true
    System.out.println(LocalTime.of(12, 15).isBefore(LocalTime.of(11, 15))); // false

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
    try { // Falla porque todos los muelles de Waterfront están desocupados
      waterfront.undock(beaver, LocalTime.of(10, 10));
    } catch (Exception ex) {
      System.out.println("Error"); // Error
    }
    waterfront.dock(beaver, LocalTime.of(10, 0));
    // Ferry Beaver docked at Port Waterfront
    waterfront.dock(otter, LocalTime.of(10, 15));
    // Ferry Otter II docked at Port Waterfront
    try { // Falla porque todos los muelles están ocupados
      waterfront.dock(pacificBreeze, LocalTime.of(10, 10));
    } catch (Exception ex) {
      System.out.println("Error"); // Error
    }
    // No corresponde verificar que un ferry tuvo que ser amarrado para ser desamarrado
    waterfront.undock(pacificBreeze, LocalTime.of(10, 20));
    // Ferry Pacific Breeze undocked at Port Waterfront
    try { // Falla porque las compañías no coincidden
      waterfront.dock(new Ferry("Spirit of Vancouver", new FerryCompany("BC Ferries")),
        LocalTime.of(10, 10));
    } catch (Exception ex) {
      System.out.println("Error"); // Error
    }
    // Se desamarra un ferry de una compañía distinta a la del puerto
    waterfront.undock(new Ferry("Spirit of Vancouver", new FerryCompany("BC Ferries")),
      LocalTime.of(10, 20));
    // Ferry Spirit of Vancouver undocked at Port Waterfront
    // No corresponde verificar que un ferry amarrado no puede volver a amarrarse      
    waterfront.dock(beaver, LocalTime.of(10, 0));
    // Ferry Beaver docked at Port Waterfront

    // Se instancia un puerto Lonsdale Quay de la compañía Translink con 3 muelles
    // donde se pueden amarrar ferrys entre las 09:00 y las 14:00
    .................... londsdaleQuay = new ....................("Lonsdale Quay",
           new FerryCompany("Translink"), 3, LocalTime.of(9, 0), LocalTime.of(14, 0));
    londsdaleQuay.dock(beaver, LocalTime.of(9, 0));
    // Ferry Beaver docked at Port Lonsdale Quay
    londsdaleQuay.dock(otter, LocalTime.of(12, 15));
    // Ferry Otter II docked at Port Lonsdale Quay
    try { // Falla porque no respeta los horarios de apertura y cierre
      londsdaleQuay.dock(beaver, LocalTime.of(15, 10));
    } catch (Exception ex) {
      System.out.println("Error"); // Error
    }
    londsdaleQuay.dock(beaver, LocalTime.of(14, 0));
    // Ferry Beaver docked at Port Lonsdale Quay
    // Se desamarra un ferry fuera de los horarios de apertura y cierre para los amarres
    londsdaleQuay.undock(beaver, LocalTime.of(23, 0));
    // Ferry Beaver undocked at Port Lonsdale Quay

    // Se instancia un puerto Stanley Park de la compañía Translink con 3 muelles
    // donde se pueden amarrar ferrys entre las 09:00 y las 14:00
    // y sólo se puede desamarrar el último ferry amarrado (si es que se amarró uno)
    .................... stanleyPark = new ....................("Stanley Park", transLink, 3, LocalTime.of(9, 0), LocalTime.of(14, 0));
    try { // Falla porque no se amarró ningún ferry
      stanleyPark.undock(beaver, LocalTime.of(15, 10));
    } catch (Exception ex) {
      System.out.println("Error"); // Error
    }
    stanleyPark.dock(beaver, LocalTime.of(12, 10));
    // Ferry Beaver docked at Port Stanley Park
    stanleyPark.dock(otter, LocalTime.of(12, 15));
    // Ferry Otter II docked at Port Stanley Park
    try { // Falla porque el ferry a desamarrar no es el último amarrado
      stanleyPark.undock(beaver, LocalTime.of(15, 10));
    } catch (Exception ex) {
      System.out.println("Error"); // Error
    }
    stanleyPark.undock(otter, LocalTime.of(13, 10));
    // Ferry Otter II undocked at Port Stanley Park
    try { // Falla porque no se amarró ningún ferry después de desamarrar uno
      stanleyPark.undock(beaver, LocalTime.of(15, 10));
    } catch (Exception ex) {
      System.out.println("Error"); // Error
    }

  }
}
