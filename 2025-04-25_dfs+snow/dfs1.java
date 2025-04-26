/*Pranav has a puzzle board filled with square boxes in the form of a grid. Some 
cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

The puzzle board has some patterns formed with boxes in it, 
the patterns may be repeated. The patterns are formed with boxes (1's) only, 
that are connected horizontally and vertically but not diagonally.

Pranav wants to find out the number of unique patterns in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of unique patterns in 
the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers [0, 1].

Output Format:
--------------
Print an integer, the number of unique patterns in the puzzle board.


Sample Input-1:
---------------
5 5
0 1 0 1 1
1 1 1 0 1
0 1 0 1 0
1 0 1 1 1
1 1 0 1 0

Sample Output-1:
----------------
3

Explanation-1:
------------
The unique patterns are as follows:
  1			1 1	    1 
1 1 1		  1 ,	1 1
  1	   ,	
   
   
Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
5

Explanation-2:
------------
The unique patterns are as follows:
1 1		1 1		    1		1 1	,	1
1   ,     1 ,	    1 1 ,		
*/
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    StringBuilder str = new StringBuilder();
                    dfs(arr, i, j, str);
                    set.add(str.toString()); 
                }
            }
        }
        System.out.println(set.size());
    }
    public static void dfs(int[][] arr, int i, int j, StringBuilder str){
        if(i>=arr.length||j>=arr[0].length||i<0||j<0||arr[i][j]==0){
            return;
        }
        arr[i][j]=0;
        dfs(arr, i+1, j, str.append("D"));
        dfs(arr, i-1, j, str.append("U"));
        dfs(arr, i, j+1, str.append("R"));
        dfs(arr, i, j-1, str.append("L"));
    }
}
