# Write python code for a method which takes a String (a sentence) as input 
# and returns a Map. The Map key is String (word in the String) and 
# value is frequency of the word in the given sentence.
# (In the words ignore any special characters)

# Sample Input:
# -------------
# Java is fun, and Ja#va@ is powerful 

# Sample Output:
# --------------
# java: 2
# is: 2
# fun: 1
# and: 1
# powerful: 1

strings = input().split(" ")
freq ={}
for string in strings:
    word=""
    for char in string:
        if char.isalnum():
            word = word+char.lower()
            
    if word in freq:
        freq[word] += 1
    else:
        freq[word] = 1

for key in freq:
    print(f"{key}: {freq[key]}")
