package com.ejercicios.guiaGenerics.Ejercicio10;

import java.util.Arrays;

public class CellPhoneBill {

   private String number;
   protected Call[] calls;
   protected int callsIndex;

   private static final int DEFAULT_SIZE = 10;

   CellPhoneBill(String number) {
       this.number = number;
       this.calls = new Call[DEFAULT_SIZE];
   }

   public void registerCall(String toNumber, int duration) {
       addCall(new Call(number, toNumber, duration));
   }

   private void addCall(Call call) {
       if(callsIndex == calls.length) {
           resize();
       }
       calls[callsIndex++] = call;
   }

   public double processBill() {
       double total = 0;
       for (int i = 0; i < callsIndex; i++) {
           total += calls[i].getCost();
       }
       return total;
   }

   private void resize() {
       calls = Arrays.copyOf(calls, calls.length + DEFAULT_SIZE);
   }

}
