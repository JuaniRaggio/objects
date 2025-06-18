# Ejercicio de try-catch de errores

### Ejercicio 1
---
Si compila pues cuando se capturan *personas* ( clases padres ) tambien vas a
capturar *alumnos* ( clases hijas )

**Conclusion**: Compila

```java
public class Ej1 {

   public static void main(String[] args) {
       Ej1 ej1 = new Ej1();
       try {
           ej1.method();
           System.out.println("Método ejecutado");
       } catch (Exception2 e) {
           System.out.println("Excepción 2 capturada");
       } finally {
           System.out.println("Finalizando");
       }
   }

   public void method() throws Exception3 {
       throw new Exception3();
   }

}
```

### Ejercicio 2
---
- En este caso podemos pensar como que las *clases padres* son personas y las
  clases hijas son *alumnos* entonces si yo quiero capturar personas, si pasa 
  un alumno lo voy a caputurar porque es persona.

- En caso de que quiera caputurar alumnos, si pasa una persona, no la atrapo. 
  Solo capturo a los casos especificos -> *alumnos*

- Ademas el bloque de Exception2 es alcanzable porque catch(Exception3) no se 
  encarga de las Exceptions2 entonces el compilador no llora

**Conclusion**: Compila
**Salida**:
Excepcion 3 capturada
Finalizando 3
Finalizando 2
Excepcion 4 capturada

```java
public class Ej2 {

    public static void main(String[] args) {
        Ej2 ej2 = new Ej2();
        try {
            try {
                ej2.m3();
            } catch (Exception3 e) {
                System.out.println("Excepción 3 capturada");
            } finally {
                System.out.println("Finalizando 3");
            }
        } catch (Exception2 e) {
            System.out.println("Excepción 2 capturada");
        } finally {
            System.out.println("Finalizando 2");
        }

        // Esto esta ok
        try {
            ej2.m1();
        } catch (Exception4 e) {
            System.out.println("Excepción 4 capturada");
        }
    }

    public void m1() {
        throw new Exception4();
    }

    public void m2() throws Exception4 {
        throw new Exception4();
    }

    public void m3() throws Exception2 {
        throw new Exception3();
    }

}

```

### Ejercicio 3
---
- En este caso Exception2 es padre por lo que ya se encarga de las Excepciones3
  por lo tanto el catch de abajo va a ser inalcanzable y ese error nos tirara
  el compilador

**Conclusion**: No compila

```java
public class Ej3 {

   public static void main(String[] args) {
       Ej3 ej3 = new Ej3();
       try {
           ej3.method();
       } catch (Exception2 e) {
           System.out.println("Excepción 2 capturada");
       } catch (Exception3 e) {
           System.out.println("Excepción 3 capturada");
       }
   }

   public void method() throws Exception3 {
       throw new Exception3();
   }

}
```

### Ejercicio 4
---
- No compila pues no hay un anotation que avise que puede tirar Exception2

**Conclusion**: No compila

```java
public class Ej4 {
  
   public static void main(String[] args) {
       throw new Exception2();
   }
  
}
```

### Ejercicio 5
---
- Si compila pues Exception4 es RunTimeException y no necesita ser checkeada
  para compilar

**Conclusion**: Compila
**Salida**: RunTimeException

```java
public class Ej5 {
  
   public static void main(String[] args) {
       throw new Exception4();
   }
  
}
```

### Ejercicio 6
---
- Si compila pues Exception4 es de RunTime pero no tiene sentido pues println
  no tira Exception4

**Conclusion**: Compila
**Salida**: 
Dentro del bloque try

```java
public class Ej6 {

   public static void main(String[] args) {
       try {
           System.out.println("Dentro del bloque try");
       } catch (Exception4 e) {
           System.out.println("Dentro del bloque catch");
       }
   }

}
```

### Ejercicio 7
---
- No compila pues Exception2 exige una anotation, y el compilador va a decir
  que el *bloque de catch es inalcanzable*

```java
public class Ej7 {
  
   public static void main(String[] args) {
       try {
           System.out.println("Dentro del bloque try");
       } catch (Exception2 e) {
           System.out.println("Dentro del bloque catch");
       }
   }
  
}
```

### Ejercicio 8
---
- Este es raro porque dice que tira una Exception2 pero tira una Exception3
  ( hija ), pero como se captura la Exception3, ya estaria tratada ahi. Entonces
  no se entra al bloque de catch Exception2 aunque para el compilador si podria
  llegarse porque no todas las Exceptions3 son Exception2

**Conclusion**: Compila
**Salida**:
Excepcion 3 capturada
Finalizando 3
Finalizando 2

```java

public class Ej8 {

   public static void main(String[] args) {
       Ej8 ej8 = new Ej8();
       try {
           try {
               ej8.method();
           } catch (Exception3 e) {
               ej8.method();
               System.out.println("Excepción 3 capturada");
           } finally {
               System.out.println("Finalizando 3");
           }

       } catch (Exception2 e) {
           System.out.println("Excepción 2 capturada");
       } finally {
           System.out.println("Finalizando 2");
       }
   }

   public void method() throws Exception2 {
       throw new Exception3();
   }

}
```
