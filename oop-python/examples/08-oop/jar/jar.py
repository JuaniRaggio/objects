class Jar:
    def __init__(self, capacity = 12):
        self.capacity = capacity
        self.size = 0

    def __str__(self):
        return "🍪" * self.size

    def deposit(self, n):
        if n < 0:
            raise ValueError("Can't deposit a negative amount")
        self.size += n

    def withdraw(self, n):
        if n < 0:
            raise ValueError("Can't withdraw a negative amount")
        self.size -= n

    @property
    def capacity(self):
        return self._capacity
    
    @capacity.setter
    def capacity(self, capacity):
        if capacity < 0 or type(capacity) is not int:
            raise ValueError("Capacity should never be negative")
        self._capacity = capacity

    @property
    def size(self):
        return self._size

    @size.setter
    def size(self, size):
        if type(size) is not int:
            raise ValueError("Size is not an integer")
        elif size < 0:
            raise ValueError("Size of the Jar should never be negative")
        elif size > self.capacity:
            raise ValueError("Size of the Jar exceeded")
        self._size = size

