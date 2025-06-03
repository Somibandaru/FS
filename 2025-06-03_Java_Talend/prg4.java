// Write a Java program to convert a decimal number to binary using both
// 1. Recursive method
// 2. Iterative method

// Implement the methods in Solution class and return the binary number.

// Sample Input:
// ---------------
// 10

// Sample Output:
// ------------------
// Binary (Recursive): 1010
// Binary (Iterative): 1010

class Solution {
    public static String decimalToBinaryRecursive(int n) {
        // Implement the method recursively
        if(n==0)return "";
        
        int a = n%2;
        n = n/2;
        return ""+decimalToBinaryRecursive(n)+a;
        
    }

    public static String decimalToBinaryIterative(int n) {
        // Implement the method iteratively
        StringBuilder str=new StringBuilder();
        while(n>0){
            int a = n%2;
            str.append(a);
            n = n/2;
        }
        str.reverse();
        return str.toString();
    }
}
