// The decoration on the wall, made up of led bulbs. 
// When the bulbs turned on they emit either bule color light
// or white color light. The leds bulbs decorated in the form of a grid
// of size m*n. And when you turned on the bulbs, the bulbs are emiting
// the light in blue color (1) and white color (0).

// You are given the current state of the decorated wall of size M*N,
// Your task is to find the biggest square can be formed using blue colored bulbs,
// and return its area.

// Input Format:
// -------------
// Line-1: Two space separated integers, M and N size of the decoration grid.
// Next M lines: N space separated integers ( either 0 or 1 only).

// Output Format:
// --------------
// Print an integer, area of the biggest square grid of blue colored bulbs.


// Sample Input:
// -------------
// 5 6
// 1 0 0 1 0 1
// 0 1 1 1 1 1
// 1 1 1 1 0 1
// 0 1 1 1 0 1
// 1 0 1 0 1 1 

// Sample Output:
// --------------
// 9
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int max=0;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    if(i==0||j==0) dp[i][j]=1;
                    else dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max*max);
    }
}
