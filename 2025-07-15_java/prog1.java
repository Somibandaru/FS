// /*
// There are M*N buckets of milk, all the buckets are equal in size (in ltrs).
// The buckets are initially filled with different amounts of milk in liters.

// You are given the amount of milk in the buckets as a grid of size M x N, 
// buckets[][]. You need to make that all the buckets have same quantity of Milk.
// You are allowed to perform one operation either adding M liters of Milk
// or take away M liters of Milk from the bucket in one step.

// Your task is to return the minimum number of steps required to make 
// all the buckets in the bucket grid contains same amount of Milk. 
// If it is not possible, return -1.

// Input Format:
// -----------------
// Line-1: three space sepaarted integers, A, B and M.
// Next A lines: B space sepaarted integers, amount of milk in liters.

// Ourput Format:
// -------------------
// Print the integer result.


// Sample Input-1:
// -----------------
// 2 3 5
// 5 10 15
// 20 25 40

// Sample Output-1:
// -------------------
// 11

// Explanation: 
// ------------
// We can make every bucket has equal amount of Milk to 4liters by doing
// the following: 
// - Add 5ltrs milk to 5ltrs bucket 3 times.
// - Add 5ltrs milk to 10ltrs bucket 2 times.
// - Add 5ltrs milk to 15ltrs bucket 1 time.
// - Takeaway 5ltrs milk from 25ltrs bucket 1 time.
// - Takeaway 5ltrs milk from 40ltrs bucket 4 times.
// A total of 11 operations required.


// Sample Input-2:
// -----------------
// 3 4 3
// 1 2 3 4
// 5 6 7 8
// 9 19 11 12

// Sample Output-2:
// -------------------
// -1
import java.util.*;
class test{
    static int ops=Integer.MAX_VALUE;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int milk = sc.nextInt();
        
        int arr[] = new int[m*n];
        for(int i=0;i<m*n;i++){
            arr[i] = sc.nextInt();
            if(arr[i]%milk!=arr[0]%milk){
                System.out.println(-1);
                System.exit(0);
            }
        }
        
        Arrays.sort(arr);
        // System.out.println("before "+Arrays.toString(arr));

        if(arr.length%2==1)
        {    
            find(arr, 0, arr[arr.length/2], 0, milk);
        }
        else {
            find(arr, 0, arr[arr.length/2 -1], 0, milk);
            find(arr, 0, arr[arr.length/2], 0, milk);
        }
        // System.out.println("after:"+Arrays.toString(arr));
        System.out.println(ops);
    }
    public static void find(int[] arr, int idx, int median, int curOps, int milk){
        if(idx==arr.length){
            ops = Math.min(ops, curOps);
            return;
        }
        
        if(arr[idx]<median) find(arr, idx+1, median, curOps+((median-arr[idx])/milk), milk);
        else if(arr[idx]>median) find(arr, idx+1, median, curOps+((arr[idx]-median)/milk), milk);
        else find(arr, idx+1, median, curOps, milk);
    }
}


//optimal approach
import java.util.*;

public class MilkBuckets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int M = sc.nextInt();

        int total = A * B;
        int[] arr = new int[total];

        // Input and check modulo consistency
        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }

        // Check modulo consistency
        int mod = arr[0] % M;
        for (int i = 1; i < total; i++) {
            if (arr[i] % M != mod) {
                System.out.println(-1);
                return;
            }
        }

        // Normalize values so we can safely divide differences
        for (int i = 0; i < total; i++) {
            arr[i] /= M;
        }

        Arrays.sort(arr);
        int median = arr[total / 2];

        int ops = 0;
        for (int val : arr) {
            ops += Math.abs(val - median);
        }

        // Multiply by M to get back to actual operation count
        System.out.println(ops);
    }
}

