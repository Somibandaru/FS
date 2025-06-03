// Write a Java program to find the nth prime number. 
// The value of n should be input by the user.

// Sample Input:
// ---------------
// 5

// Sample Output:
// -----------------
// 11

import java.util.*;

class PrimeFinder {

    public static int findNthPrime(int n) {
        // Implement this method.
        int start=2;
        while(true){
            if(isPrime(start))n--;
            if(n==0)break;
            start++;
        }
        return start;
        
    }
    public static boolean isPrime(int x){
        for(int i=2;i<x;i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int result = findNthPrime(n);
        System.out.println(result);
    }
}
