package com.ejercicios.guiaGenerics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class pruebaTest {

    @Test
    public void testSuma() {
        prueba ejercicio01 = new prueba();
        assertEquals(5, ejercicio01.suma(2, 3));
    }

    @Test
    public void testSaludo() {
        prueba ejercicio01 = new prueba();
        assertEquals("Hola, Juan", ejercicio01.saludo("Juan"));
    }

}
