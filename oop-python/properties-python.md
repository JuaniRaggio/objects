---
id: propertys-python
aliases:
  - propertys-python
tags:
  - python
  - objects
  - decorators
  - propertys
---
## Why properties?
---
When we have a class and some instance variables, *the user* once an object is instanciated, he *could potencially change our instance variables using the "." operand*
```python
def main():
	student = Student("Harry", "Gryffindor")
	student.house = "Number Four, Privet Drive"
```
So to stop the user from doing that, *decorators where created*


> [!NOTE] Property
> A *property* can only be changed with a setter function:

```python
class Student:
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

    # Getter
    @property
    def house(self):
        return self._house

    # Setter
    @house.setter
    def house(self, house):
        # This means each time we want to change the house of an instance of an object, this will
        # verify if the house is valid
        if house not in ["Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"]:
            raise ValueError("Invalid house")
        self._house = house


def get_student():
    name = input("Name: ")
    house = input("House: ")
    patronus = input("Patronus: ")
    return Student(name, house, patronus)

def main():
    student = get_student()
    print(student)
    print("Expecto Patronum!")
    print(student.charm())
```

*Assigning or changing* a property works exactly the same changing an instance variable, the only thing that changes is that *under the hood the assignment will go through the setter*


> [!NOTE] The \_house variable
> This modification will be only inside properties. The \_\_init\_\_ method will have the normal variable or the other way around but the convesion is to have \_house inside the property function and house in the constructor, this is so that every time the user tries `student.house = ...` that `house = ...` will be replaced with the *setter function* 

##### Sooo...
---
The \_house is now the instance variable and the variable house is the property. So we could potencially do:
```python
student._house = "Acevedo"
```
and it will work, \_house isn't unmutable, its just a convesion and it means "don't touch it". *Its like a const char \* str in C* you could potencially change it by casting but if you do it its up to you, C at least gives you a warning but python not even that 

##### The objective of the properties is...
---
- *DO THIS:* `student.house = "Slytherin"` and we will proces that input, if it is correct, everything will go well.
- *DO NOT DO THIS:* `sutdent._house = "Slytherin"` even if in this case, Slytherin is a valid house, its not a good practice to do it like this cause maybe under the hood the class saves houses in lower case and doing this will probably produce conflicts

