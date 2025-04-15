/*
Arjun wants to build a swimming pool, in the backyard of his farm-house.
The backyard has an empty land of size m*n. 
Some part of the backyard is used to build the swimming pool
You will be given the m*n grid values (0's and 1's). 
where 1 indicates swimming pool, and 0 indiactes empty land.

Your task to find the perimeter of the swimming pool.

Note: There is only one swimming pool.

Input Format:
-------------
Line-1: Two integers M and N, size of the backyard.
Next M lines: N space separated integers, either 0 or 1
0- represents empty land and 1- represents the swimming pool 

Output Format:
--------------
Print an integer, the perimeter of the swimming pool


Sample Input-1:
---------------	
4 4
0 1 0 0
1 1 1 0
0 1 0 0
1 1 0 0
 
Sample Output-1:
----------------
16


Sample Input-2:
---------------
1 2
1 0
 
Sample Output-2:
----------------
4
*/

import java.util.*;
class backtrack{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        int r=0, c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j]==1){
                    r=i; c=j;
                }
            }
        }
        
        System.out.println(perimeter(arr, r, c));
    }
    public static int perimeter(int arr[][], int i, int j){
        if(i>=arr.length||j>=arr[0].length||i<0||j<0||arr[i][j]==0)return 1;
        if(arr[i][j]==-1)return 0;
        arr[i][j]=-1;
        return perimeter(arr, i+1, j)+perimeter(arr, i-1, j)+perimeter(arr, i, j+1)+perimeter(arr, i, j-1);
    }
