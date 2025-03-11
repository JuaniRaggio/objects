import json
import requests
import sys

if len(sys.argv) != 2:
    sys.exit("Invalid amount of arguments")

# REMEMBER: first parameter is followed by "?" other extra parameters should be followed by &
response = requests.get("https://itunes.apple.com/search?entity=song&limit=50&term=" + sys.argv[1])
o = response.json()

for result in o["results"]:
    print(result["trackName"])
