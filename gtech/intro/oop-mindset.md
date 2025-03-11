---
tags:
  - java
  - class
  - objects
  - keywords
aliases:
  - objetos
  - po
---
## Class notes
---
### Imagine we want to create insects
---

> [!NOTE] What questions should we do?
> 1. Behaviors?
> 	1. eat
> 	2. move
> 2. Attributes based on behaviors?
> 	1. weight
> 	2. food consumed
> 	3. x position
> 	4. y position
> 	5. z position



> [!NOTE] Instance Variables
> - Each instance has its own attributes and has its own version of the class. So if one instance changes an attribute, the other instances won't
> - *They have its own allocated space in memory*
> - Instance variables are declared at the class level -> Outside any method


```java
public class insect {
	// Instance variables here
}
```

In java any variable or method that is declared in this scope is called a *class member*


> [!NOTE] Convention
> We declare instance variables right below the class name

```java
public class insect {
	// Declaring this variables outside other methods allows those methods
	// to access and/or change this variables
	private double weight;
	private double x;
	private double y;
}
```


> [!NOTE] private
> *The private keyword* allows us to encapsulate the class so that the only way the user can access to those variables is *throught methods*















