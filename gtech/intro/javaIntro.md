---
id: javaIntro
tags:
  - java
  - class
  - objects
  - methods
aliases:
  - javaIntro
---
## Other files
---
- [[objectsIntroduction|Introduction to objects]]
- [[Keywords]]

## Common mistakes (my mistakes)
---
In java, you cannot assign an int value to a char value and operations are made in int format, so in this example, letter will be casted to char first and then when 32 is added, since 32's default is int -> letter will be again casted to int so *you would be assigning an integer to a char* and this is a compile time error in java

```java
char itsLowerCase = (char)letter + ('a' - 'A');
```

## Class notes & quotes
---
## Java program
---
In a java program is formed by:
- Statements -> They can be grouped together using a *method*
- A program must have at least one or more *methods*
- In order to be executable, **a program** must have at least *one method called "main"*
- *Methods* are enclosed in classes
- A program must have one or more classes

```java
// Comment
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello world!");
	}
}
```

- *File name* must match *class name*
- Extension: .java

#### Java is a hybrid language
---
It takes the benefits of the speed of compiled languages and the benefits of the interpreted languages (it can be run in every platform without taking into account the architecture)
1. Compiles it into bytecode -> bytecode doesn't make any assumption of which processor you're using. This *bytecode* file has the *.class* extension
2. Interpretates the bytecode -> This process is independent for each processor.


> [!NOTE] How to run a java file
> 1. javac -> This command transforms a *.java file* into bytecode -> *.class file*
> 2. java -> This command takes the *.class file* and the *.java file* -> It interpretates and runs it

#### Choosing identifiers
---
- They can contain letters, digits, \_, and \$ 
- A digit cannot be a starting character
- Identifiers cannot be *reserved words*
![[Pasted image 20241118000313.png]]


> [!NOTE] Case sensitivity
> Java is case sensitive => public class != public Class

#### How to declare variables
---
```java
public class division {
	public static void main(String[] args) {
		double n = 4;
		double d = 2;
		double division = n/d;
		System.out.println("The division is: " + division );
	}
}

```

#### Primitive types
---
Java is *statically typed* => You have to declare the variable before using it
![[Pasted image 20241118164650.png]]

#### Scopes
---
Each method has a different scope.
![[Pasted image 20241118200021.png]]

#### Constants
---
They can be declared with the keyword *final*
```java
final double PI = 3.14159265359;
```
Constants respect scopes so be cautious on which scope you are declaring them

#### Primitive types
---
![[Pasted image 20241118200652.png]]


> [!NOTE] Default types
> - The default type for an integer number is int even if it is greater than 
>  2 147 483 647, so if we want to save a really big number, we will have to cast it to long
> - The same happens with double, it is the default value for non-integer numbers so if we want to make a non-integer number, be read as a float number, we have to cast it 

```java
long reallyBigNumber = 9999999999; // This won't work
// Insted try this
long reallyBigN = 9999999999L; // => The L, casts the number to be long integer
```


> [!NOTE] Declaring float variables
> If we want to initialize a float variable we have to do a cast

```java
float floatingValue = 0.312; // This is illegal since 0.312 's default value is double
// Instead we have to do this
float floatingLegal = 0.312F;
// or
float floatingLegal2 = 0.312f;
```


> [!NOTE] Declaring double variables
> If we want to initialize a double variable we also have to do a cast

```java
double doubleVariable = 2; // => This won't work because 2 is an integer
// Instead we have to do this
double doubleVariableLegal = 2D;
// or
double doubleVariableLegal2 = 2d;
// or
double doubleVariableLegal3 = 2.0;
// or
double doubleVariableLegal4 = (double)2;
```


> [!NOTE] Division
>  The division works exactly the same as in C/C++ 
>  5/2 = 2 and 5/2.0 = 2.5


#### The + operand
---
It depends on which types are surrounding the +
If one of the types is a *string*, then the + operand will *cast both values to strings* and concat them, if the types are numeric, the operator will do what we expect to.

```java
"13" + "31" == "1331";
13 + 31 == 44;
```

![[Pasted image 20241118213329.png]]


## How to create a new object
---
- We have a class
- The class must have a constructor
- The constructor creates an object in the heap and returns a reference to it
- The keyword new is set to create a new object with a constructor. This process of "creating a new object" is called instantiation so you are creating an instance of an object

![[Pasted image 20241118220016.png]]

*Strings* have a shortcut and can be created with the 3rd option. But most of the classes aren't able to do so

#### Methods in object
---
Each object has methods, you can invoke methods using the . operand...
*identifier.methodName(parameters)*
Methods are the way of modifying data of objects

```java
String major = new String("Computer Science");
```

- major is saving a reference to the heap in where the object was created, so if we do...

```java
String another = new String("Another major");
another = major;
```

*We will be loosing the reference to the new object "another", we are not modifing "another"*


> [!NOTE] Garbage collector
> As in C we would have a memory leak in this case, in java we have a garbage collector so it automatically frees that memory space for new objects to be save in there


> [!NOTE] Inmutability of strings
> We have the method toLowercase(); it doesn't change the original object, it creates a new one. Every method applied to a string will manipulate a copy of the object, not the original onew

```java
// This outputs the same for every variable
public class IndexOfTest {
    public static void main(String[] args) {
        String funnyStr = "Computer!Science,!long!walks!on!the!beach";
        int a = funnyStr.indexOf(33);
        int b = funnyStr.indexOf('!'); //chars are converted to Unicode int value
        int c = funnyStr.indexOf("!");
        int d = funnyStr.indexOf("!Science");
        int e = funnyStr.indexOf("!Science,!long");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
```

## Fixed lenght arrays
---
*Declaration*
```java
elementType[] identifier;
// or
elementType identifier[];
```

*Creation*
```java
// Fixed lenght array
elementType identifier[] = new elementType[Lenght];
```


> [!NOTE] elementType could be an object

For example:
```java
final int students = 15;
String names[] = new String[students];
```


> [!NOTE] Every array's default value is NULL

#### Bi-Dimensional arrays
---
We can create non-simetric bidimensional arrays like this:
```java
double[][] array2d = {{80, 70, 75},
                      {69, 72, 74, 90}};
```
Java allows for multi-dimensional arrays of over two dimensions.  You can create an array of arrays of arrays, which would be a 3D array. In this course, however, we’ll focus on 2-D arrays, which have many practical uses.








