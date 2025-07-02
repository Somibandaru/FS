// A merchant has two types of idols, gold and silver.
// He has arranged the idols in the form of m*n grid, 
// 	- the gold idols are represented as 1's 
// 	- the silver idols are represented as 0's.

// Your task is to find the longest consecutive arrangement of gold idols, 
// The arrangement can be either horizontal, vertical, diagonal or 
// antidiagonal, but not the combination of these.


// Input Format:
// -------------
// Line-1: Two space separated integers m and n, grid size.
// Next m lines : n space separated integers, arrangement of idols.

// Output Format:
// --------------
// Print an integer, longest arrangement of gold idols.


// Sample Input:
// ------------
// 4 5
// 1 0 1 1 1
// 0 1 0 1 0
// 1 0 1 0 1
// 1 1 0 1 1

// Sample Output:
// -------------
// 4

// Sample Input:
// -------------
// 5 7
// 1 1 1 1 0 1 0
// 0 1 1 1 0 0 0
// 0 1 1 1 0 1 1
// 1 1 0 0 1 1 1
// 1 0 0 0 0 1 1

// Sample Output
// -------------
// 5

// NOTE:
// Solve this program using DP approach only.
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int max=0;
        int dp[][][] = new int[m][n][4];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    dp[i][j][0]=1;
                    dp[i][j][1]=1;
                    dp[i][j][2]=1;
                    dp[i][j][3]=1;
                    
                    if(i-1>=0 && j-1>=0) dp[i][j][0] = Math.max(dp[i][j][0], dp[i-1][j-1][0]+1);
                    if(i-1>=0 && j+1<n) dp[i][j][1] = Math.max(dp[i][j][1], dp[i-1][j+1][1]+1);
                    if(i-1>=0) dp[i][j][2] = Math.max(dp[i][j][2], dp[i-1][j][2]+1);
                    if(j-1>=0) dp[i][j][3] = Math.max(dp[i][j][3], dp[i][j-1][3]+1);
                    
                    max = Math.max(max, Math.max(dp[i][j][0], Math.max(dp[i][j][1], Math.max(dp[i][j][2], dp[i][j][3]))));
                }
            }
        }
        System.out.println(max);
    }
}
