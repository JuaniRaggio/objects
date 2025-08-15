= Ejercicio 1 - Tablita
_Nota:_ Importante entenderla, entro en *TODOS* los recuperatorios desde el 1C 2022 hasta hoy.

Dada la siguiente jerarquía de clases, con los métodos de instancia indicados para cada una, se cuenta con tres instancias homónimas a la clase a la cual pertenecen.
Completar un cuadro de doble entrada (clase y mensaje) indicando qué se obtiene al enviar cada uno de los mensajes a instancias de cada una de las clases.

```java
class A {
   int m1() {
       return 1;
   }
   int m2() {
       return m1();
   }
   int m3() {
       return this.m1();
   }
}

class B extends A {
   int m1() {
       return m2();
   }
   int m2() {
       return 2;
   }
   int m3() {
       return super.m2();
   }
}

class C extends B {
   int m1() {
       return 3;
   }
   int m2() {
       return super.m2();
   }
   int m3() {
       return m3();
   }
}
```

#align(center)[#table(columns: 4)[][m1][m2][m3][A][][][][B][][][][C][][][]]

=== Luego comprobar la salida usando su IDE de preferencia
 
