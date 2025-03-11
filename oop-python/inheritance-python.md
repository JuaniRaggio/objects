---
id: inheritance-python
aliases:
  - inheritance-python
tags:
  - python
  - objects
  - class
---
## Inheritance
---

> [!NOTE] Why inheritance?
> For generalization and to avoid repeting of code

```python
class Student:
    def __init__(self, name, house):
        if not name:
            raise ValueError("Missing name")
        self.name = name
        self.house = house

class Professor:
    def __init__(self, name, subject):
        if not name:
            raise ValueError("Missing name")
        self.name = name
        self.subject = subject

```


> Obs
> *Both classes* have:
> 1. A name
> 2. A Validation of name

> *Could also have:*
> 3. Height
> 4. Age
> 5. etc.

> All this attributes would be in both classes and having to repeat them is clearly not a good practice

## Solution
---
- A more *herarchical* class such as wizard who has all this attributes

```python
class Wizard:
    def __init__(self, name):
        if not name:
            raise ValueError("Missing name")
        self.name = name


class Student(Wizard): # Wizard is the SUPER CLASS of Student => Student inherits its methods/vars
    def __init__(self, name, house):
        super().__init__(name)
        self.house = house


class Professor(Wizard):
    def __init__(self, name, subject):
        super().__init__(name)
        self.subject = subject

wiz = Wizard("Juani")
student = Student("Harry", "Gryffindor")
professor = Professor("Fernando", "Physics")
```

## References
---
- [[inheritance-wizard.py]]
