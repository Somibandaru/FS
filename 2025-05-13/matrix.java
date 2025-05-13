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
        int res=0, size = Math.min(n, m);
        for(int i=size;i>=1;i--){
            if(isValid(arr, i))
            {res=i;
            break;
            }
        }
        System.out.println(res);
    }
    public static boolean isValid(int arr[][], int size){
        for(int i=0;i<=arr.length-size;i++){
            for(int j=0;j<=arr[0].length-size;j++){
                if(isEqual(arr, i, j, size)) return true;
            }
        }
        return false;
    }
    public static boolean isEqual(int arr[][], int r, int c, int size){
        int sum=0;
        for (int j=c; j<c+size;j++) {
            sum += arr[r][j];
        }

        for (int i=r;i<r+ size;i++) {
            int rsum = 0;
            for (int j=c;j<c+size;j++) {
                rsum+= arr[i][j];
            }
            if(rsum!=sum) return false;
        }

        for (int j=c;j<c+size;j++) {
            int csum=0;
            for (int i = r; i < r+ size; i++) {
                csum+=arr[i][j];
            }
            if (csum!=sum) return false;
        }
        int d1=0;
        for (int i=0; i<size; i++) {
            d1+=arr[r+ i][c + i];
        }
        if (d1!=sum) return false;

        int d2=0;
        for (int i=0;i<size;i++) {
            d2+=arr[r+i][c+size-1-i];
        }
        if (d2!=sum) return false;

        return true;
    }
}
