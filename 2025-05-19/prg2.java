// Arjun wants to build some homes in a land of size R*C.
// He wanted to construct homes in rectangular shape.
// The place which is remained will be used for gradening.
// Accordingly he has prepared the plan and given as
// an 2d array plan[][], where 1 indicates home, and 0 indicates garden area.

// A home is set of cells with value 1 in rectangular shape.
// He wants to findout all the homes in the plan and store their co-ordinates in 
// the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting
// co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate 
// (bottom right corner) of i-th home.

// Your task is to help Arjun to find all the homes and return the coords[][] of 
// all the homes from top left corner to bottom right corner.

// NOTE: No two homes are adjacent to each other in 4 directions,
// (left, right, top, bottom).

// Input Format:
// -------------
// Line-1: Two integers R and C, size of the land.
// Next R lines: C space separated integers, either 0 or 1
// 0- represents garden area land and 1- represents the home.

// Output Format:
// --------------
// Print 2d array, the co-ordinates of all homes.


// Sample Input-1:
// ---------------
// 2 3
// 1 0 0
// 0 1 1
 
// Sample Output-1:
// ----------------
// [0, 0, 0, 0][1, 1, 1, 2]


// Sample Input-2:
// ---------------
// 4 4
// 1 1 0 1
// 0 0 0 0
// 1 1 0 1
// 1 1 0 1
 
// Sample Output-2:
// ----------------
// [0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]

import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) arr[i][j] = sc.nextInt();
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    int end[] = new int[2];
                    dfs(arr, i, j, end);
                    List<Integer>temp= new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    temp.add(end[0]);
                    temp.add(end[1]);
                    res.add(new ArrayList<>(temp));
                }
            }
        }
        for(List<Integer> a:res){
            System.out.print(a);
        }
        // System.out.println(res);
    }
    public static void dfs(int[][] arr, int i, int j, int[] end){
        if(i<0||j<0||i>=arr.length||j>=arr[0].length||arr[i][j]==0)return;
        arr[i][j]=0;
        end[0]=Math.max(i, end[0]);
        end[1]=Math.max(j, end[1]);
        dfs(arr, i-1, j, end);
        dfs(arr, i+1, j, end);
        dfs(arr, i,j-1, end);
        dfs(arr, i, j+1, end);
    }
}
