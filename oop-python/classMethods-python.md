---
id: classMethods-python
aliases:
  - classMethods-python
tags:
  - python
  - class
  - objects
  - methods
---
## Class methods vs Instance methods
---
- An instance of a class is a particular object of the type class

> [!NOTE] @classmethod
> - It has NO access to *self*
> - It necesarily has to have the @classmethod decorator


> [!NOTE] Instance method
> - It has access to *self* and might modify or access to their properies/instance variables
> - Methods are automatically instance methods


> [!NOTE] Class variable
> They are *independent* from instances of the class, so in two different instances of the same class, a class variable will be exactly the same.
> Two objects of the same class will share those class variables
> *If an object changes a class variable, it will change for all the instances of that class*


> [!NOTE] Instance variable
> Each instance of a class has its own particular instance variables. They obviously have the same name but the instance variables of an instance of a class have nothing to do with the instance variables of another instance of a class


```python
import random

class Hat:

    # This is a class variable so it doesn't depend of an instance of a class, it will be always
    # the same
    houses = ["Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"]

    @classmethod
    def sort(cls, name):
        print(f"{name} is in {random.choice(cls.houses)}")

def main():
    Hat.sort("Harry")

if __name__ == "__main__":
    main()

```


### A pretty good example code who uses all these features
---
```python
class Student:
    
    houses = ["Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"]

    def __init__(self, name, house, patronus):
        if not name:
            raise ValueError("Missing name")
        self.name = name
        # This will also call my setter
        self.house = house
        self.patronus = patronus

    def __str__(self):
        return f"{self.name} from {self.house}"

    def charm(self):
        match self.patronus:
            case "Stag":
                return "🥶"
            case "Otter":
                return "😱"
            case "Jack Russell Terrier":
                return "😱"
            case _:
                return "🪄"

    # Its a class method because you don't need to create an instance of a class Student to call
    # to this method and it has to do with the class, it makes no sense to have it 
    # outside the class
    @classmethod
    def get(cls):
        name = input("Name: ")
        house = input("House: ")
        patronus = input("Patronus: ")
        return cls(name, house, patronus)

    # Getter
    @property
    def house(self):
        return self._house
    # Setter
    @house.setter
    def house(self, house):
        # This means each time we want to change the house of an instance of an object, this will
        # verify if the house is valid
        if house not in self.houses:
            raise ValueError("Invalid house")
        self._house = house

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, name):
        if not name:
            raise ValueError("Missing name")
        self._name = name

def main():
    student = Student.get()
    print(student)
    print("Expecto Patronum!")
    print(student.charm())

if __name__ == "__main__":
    main()

```

## References
---
- [[classes-students.py]]
