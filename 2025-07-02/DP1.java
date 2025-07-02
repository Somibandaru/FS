// Aziz is given a set of integers SOI[], consists of both +ve and -ve integers.

// Aziz wants to find the maximum sum of contiguous subset of the SOI, with a twist.

// You have to perform the following operation before finding the maximum sum:
// - You are allowed to replace exactly one integer X, with its square value (X*X).

// Can you please help Aziz to find out the maximum sum of contiguous subset.


// Input Format:
// -------------
// Single line of space separated integers, values of the array.

// Output Format:
// --------------
// Print an integer value as result.


// Sample Input-1:
// ---------------
// -5 -3 1 2 -3 4 -4 3

// Sample Output-1:
// ----------------
// 26

// Explanation:
// ------------
// max sum is: (-5)^2 + (-3) + 1 + 2 + (-3) + 4 = 26


// Sample Input-2:
// ---------------
// 2 -2 2 2 -2 -2 2

// Sample Output-2:
// ----------------
// 10

// Explanation:
// ------------
// max sum is: 2 +(-2)^2 + 2 + 2 = 10

import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        int arr[] = new int[s.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        
        int sqDp[] = new int[arr.length];
        int dp[] = new int[arr.length];
        
        dp[0] = arr[0];
        sqDp[0] = arr[0]*arr[0];
        int max= Math.max(dp[0], sqDp[0]);
        
        for(int i=1;i<arr.length;i++){
            dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
            sqDp[i] = Math.max(sqDp[i-1]+arr[i], Math.max(dp[i-1]+arr[i]*arr[i], arr[i]*arr[i]));
            
            max = Math.max(max, Math.max(sqDp[i], dp[i]));
        }
        System.out.println(max);
        
    }
}
