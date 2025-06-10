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

class test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        // Step 1: LCS DP table
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        // Step 2: Reconstruct LCS
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] >= dp[i][j + 1])
                i++;
            else
                j++;
        }

        String lcs = sb.toString();
        String lcsR = rev(lcs);

        // Step 3: LPS from LCS by LCS(lcs, reverse(lcs))
        int[][] ldp = new int[lcs.length() + 1][lcs.length() + 1];
        for (int l = lcs.length() - 1; l >= 0; l--) {
            for (int k = lcs.length() - 1; k >= 0; k--) {
                if (lcs.charAt(l) == lcsR.charAt(k))
                    ldp[l][k] = ldp[l + 1][k + 1] + 1;
                else
                    ldp[l][k] = Math.max(ldp[l][k + 1], ldp[l + 1][k]);
            }
        }

        // Step 4: Output the LPS length from LCS
        System.out.println(ldp[0][0]);
    }

    public static String rev(String s) {
        StringBuilder sb = new StringBuilder(s); // Fix: pass the string
        return sb.reverse().toString();
    }
}
