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

> [!NOTE] public
> Allows us to make a variable, method or class *visible in all other class of the program and or package*
> - A public method can be call from any other class. If the class is in the current directory we don't even need to import anything
> - A public variable can be access from any other class (Not recomended)


> [!NOTE] static
> Allows us to make a *variable, method or block* to belong to a class and not to the particular instances of each
> - `static` variables are shared by all the instances of a class. Its usefull for constant values or attributes who are shared by all the class
> - `static` methods can be invoked without creating a new instance of a class => They can't access directly to non-static attributes or methods since *they don't depend of instances*
> - `static` block will be run only when the class is allocated in memory => *similar to C*


> [!NOTE] private
> *The private keyword* allows us to encapsulate the class so that the only way the user can access to those variables is *throught methods*




## Doubts
---

## Files & References
---
- [[oop-mindset|Using the private keyword]]
