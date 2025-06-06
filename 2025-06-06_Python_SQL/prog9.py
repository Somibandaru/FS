'''

Write python program to find and return minimum number of denominations – given 
an infinite supply of each denomination of {1, 2, 5, 10, 20, 50, 100, 200,500, 
2000} and a target value N

Sample Input: 
-------------
187

Sample Output: 
--------------
[100, 50, 20, 10, 5, 2]

'''
n = int(input())
l=[1, 2, 5, 10, 20, 50, 100, 200,500, 2000]
res=[]
i=len(l)-1

while(n>0):
    if(l[i]<=n):
        n-=l[i]
        res.append(l[i])
    else:
        i-=1
    if(n==0):
        break
        

print(res)
