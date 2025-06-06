'''
Problem: 
--------
Write a Python code to identify the nth largest number without 
sorting the array


Sample Input:
-------------
4 2
3 1 5 2

Sample Output:
--------------
3

'''
size, n = input().split(" ")
size = int(size)
n = int(n)

l = input().split(" ")
for x in range(len(l)):
    l[x] = int(l[x])
    
for _ in range(n-1):
    m = max(l)
    l.remove(m);
    
print(max(l))
    

