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

