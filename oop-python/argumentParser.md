---
id: argumentParser
aliases:
  - argumentParser
tags:
  - python
  - cli
---
## argparse library
---
This library allows us to recieve, process and handle errors if needed with the command line arguments recieved
```python
import argparse

parser = argparse.ArgumentParser(description = "Meow like a cat")
parser.add_argument("-n", default = 1, help = "number of times to meow", type = int)
args = parser.parse_args()

for _ in range(args.n):
	print("meow")

```
