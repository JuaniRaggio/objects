import csv

students = []

# The with keyword, allows us to automatically close the file, once the indentation finishes
with open("students.csv") as file:
    reader = csv.reader(file)
    for stu in reader:
        students.append({"name": stu[0], "home": stu[1], "locality": stu[2]})

for stu in sorted(students, key=lambda stu: stu['name']):
    print(f"{stu['name']} lives in {stu['home']} from {stu['locality']}")
