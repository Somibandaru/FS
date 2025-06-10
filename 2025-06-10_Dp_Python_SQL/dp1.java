// Alex and his twin brother Jordan often create secret messages. One day, Jordan 
// gives Alex two encrypted messages and challenges him to find the longest common 
// palindromic pattern hidden within both messages.

// Alex wants your help to decode the longest common palindromic subsequence that 
// exists in both strings.

// Your task is to determine the length of the longest subsequence that:
// - Appears in both messages
// - Is a palindrome

// Input Format:
// -------------
// input1: A string representing the first encrypted message.
// input2: A string representing the second encrypted message.

// Output Fromat:
// --------------
// Return an integer representing the length of the longest common palindromic 
// subsequence shared by both messages.


// Sample Input: 
// -------------
// adfa
// aagh

// Sample Output:
// --------------
// 2


// Sample Input-2:
// ---------------
// abcda
// fxaaba

// Sample Output:
// --------------
// 3

// Explanation:
// ------------
// The longest palindromic subsequence common to both is "aba" with length 3.import java.util.*;
// class test{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         String str1 = sc.next();
//         String str2 = sc.next();
//         StringBuilder s1 = new StringBuilder(str1);
//         StringBuilder s2 = new StringBuilder(str2);
//         String rev1 = s1.reverse().toString();
//         String rev2 = s2.reverse().toString();
        
//         int dp[][][][] = new int[str1.length()+1][str2.length()+1][str1.length()+1][str2.length()+1];
        
//         for(int i=str1.length()-1;i>=0;i--){
//             for(int j=str2.length()-1;j>=0;j--){
//                 for(int k=str1.length()-1;k>=0;k--){
//                     for(int l=str2.length()-1;l>=0;l--){
                        
//                         if(str1.charAt(i)==str2.charAt(j) && rev1.charAt(k)==rev2.charAt(l) && str1.charAt(i)==rev1.charAt(k)){
//                             dp[i][j][k][l] = dp[i+1][j+1][k+1][l+1]+1;
//                         }
//                         else{
//                             dp[i][j][k][l] = Math.max(dp[i+1][j][k][l], Math.max(dp[i][j+1][k][l], Math.max(dp[i][j][k+1][l], dp[i][j][k][l+1])));
//                         }
//                     }
//                 }
//             }
//         }
//         System.out.println(dp[0][0][0][0]);
//     }
// }
//4D array not working😭

import java.util.*;

public class LCPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        String lcs = getLCS(s1, s2);
        int result = getLPSLength(lcs);

        System.out.println(result);
    }

    // Step 1: Longest Common Subsequence
    private static String getLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Build the LCS dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Reconstruct the LCS string
        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        return lcs.reverse().toString(); // LCS is built backwards
    }

    // Step 2: Longest Palindromic Subsequence
    private static int getLPSLength(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (i == j) dp[i][j] = 1;
                else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + ((i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return n == 0 ? 0 : dp[0][n - 1];
    }
}
