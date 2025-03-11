---
tags:
  - class
  - objects
  - attributes
  - decorators
  - python
aliases:
  - objetos
  - po
---
## Class Attributes
---
They are independent from all instantiations of a class, so we can access to them without having any instance of a class
```python
class person:
	number_of_people = 0
	def __init__(self):
		...
		cls.add_person() # This will increase number_of_people each time we create a new instance
		
	@classmethod
	def number_of_people(cls):
		return cls.number_of_people
		
	@classmethod
	def add_person(cls):
		cls.number_of_people += 1
person.number_of_people
```



