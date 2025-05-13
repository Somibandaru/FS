// Venkatadri is a maths teacher.
// He is teaching matrices to his students.
// He is given a matrix of size m*n, and it contains only positive numbers.
// He has given a task to his students to find the special matrix, 
// in the iven matrix A[m][n].
// A special matrix has following property:
// 	- The sum of elements in each row, each column and the two diagonals are equal.
// 	- Every 1*1 matrix is called as a special matrix.
// 	- The size of the special matrix should be a square, i.e., P*P.

// Your task is to help the students to find the speical matrix  with max size P.


// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the matrix.
// Next M lines: N space separated integers m and n.

// Output Format:
// --------------
// Print an integer, maximum size P of the special matrix.


// Sample Input-1:
// ---------------
// 5 5
// 7 8 3 5 6
// 3 5 1 6 7
// 3 5 4 3 1
// 6 2 7 3 2
// 5 4 7 6 2

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// The special square is:
// 5 1 6
// 5 4 3
// 2 7 3


// Sample Input-2:
// ---------------
// 4 4
// 7 8 3 5
// 3 2 1 6
// 3 2 3 3
// 6 2 3 3

// Sample Output-2:
// ----------------
// 2

// Explanation:
// ------------
// The special square is:
// 3 3
// 3 3

import java.util.*;
class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        int max=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int ans = check(a,i,j,m,n);
                max = Math.max(ans,max);
            }
        }
        System.out.println(max);
    }
    public static int check(int[][] a,int i,int j,int m,int n){
        int res = Math.min(m-i,n-j);
        
        
        for(int len=res;len>=1;len--){
            if(square(a,i,j,len)) return len;
        }
        return 1;  
    }
    public static boolean square(int[][] a,int r,int c,int len){
        int s =0;;
        for(int j=0;j<len;j++) s+=a[r][j+c];
        for(int i=0;i<len;i++){
            int row =0,col=0;
            for(int j=0;j<len;j++){
                row+=a[r+i][c+j];
                col+=a[r+j][c+i];
            }
            if(row!=s || col!=s) return false;
        }
        int d1=0,d2=0;
        for(int i=0;i<len;i++){
            d1+=a[r+i][c+i];
            d2+=a[r+i][c+len-1-i];
        }
        return d1==s && d2==s;
        
    }
}
