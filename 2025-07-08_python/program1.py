'''
The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains only 
lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true


Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false

'''
str, sc = input().split(" ")
flag=True
i=0
j=0
while i<len(str) and j<len(sc):
    if(sc[j].isdigit()):
        n=""
        while(j<len(sc) and sc[j].isdigit()): 
            n = n+sc[j]
            j+=1
        i+=int(n)
    elif(str[i]==sc[j]):
        i+=1
        j+=1
    else:
        flag=False
        break
    
print(i==len(str) and j==len(sc) and flag)   
    
