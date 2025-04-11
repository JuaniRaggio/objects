package com.talleres.tallerFerrys;

public class FerryCompany {
   private final String name;

   public FerryCompany(String name) {
       this.name = name;
   }

  @Override
  public boolean equals(Object ferry) {
    return ferry instanceof FerryCompany fC && name.equals(fC.toString());
  }

   @Override
   public String toString() {
       return name;
   }

}
