---
tags:
  - java
  - class
  - objects
  - methods
aliases:
  - objetos
  - po
---
## Class notes
---
An object can have *attributes* and can make *actions*. For example:
> [!NOTE] Car
> - *Attributes*:
> 	- Color
> 	- Shape
> 	- Model
> 	- Year
> 	- Current speed
> - *Actions*:
> 	- Accelerate
> 	- Start engine
> 	- Turnning
> 	- Honking
> 	- Braking


> [!NOTE] IMPORTANT
> For constants we use the *keyword* final


Another example of object could be:

> [!NOTE] Day
> - *Attributes*:
> 	- Weather
> 	- Average temperature
> 	- Highest temperature
> 	- Lowest temperature
> 	- Humidity
> - *Actions*:
> 	- Printing
> 	- Update

#### In code...
---
Variables -> *Attributes* for each object
Methods -> *Actions* to modify each state (variable) of the object

### Benefits of object oriented programming
---
- Use code to model entities, concepts and processes in ways that simplify software
- It makes easier to update and mantain software. For example:
If I want to add the information of the pollen in the air cause many customers are asking for this feature it will be as simple as adding the attribute *pollenCount* and adding to the *Printing* action to also print this new feature


## Some String methods in java
---

> [!NOTE] IMPORTANT
> Strings in java are *inmutable*

```java
int length();
char charAt(int);

// Both next methods return a reference to a new instance of String
String toLowerCase();
String toUpperCase();

boolean contains(CharSequence s);
boolean startsWith(CharSequence s);
boolean endsWith(CharSequence s);

int indexOf(String s);
int lastIndexOf(String s);

boolean isEmpty();

String substring(int beginIndex);
String substring(int beginIndex, int endIndex);

boolean equals(Object anObject);
boolean equalsIgnoreCase(String anotherString);
// Its like strcmp();
int compareTo(String anotherString);

// This method creates a copy of the string replacing @target with @repacement
// But it doesn't change the original string since strings in java are inmutable
String replace(CharSequence target, CharSequence replacement);

// Removes extra whitespaces
String trim();

// Converts the string to character array
char[] chars = str.toCharArray();

// Converts the given object to a string
// String.valueOf(123); -> Output "123"
static String valueOf(Object obj);

```

#### The printf() method
---
```java
System.out.printf(formatString, values(s));
```

It is used pretty similar than in C, formatString is a string in where the '%' will be the escape character
And formatString will have the form of:
`%[flag][width][.precision]type`
- **`[flag]`**: Modificadores que controlan el alineamiento, relleno, signo, etc.
- **`[width]`**: El número mínimo de caracteres que se mostrarán para el valor. Si el valor tiene menos caracteres, se rellenará.
- **`[.precision]`**: Para valores decimales o cadenas, indica el número máximo de decimales o la longitud máxima de la cadena.
- **`[type]`**: Especificador del tipo de dato (e.g., `d` para entero, `f` para flotante, `s` para cadena, etc.).

![[Pasted image 20241121142601.png]]

It works exactly the same as in C:

- *In addition*: The flag "," just after the % will separate the thousands with it
1000.0 -> 1,000.0

```java
public class FormatoPrintf {
    public static void main(String[] args) {
        // Ejemplo de enteros
        int numero = 1234;
        System.out.printf("Número con diferentes formatos:\n");
        System.out.printf("'%d'  - Decimal\n", numero); // `%d` es para enteros en decimal
        System.out.printf("'%5d' - Ancho mínimo de 5 caracteres\n", numero); // Ancho mínimo de 5 caracteres
        System.out.printf("'%05d' - Ancho de 5 caracteres, rellenado con ceros\n", numero); // Rellenar con ceros
        System.out.printf("'%+5d' - Ancho de 5, con signo siempre\n", numero); // Con signo
        System.out.printf("'%-5d' - Alineado a la izquierda con un ancho de 5\n", numero); 
        //  Alineado a la izquierda

        // Ejemplo de flotantes
        double decimal = 123.456789;
        System.out.printf("\nNúmero decimal con diferentes precisiones:\n");
        System.out.printf("'%f'  - Sin especificar precisión (6 decimales por defecto)\n",
         decimal); // Sin precisión
        System.out.printf("'%.2f' - Con precisión de 2 decimales\n", decimal);
         // Precisión de 2 decimales

        System.out.printf("'%10.2f' - Ancho de 10, precisión de 2 decimales\n", decimal);
         // Ancho de 10 y precisión de 2
        
        System.out.printf("'%010.2f' - Ancho de 10, precisión de 2, relleno con ceros\n", 
        decimal); // Relleno con ceros

        System.out.printf("'%+10.2f' - Con signo, ancho de 10, precisión de 2\n", decimal);
        // Con signo

        // Ejemplo de cadenas
        String texto = "Hola Mundo";
        System.out.printf("\nCadena con diferentes formatos:\n");
        System.out.printf("'%s'  - Cadena sin especificar ancho\n", texto); // Cadena sin ancho
        System.out.printf("'%10s' - Cadena con ancho de 10\n", texto); // Cadena con ancho de 10
        System.out.printf("'%-10s' - Cadena alineada a la izquierda con ancho de 10\n", texto); // Alineado a la izquierda
        System.out.printf("'%10.5s' - Ancho de 10, pero solo los primeros 5 caracteres de la"
        " cadena\n", texto); // Precisión en cadena
    }
}
```

