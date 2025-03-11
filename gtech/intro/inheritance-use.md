---
tags:
  - java
  - class
  - objects
  - python
aliases:
  - objetos
  - po
---
## Class notes
---

> [!NOTE] When to use it
> If we have two classes and both share some specific attributes and methods, with the objective of organizing code, inheritance pops up
> - More than one class -> We create a new one which will have the attributes shared by the other classes
> + Helps us *organizing code*
> + Avoid code repetition

#### Siemple example of use
---
```python
class dog:
	def __init__(self, name, age):
		self.name = name
		self.age = age
	def printAttributes(self):
        print(f"Hey! My name is {self.name}, I'm {self.age} years old. I love Juani y Sofi")
	def myPhrase(self):
		print("Bark")
```
We would have to do the same for cat and if we want another specie, again writting everything again
The solution for this problem is *inheritance*:
```python

class pet:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    def printAttributes(self):
        print(f"Hey! My name is {self.name}, I'm {self.age} years old. I love Juani y Sofi")

class dog(pet):
    def myPhrase(self):
        print("Bark")

class cat(pet):
    def myPhrase(self):
        print("Meow")

d = dog("Dante", 8)
c = cat("Tai", 1)
d.printAttributes()
c.printAttributes()

```

### Generalization and super class
---
The super class is the "father" of all the classes, so if we want to inherit some initialization instructions and at the same time add some to our child class we can use the *super()* class which makes reference to the father of all classes as in the example
Also if the super class increases a *class attribute* such as *pets* each time there is a new instance of the class, using super().\_\_init\_\_ will trigger the addition or anything the super class wants to do for each new instance of itself

```python
# Generalization
class pet:
    pets = 0

    def __init__(self, name, age):
        self.name = name
        self.age = age
        pet.new_pet()

    def printAttributes(self):
        print(f"Hey! My name is {self.name}, I'm {self.age} years old. I love Juani y Sofi")

    @classmethod
    def new_pet(cls):
        cls.pets += 1

# Child classes or derive classes
class dog(pet):
    amount_of_dogs = 0
    def __init__(self, name, age, color, gender):
# This means: The super class is the pet class, then the __init__ is the method we want to run
# so this is how we call the parent initialization
        super().__init__(name, age) 
        self.color = color
        self.gender = gender
        dog.new_dog()

    @classmethod
    def new_dog(cls):
        cls.amount_of_dogs += 1

    def myPhrase(self):
        print("Bark")

    def changeGender(self, gender):
        self.gender = gender

    def localAttributes(self):
        print(f"color: {self.color}, gender: {self.gender}")

class cat(pet):
    def myPhrase(self):
        print("Meow")

# So now the class dog has its own attributes and also inherits the pet's methods
d = dog("Dante", 7, "Black and Brown", "Male")
d.localAttributes()

print(pet.pets) -> will print 1

# The cat also may have
c = cat("Tai", 1)
d.printAttributes()
c.printAttributes()

print(pet.pets) -> will print 2

```

### Static methods
---

