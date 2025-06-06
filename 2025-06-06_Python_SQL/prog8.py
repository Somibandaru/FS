'''

Problem: 
Write Python code to identify if given two strings are Anagrams 
(strings that contain same set of alphabets)

Sample Input: 
-------------
listen silent

Sample Output: 
--------------
true

'''
str = input().split(" ")
l1 = list(str[0])
l2 = list(str[1])

l1.sort()
l2.sort()
print(l1==l2)