#### The Strings's formating() method
---
Works exactly the *same as in printf() method*
Instead it returns the pointer in its name
```java
String celsiusOutput = String.format("%s %-11s %,.1f \n", day, cText, celsius);
```

### Comparing strings
---
To compare strings we use the equals() method or the compareTo() method
```java
boolean equals(Object anObject);
int compareTo(String anotherString);
```


## Input and Output -> Scanner class
---
A Scanner object can read data from multiple kinds of sources, and the object passed into the constructor represents a particular source. For example, System.in as perameter to the constructor, customizes the created object so that it can read the ordered stream of characters entered on the keyboard.
![[Pasted image 20241120184845.png]]

With content in the stream, we can use the Scanner object's methods to read chunks of data for processing. These chunks are formally called tokens, and there are different methods that represent the different types of tokens we can read.

### Scanner object <- chunks of data = tokens

#### How to identify different tokens?
---
To actually break a sequence of characters into tokens, the Scanner needs a representation of boundaries between tokens.  Such boundaries are defined by a particular sequence of characters called a delimiter. By default, Scanner uses *whitespace characters as delimiters*, but you can change that if needed.


#### How are tokens represented?
---
How these tokens are represented once they are read ultimately depends on which method you use.  The nextInt method described earlier would, for example, convert a token to an int value.
As you might guess, an error occurs if the next available token in a stream is not a sequence of characters that can be represented as an int.

## Scanner methods in java
---
- The Scanner methods in java read tokens which are separated by whitespaces

```java
import java.util.Scanner;

public class farenheitToCelsius {
    public static void main(String[] args) {
        Scanner temperature = new Scanner(System.in);
        System.out.print("Introduce temperature in farenheit: ");
        if (!temperature.hasNextInt())
            throw new IllegalArgumentException("Invalid temperature value");
        int farenheit = temperature.nextInt();
        System.out.print("Introduce day: ");
        String day = temperature.next();
        double celsius = (5.0/9) * (farenheit - 32);
        System.out.println(day + "'s temperature in celsius is: " + celsius);
    }
}
```

> [!NOTE] Some special cases
> If in one line we have one single token, *except the nextLine() method*, every otherone won't consume the \n, so if we do:

```java
// Our input sys would be:
20
hello

Scanner input = new Scanner(System.in);
input.nextInt();
input.nextLine();
```

Then the nextInt() method will read the 20 but not the '\n' of newline => nextLine() will read the '\n' left so it will return an empty string


