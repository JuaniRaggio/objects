package com.talleres.tallerFerrys;

public class Ferry {
   private final String name;
   private final FerryCompany company;
  
   public Ferry(String name, FerryCompany c) {
       this.name = name;
       this.company = c;
   }

   public FerryCompany getCompany() {
       return company;
   }

   @Override
   public String toString() {
       return "Ferry %s".formatted(name);
   }
}
