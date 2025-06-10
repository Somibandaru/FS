'''
Write a Python Program to read a sentence and print each word reversed, but 
maintain the original word order.

Input: 
------
Java is fun

Output:
-------
avaJ si nuf

'''
strs = input().split(" ")
for s in strs:
    print(s[::-1], end=" ")

'''
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Write a program that finds the longest substring that reads the same forwards 
and backwards.

Input: 
------
babad

Output: 
-------
bab or aba

'''
str = input()
res=""

def isPalin(s):
    return s==s[::-1]
    
for i in range(0, len(str)):
    for j in range(i+1, len(str)+1):
        if isPalin(str[i:j]):
            if(len(res)<len(str[i:j])):
                res = str[i:j]
                
print(res)
# -------------------------------------------------------------------------------------------------------------------------------------------------------------
'''

Write a python program that reads a sentence and counts how many times each word 
appears. Display only the words that occur more than once.

Input: 
------
this is a test this test is easy

Output:
-------
this -> 2
is -> 2
test -> 2

'''
freq={}
str = input().split(" ")

for s in str:
    if s in freq:
        freq[s] +=1
    else: freq[s]=1

for key in freq:
    if(freq[key]>=2):
        print(key+" -> ",freq[key])
# -------------------------------------------------------------------------------------------------------------------------------------------------------------
'''

Write a program that reads a sentence, count and display the total number of 
vowels and consonants.

Input: 
------
Hello World

Output:
-------
Vowels: 3, Consonants: 7

'''
str = input().lower()
vowels='aeiou'
v=0
c=0
for s in str:
    if s in vowels:
        v+=1
    elif s.isalpha():
        c+=1
print('Vowels: ',v," Consonants: ",c)
# -------------------------------------------------------------------------------------------------------------------------------------------------------------
'''

Write a python program that reads two timestamps (yyyy-MM-dd HH:mm:ss format) and
display the time elapsed between them in minutes and seconds.

Input: 
------
2025-06-04 10:30:00
2025-06-04 11:15:40

Output: 
-------
Elapsed: 45 minutes 40 seconds

'''

from datetime import datetime

t1 = input()
t2 = input()

format='%Y-%m-%d %H:%M:%S'
s1 = datetime.strptime(t1, format)
s2 = datetime.strptime(t2, format)

mins = (s2 - s1).total_seconds() // 60
secs = (s2 - s1).total_seconds() % 60
print('Elapsed: ',int(mins),' minutes ',int(secs),' seconds')
# -------------------------------------------------------------------------------------------------------------------------------------------------------------
'''

Write a python program, for given a birthdate in yyyy-MM-dd format, calculate 
the person’s current age in years, months, and days.

Input:
------
1990-05-25

Output:
-------
Age: 34 years, 0 months, 10 days

'''

from datetime import datetime
from dateutil.relativedelta import relativedelta

str = input() 
birth = datetime.strptime(str, "%Y-%m-%d")
today = datetime.strptime("2025-06-10", "%Y-%m-%d")

diff = relativedelta(today, birth)

print(f"Age: {diff.years} years, {diff.months} months, {diff.days} days")
# -------------------------------------------------------------------------------------------------------------------------------------------------------------