## Java Packages
---
*Classes can be grouped together based on the functions they provide*.  These groups are officially *called packages* and each has a name. For example, System, String, and a long list of many other classes are in a package called java.lang. They are all grouped together because they are considered fundamental to the language, and for that reason, you do not have to insert any special lines in your code before using them
[Java Packages](https://docs.oracle.com/javase/7/docs/api/java/lang/package-summary.html)

Other classes that are not in Java Packages require an import statement
For example, Scanner, Timer, and Stack are all members of the java.util package and must therefore be imported

*You must use the next statement*
```java
Generic:
import packageName.memberName;

Example:
import java.util.Scanner;
```


> [!NOTE] Understanding syntax
> In the case of `System.out.println(...);` -> System would be the class, out the object and println() the method


##### Why package names have multiple dot-separated terms?
---
The reason is that Java allows *hierarchies* in packages to help with organization, so each term represents a level in a package hierarchy.  The first term (e.g. “java”) is the top level package, which can house subpackages. As you read a package name from left to right, you’re going deeper into the hierarchy.


> [!NOTE] Regular expresions are allowed in the memberName
> For example: ` import java.util.*` => Imports every class from java.util package


### Conflicting definitions of classes
---
![[Pasted image 20241121123043.png]]

As a final note, it’s important to also mention that using the wildcard to import all members of a package versus using their fully-qualified names does not mean your programs are going to get bigger or anything of that nature.  There may be some additional overhead **during compile time** from not being specific, but there’s none when it comes to runtime.  The same bytecode is generated either way.

## NumberFormat class
---
This class allows us to give format to numbers, a crazy example is using the getCurrencyInstance() method. It gets the computer's location and gives the local place's format
```java
import java.util.Scanner;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class currencyDemo{
    public static void main(String[] args) {
        double discount = 0.7; // 30% descuento
        LocalDate date = LocalDate.now();
        DayOfWeek today = date.getDayOfWeek();
        Scanner buffer = new Scanner(System.in);
        boolean cleanBuffer = false;
        do {
            if (cleanBuffer) buffer.nextLine();
            System.out.print("Introduce the amount of items: ");
            cleanBuffer = true;
        } while (!buffer.hasNextInt());
        int amount = buffer.nextInt();

        cleanBuffer = false;
        do {
            if (cleanBuffer) buffer.nextLine();
            System.out.print("Introduce the price of the items: ");
            cleanBuffer = true;
        } while(!buffer.hasNextDouble());
        double price = buffer.nextDouble();
        double totalPrice = today == DayOfWeek.THURSDAY ? price * amount * discount:price * amount;
        System.out.println("The total price without formating is: " + totalPrice);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        System.out.println("The total price is: " + currencyFormat.format(totalPrice));
    }
}
```

Depending in which country you are, the format of what the program prints will be different.
I'm in Argentina rn so the output I get is the following:

![[Pasted image 20241121152454.png]]

- You can also manually specify the country with the Locale.COUNTRY (constant(?)
```java
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class CurrencyDemo {
    public static void main(String[] args) {
        int items;
        double itemCost, total;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        items = input.nextInt();
        System.out.print ("Enter the cost per item: ");
        itemCost = input.nextDouble();
        total = items * itemCost;
        System.out.println();
        System.out.println ("Unformatted Total: " + total);

        **NumberFormat currencyFmt = NumberFormat.getCurrencyInstance(Locale.FRANCE);**

        System.out.println ("Formatted Total: " + currencyFmt.format(total));
    }
}
```

### Other usefull method in the NumberFormat class
---
```java
DecimalFormat formatter = new DecimalFormat("0.0");
```
It takes an object String literal and that will be the format for the numbers we pass to the methods in this class

```java
formatter.format(.89785);
// This will return 0.9 since the format we gave to the object formatter has one decimal and one integer number
```

Other examples
```java
import java.text.DecimalFormat;

public class DecimalFormatDemo {
    public static void main(String[] args) {
        DecimalFormat formatter1 = new DecimalFormat("0.0");
        DecimalFormat formatter2 = new DecimalFormat("00.00");
        DecimalFormat formatter3 = new DecimalFormat(".00");
        DecimalFormat formatter4 = new DecimalFormat("0.00%");
 
        System.out.println("0.0: " + formatter1.format(.8675309));
        System.out.println("00.00: " + formatter2.format(.8675309));
        System.out.println(".00: " + formatter3.format(.8675309));
        System.out.println("0.00%: " + formatter4.format(.8675309));
        System.out.println(".00: " + formatter3.format(8675309));
    }
}
// Outputs:
0.0: 0.9
00.00: 00.87
.00: .87
0.00%: 86.75%
.00: 8675309.00
```
*So the % sign at the end of a format will automatically make the percentage*

## Operands
---

> [!NOTE] Idem to C/C++
> - if
> - while
> - do-while
> - for
> - switch
> - ternary

- continue -> Starts the iteration all over again
- break -> Stops the iteration skiping all the left instructions in the loop
- for-each
```java
for (arrayType element : array) {
    bodyStatement1;
    bodyStatement1;
    ...
}
```

## NULL pointer
---
In this case we are *dereferencing* a NULL pointer, since concepts is initialised with NULL -> concepts[1] == NULL and we are trying to compare it with polymorphism -> we are dereferencing NULL
```java
public class SparseArraySearch {
    public static void main(String args[]) {
        String[] concepts = new String[5];
        concepts[0] = "abstraction";
        concepts[2] = "polymorphism";
        concepts[3] = "inheritance";
        concepts[4] = "encapsulation";
        String result = "not found";
        for (String concept : concepts ) {
// We should change the if statemente to be
// if (concept != null && concept.equals("polymorphism"))
            if (concept.equals("polymorphism") ) {
                result = "found";
                break;
            }
        }
        System.out.println(result);
    }
}
```










## Files & References
---
- [Scanner methods](https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html#method.summary)
- [All classes and methods](https://docs.oracle.com/javase/10/docs/api/allclasses-noframe.html)
- [Java Packages](https://docs.oracle.com/javase/7/docs/api/java/lang/package-summary.html)

