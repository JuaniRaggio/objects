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

