---
id: typeHints
aliases:
  - typeHints
tags:
  - python
  - objects
  - types
---
## Type hints
---
There is a library called mypy that helps us to debug python code in termos of types.

> [!NOTE] Type declaration
> Even though python is dinamically typed, there is a way of telling the usr what a function expects to recieve

```python
def i_sum_integers(a: int, b: int) -> int:
	return a + b
```
*This function ==expects== two integers and should return an integer*
But ==we could pass two strings== cause python permits this

## For large or professional code bases
---
Its recomendable to use type hints for a more clear code, eg:
```python
class Wizard:
    def __init__(self, name: str):
        if not name:
            raise ValueError("Missing name")
        self.name = name


class Student(Wizard): # Wizard is the SUPER CLASS of Student => Student inherits its methods/vars
    def __init__(self, name: str, house: str):
        super().__init__(name)
        self.house = house


class Professor(Wizard):
    def __init__(self, name: str, subject: str):
        super().__init__(name)
        self.subject = subject

wiz: Wizard = Wizard("Juani")
student: Student = Student("Harry", "Gryffindor")
professor: Professor = Professor("Fernando", "Physics")

```


> [!NOTE] How to get type errors
> *mypy* allows us to get clearer *type errors* and it makes easier to find type errors


> [!NOTE] IMPORTANT
> To use *mypy* we need to use type hints otherwise it won't work

## How to format function's comments correctly
---
```python
def bark(n: int) -> str:
	"""
	Barks n times
	
	:param n: Number of times to bark
	:type n: int
	:raise TypeError: if n is not an int
	:return: A string of n barks, one per line
	:rtype: str
	"""
	return "Wof\n" * n
```


