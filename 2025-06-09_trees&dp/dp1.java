/*Liam is a textile artist creating a patchwork quilt. He has X types of uniquely
sized fabric patches. Each patch has a specific number of design squares on it.
Liam wants to create a perfect square pattern on the quilt using these patches.
He can use any number of patches of each type.

However, there are some square counts that he cannot achieve with these patches.
Your task is to help Liam figure out the maximum number of design squares that
cannot be formed using any combination of the available patch types.

Note: The number of design squares on any two different patches is co-prime.

Input Format:

input1: An integer X representing the number of different patch types available.
input2: An integer array representing the number of design squares each patch type contains.

Output Fromat:

Return an integer value representing the maximum number of design squares that
cannot be created on the quilt using the given patch types.

Sample Input:

2
3 5

Sample Output:

7

Explanation:

Using patches with 3 and 5 design squares, the largest number of design squares
that cannot be formed by any combination is 7.

Sample Input:

4
3 7 17 29

Sample Output:

11*/
import java.util.*;

public class QuiltDesign {

    public static int maxUnreachable(int X, int[] patches) {
        // DP array: dp[i] = true if i can be formed
        boolean[] dp = new boolean[1000];
        
        // Base case: 0 can always be formed (use no patches)
        dp[0] = true;
        
        // Fill DP table
        for (int i = 0; i <= 1000; i++) {
            if (dp[i]) {
                for (int patch : patches) {
                    if (i + patch <= 1000) {
                        dp[i + patch] = true;
                    }
                }
            }
        }
        
        // Find largest number that cannot be formed
        int result = -1;
        for (int i = 1; i <= 1000; i++) {
            if (!dp[i]) {
                result = i;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Sample Input 1:
        int X1 = 2;
        int[] patches1 = {3, 5};
        System.out.println(maxUnreachable(X1, patches1));  // Expected Output: 7
        
        // Sample Input 2:
        int X2 = 4;
        int[] patches2 = {3, 7, 17, 29};
        System.out.println(maxUnreachable(X2, patches2));  // Expected Output: 11
    }
}

