// /*
// JVS Infra Pvt Ltd purchased a flatland of size M*N, and it is divided 
// into 1*1 cells. They mave marked some cells with red colors indicated 
// with 1 and other cells with blue color indicated with 0.

// They want build the walls in the form of rectangles by connecting four distinct 
// red colored cells on the flatland that forms an axis-aligned rectangle.
// And only the corners of the walls need to be red colored.

// Your task is to help, JVS Infra to count the number of rectangular walls
// can be built by connecting the red colored cells on the flatland.

// Input Format:
// -------------
// Line-1: Two space separated integers, M and N
// Next M lines: N space separated integers, either 0 or 1 only.

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 3 4
// 1 0 1 0
// 1 1 1 1
// 0 1 1 1

// Sample Output-1:
// ----------------
// 4

// Explanation:
// -----------
// Given flatland is:
// 1 0 1 0
// 1 1 1 1
// 0 1 1 1
// Number of rectngular walls are: 4
// rectangle-1: by connecting 1's at (0, 0), (1, 0), (0, 2), (1, 2)
// rectangle-2: by connecting 1's at (1, 1), (1, 2), (2, 1), (2, 2)
// rectangle-3: by connecting 1's at (1, 1), (1, 3), (2, 1), (2, 3)
// rectangle-4: by connecting 1's at (1, 2), (2, 2), (1, 3), (2, 3)


// Sample Input-2:
// ---------------
// 4 5
// 1 0 1 0 1
// 0 0 0 1 0
// 0 1 1 0 1
// 1 0 1 0 0

// Sample Output-2:
// ----------------
// 2
import java.util.*;
class test{
    static int count=0;
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

        for(int i=0;i<n;i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<m;j++){
                if(arr[i][j]==1)
                l.add(j);
            }
            if(l.size()>=2){

                check(arr, i, l);
            }
            l.clear();
            
        }
        System.out.println(count);
    }
    public static void check(int arr[][], int row, List<Integer> l){
        for(int i=row+1;i<arr.length;i++){
            int match=0;
            for(Integer j:l){
                if(arr[i][j]==1)match++;
            }
            if(match>=2)count+=match*(match-1)/2;
        }
    }
}
