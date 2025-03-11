import csv

words = []

with open("dict.csv") as file:
    reader = csv.DictReader(file)
    # The dictReader returns dictionaries
    for word in reader:
        words.append({"word": word["word"], "definition": word["definition"]})

for word in sorted(words, key=lambda w: w["word"]):
    print(f"{word['word']}: {word['definition']}")
