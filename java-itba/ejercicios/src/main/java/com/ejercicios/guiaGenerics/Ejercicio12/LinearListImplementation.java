package com.ejercicios.guiaGenerics.Ejercicio12;

public class LinearListImplementation implements LinearList {

  private int size;

  private LinearListHeader head;

  public LinearListImplementation() {
    size = 0;
    head = null;
  }

   public void add(Object obj) {
    head = head.add(obj);
  }

   Object get(int i) {}

   /**
    * Modifica el i-ésimo elemento de la lista colocando un nuevo valor.
    */
   void set(int i, Object obj) {}

   /**
    * Elimina el i-ésimo elemento de la lista.
    */
   void remove(int i) {}

   /**
    * Busca el índice de la primer ocurrencia de un objeto en la lista.
    */
   int indexOf(Object obj) {}

   /**
    * Retorna el tamaño de la lista.
    */
   int size() {}

}
