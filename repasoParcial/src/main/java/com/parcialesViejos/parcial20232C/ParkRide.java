// package com.parcialesViejos.parcial20232C;
//
// import java.time.LocalTime;
// import java.util.Iterator;
// import java.util.NoSuchElementException;
//
// public class ParkRide implements Iterable<ParkSlot> {
//
//   private String name;
//   private LocalTime opening, closing;
//   private long timePerSlot;
//
//   public ParkRide(String name, LocalTime opening, LocalTime closing, long timePerSlot) {
//     if (timePerSlot <= 0)
//       throw new IllegalArgumentException("Time per slot must be greater than 0");
//
//     this.name = name;
//     if (opening.isAfter(closing))
//       throw new IllegalArgumentException("Opening hours should be before closing hours");
//
//     this.opening = opening;
//     this.closing = closing;
//     this.timePerSlot = timePerSlot;
//   }
//
//   public Iterator<ParkSlot> iterator() {
//     return new Iterator<ParkSlot>() {
//       private LocalTime currentSlot = opening, lastSlot = closing;
//
//       @Override
//       public ParkSlot next() {
//         if (!hasNext())
//           throw new NoSuchElementException();
//         ParkSlot returnValue = new ParkSlot(currentSlot);
//         currentSlot.plusMinutes(timePerSlot);
//       }
//
//       @Override
//       public boolean hasNext() {
//         return currentSlot.isAfter(lastSlot);
//       }
//     };
//   }
//
// }
