package com.ayudantia.ejemplos_prueba;

public interface InterfazIzquierda {

    default void metodoDeInterfaz() {
        System.out.println("Aca printeo");
    }

    void add();

    boolean contains();
    
}
