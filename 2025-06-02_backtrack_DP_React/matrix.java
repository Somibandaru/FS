/*
You are controlling a battlefield represented by an m x n grid. 
Each cell on this grid can be one of the following:

- A reinforced barrier ('B'), blocking your laser.
- An enemy drone ('D'), your target.
- An open cell ('0'), where you can position your robot to fire.

When your robot fires its powerful laser from an open cell, 
the beam destroys all enemy drones in the same row and column 
until the beam hits a barrier ('B'). The barrier completely stops 
the laser, protecting anything behind it.

Your goal is to identify the best position (open cell) to place 
your robot so that firing the laser destroys the maximum number 
of enemy drones in a single shot. Return this maximum number.

Input format:
-------------
Line 1: Two space separated integers, represents m & n
Next M lines: each row of battlefield


Output format:
--------------
An integer, maximum number of enemy drones destroyed in a single shot.

Example 1:
----------
input=
3 4
0 D 0 0
D 0 B D
0 D 0 0

Output=
3

Explanation: placing robot at battlefield[1][1] destroys 3 enemy drones in a
single shot.

Example 2:
----------
3 3
B B B
0 0 0
D D D

Output=
1


Constraints:
- 1 <= m, n <= 500
- battlefield[i][j] is either 'B', 'D', or '0'.

*/import java.util.*;
class test{
    static int max=Integer.MIN_VALUE;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char arr[][] = new char[n][m];
        for(int i=0;i<n;i++){
            String str[] = sc.nextLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = str[j].charAt(0);
            }
        }
        int count[] = new int[1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]=='0'){
                    // System.out.println(count);
                    max = Math.max(max, count(arr, i, j));
                }
            }
        }
        System.out.println(max);
    }
    public static int count(char arr[][], int x, int y){
        int c=0;
        for(int i=x-1;i>=0;i--){
            if(arr[i][y]=='B')break;
            if(arr[i][y]=='D')c++;
        }
        for(int i=x+1;i<arr.length;i++){
            if(arr[i][y]=='B')break;
            if(arr[i][y]=='D')c++;
        }
        for(int j=y-1;j>=0;j--){
            if(arr[x][j]=='B')break;
            if(arr[x][j]=='D')c++;
        }
        for(int j=y+1;j<arr[0].length;j++){
            if(arr[x][j]=='B')break;
            if(arr[x][j]=='D')c++;
        }
        return c;

    }
}
