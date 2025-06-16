= Ejercicio 1


= Ejercicio 2

== Test

```java
public class CustomOrderedIterationTester {
  public static void main(String[] args) {
    String[] stringArray = {"aaa", "xxx", "zzz", "yyy"};
    String stringStopElement = "xxx";
    CustomOrderedIteration<String> stringIt = new CustomOrderedIteration<>(
      stringArray, // Arreglo de elementos de tipo String
      Comparator.reverseOrder(), // Criterio de Orden Descendente
      stringStopElement // Elemento de fin
    );
    System.out.println(Arrays.toString(stringArray)); // [aaa, xxx, zzz, yyy]
    // Se imprimen los elementos de stringArray en orden descendente
    // hasta que aparezca el elemento de fin "xxx"
    Iterator<String> it1 = stringIt.iterator();
    while(it1.hasNext()) {
      System.out.println(it1.next());
    }
    /**
    * zzz
    * yyy
    */
    // Se cambia el elemento de fin
    stringIt.setStopElement("bbb");
    // Se imprimen los elementos de stringArray en orden descendente
    // hasta que aparezca el elemento de fin "bbb" (como no aparece se imprimen todos)
    Iterator<String> it2 = stringIt.iterator();
    stringIt.setStopElement("aaa");
    while(it2.hasNext()) {
      System.out.println(it2.next());
    }
    /**
    * zzz
    * yyy
    * xxx
    * aaa
    */
    Person[] personArray = {new Person("Foo", "Bar"), new Person("Bar", "Foo")};
    Person personStopElement = new Person("John", "Doe");
    CustomOrderedIteration<Person> personIt = new CustomOrderedIteration<>(
      personArray, // Arreglo de elementos de tipo Person
      // Criterio de Orden ascendente por nombre y desempata descendente por apellido
      (a, b) -> {
        int cmp = a.getName().compareTo(b.getName());
        if (cmp == 0) {
          cmp = b.getSurname().compareTo(a.getSurname());
        }
        return cmp;
      },
      personStopElement // Elemento de fin
    );
    // Se imprimen los elementos de personArray en orden ascendente por nombre
    // y desempata descendente por apellido
    // hasta que aparezca el elemento de fin John Doe (como no aparece se imprimen todos)
    for(Person element : personIt) {
      System.out.println(element);
    }
    /*
    * Person Bar Foo
    * Person Foo Bar
    */
    personIt.setStopElement(new Person("Foo", "Bar"));
    // Se imprimen los elementos de personArray en orden ascendente por nombre
    // y desempata descendente por apellido
    // hasta que aparezca el elemento de fin Foo Bar
    for(Person element : personIt) {
      System.out.println(element);
    }
    /*
    * Person Bar Foo
    */
  }

  static class Person {
    private final String firstName, lastName;
    public Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }
    @Override
    public boolean equals(Object o) {
      return this == o || (o instanceof Person person
      && firstName.equals(person.firstName)
      && lastName.equals(person.lastName));
    }
    @Override
    public String toString() {
      return String.format("Person %s %s", firstName, lastName);
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }
  }
}
```

== Solucion

```java

public class CustomOrderIteration<T extends Comparable<? super T>>
                                    implemets Iterable<T> {
  private T[] elements;
  private T stopElement;

  public CustomOrderIteration(T[] array, Comparator<T> cmp, T stopper) {
    setStopElement(stopper);
    elements = Arrays.copyOf(array, array.size())
    Arrays.sort(elements, cmp);
  }

  public void setStopElement(T stopper) {
    stopElement = stoper;
  }

  public Iterator<T> iterator() {
    return new Iterator<>() {

      private final int i = 0;
      private T ender = stopElement;

      @Override
      public boolean hasNext() {
        return i < elements.size() && !elements[i].equals(ender);
      }

      @Override
      public T next() {
        return elements[i++];
      }

    }
  }
}

```


