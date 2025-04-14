  // Tests were passed successfully, I'm commenting them so that I don't have
  // extra stuff being printed


// package com.ejercicios.guiaIterables.Ejercicio12;
//
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
//
// import java.time.LocalDate;
// import java.util.Iterator;
//
// import org.junit.jupiter.api.Test;
//
// public class LocalDateIntervalTest {
//
//   private LocalDate today = LocalDate.of(2020, 3, 1);
//   private LocalDate todayPlus10 = today.plusDays(10);
//
//   @Test
//   public void localDateTest() {
//     // Ejemplo de uso de la clase LocalDate
//     assertEquals("2020-03-01", today.toString());
//     assertEquals("2020-03-11", todayPlus10.toString());
//     assertTrue(todayPlus10.isAfter(today));
//   }
//
//
// @Test
// public void localDateIntervalTest() {
//   // Ejemplo de uso de la clase LocalDateInterval
//   LocalDateInterval localDateInterval = new LocalDateInterval(today,
//       todayPlus10, 3);
//   for (LocalDate localDate : localDateInterval) {
//     System.out.println(localDate);
//   }
// }
// 
// @Test
// public void localDateIntervalIteration() {
//   Iterator<LocalDate> localDateIterator = new LocalDateInterval(today,
//       today.plusDays(2), 1).iterator();
//   while (localDateIterator.hasNext()) {
//     System.out.println(localDateIterator.next());
//   }
// }
//
// }
