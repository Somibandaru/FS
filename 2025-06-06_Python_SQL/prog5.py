'''
Problem: Write a program to count each word's first index and total occurrences 
in a sentence.

Sample Input: 
apple banana apple orange banana apple

Sample Output:
apple -> first index: 0, count: 3
banana -> first index: 6, count: 2
orange -> first index: 19, count: 1

'''

str = input()
s = str.split(" ")
freq={}
l=[]
i=0

for j in range(len(s)):
    if s[j] in freq:
        freq[s[j]]+=1
        i+=len(s[j])+1
    else:
        freq[s[j]] = 1
        l.append(i)
        i+=len(s[j])+1

x=0
for key in freq:
    print(f"{key} -> first index: {l[x]}, count: {freq[key]}")
    x+=1
    
        
