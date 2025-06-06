# Write a python program to convert a decimal number to binary using both
# 1. Recursive method
# 2. Iterative method

# Implement the methods in Solution class and return the binary number.

# Sample Input:
# ---------------
# 10

# Sample Output:
# ------------------
# Binary (Recursive): 1010
# Binary (Iterative): 1010
n = int(input())

def rec(n):
    if n==0:
        return ""
    return rec(n//2)+str(n%2)
    
def iter(n):
    res=""
    while(n!=0):
        a = n%2
        res = str(a)+res
        n //=2
    return res


print(f"Binary (Recursive): {rec(n)}")
print(f"Binary (Iterative): {iter(n)}")
