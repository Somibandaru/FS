'''

Write a Python code to return the length of longest sub-string without repeating 
characters

Sample Input: 
-------------
abcabcbb

Sample Output: 
--------------
3

'''
str = input()
m = 0
freq = {}
i = 0

for j in range(len(str)):
    if str[j] in freq:
        freq[str[j]] += 1
    else:
        freq[str[j]] = 1
        
    while freq[str[j]]>1:
        freq[str[i]] -=1
        i+=1
        
    m = max(m, j-i+1)

print(m)
