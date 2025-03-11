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

print(pet.pets)

# The cat also may have
c = cat("Tai", 1)
d.printAttributes()
c.printAttributes()

print(pet.pets)


