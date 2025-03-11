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

