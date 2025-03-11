---
id: unpackVariables
aliases:
  - unpackVariables
tags:
  - python
  - objects
---
### Unpacking lists
---
It's a better way to divide in particular variables a list

```python
first, *others, last = [1, 2, 3, 4, 5]
first == 1
*others == [2, 3, 4]
last == 5
```

##### We can pass with this syntax multiple variables without having to write one by one
---
```python
def foo(a, b, c):
	return a + b + c

list_to_sum = [1, 2, 3]
foo(*list_to_sum)
```

*Is equivalent to...*

```python
def foo(a, b, c):
	return a + b + c

list_to_sum = [1, 2, 3]
foo (list_to_sum[0], list_to_sum[1], list_to_sum[2])
```

### Unpacking dictionaries
---
The syntax is similar and it works almost as unpacking lists...

```python
def foo2(string, long):
	for i in range(long):
		print(string[i])

dic = {"string": "wordle", "long": len(dic["string"])}
foo2(**dic)
```

*It equivalent to...*

```python
def foo2(string, long):
	for i in range(long):
		print(string[i])

dic = {"string": "wordle", "long": len(dic["string"])}
foo2(string = dic["string"], long = dic["long"])
```


