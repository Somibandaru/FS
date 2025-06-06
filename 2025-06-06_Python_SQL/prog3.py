# Write a python program to find the nth prime number. 
# The value of n should be input by the user.

# Sample Input:
# ---------------
# 5

# Sample Output:
# -----------------
# 11

n = int(input())

def isPrime(x):
    for i in range (2, x):
        if(x%i==0): 
            return False
    
    return True

num=2
while True:
    if(isPrime(num)): 
        n -=1
    if(n==0): break
    num +=1

print(num)
