/*Luke likes to construct and play with arrays. His dad gave him an array M of 
length N and assigned him the following tasks to be done in order:
 - reate continuous groups of size i from the array M (where i goes from 1 to N).
 - For each group of size i, find the minimum value.
 - Among all the minimums from that step, select the maximum.
 - Add this selected value as the i-th element of a new array P.
 - Repeat until i = N.

Note: Use 1-based indexing for array P in logic.

Input Format:
-------------
input1: Integer N – length of array M
input2: Integer array M of length N

Output Format:
--------------
Return the array P as output.

Sample Input:
-------------
3
1 2 3

Sample Output:
--------------
3 2 1


Sample Input: 
-------------
4
20 10 30 40

Sample Output: 
--------------
40 30 10 10
*/
//TLE
// import java.util.*;
// class test{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] a = new int[n];
//         for(int i=0;i<n;i++) a[i] = sc.nextInt();
//         int[] res = new int[n];
//         int w = 1;
//         for(int i=1;i<=n;i++){
//             int max = 0;
//             for(int j=0;j<=n-i;j++){
//                 int min = Integer.MAX_VALUE;
//                 for(int k=0;k<i;k++){
//                     min = Math.min(min,a[k+j]);
//                 }
//                 max = Math.max(max,min);
//             }
//             res[i-1] = max;
//         }
//         for(int x : res) System.out.print(x + " ");
//     }
// }





import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        
        int res[] = new int[n];
        for(int len=1;len<=n;len++){
            Deque<Integer> dq = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                while(!dq.isEmpty() && dq.peekFirst()<=i-len){
                    dq.pollFirst();
                }
                while(!dq.isEmpty() && arr[dq.peekLast()]>=arr[i]){
                    dq.pollLast();
                }
                dq.offerLast(i);
                
                if(i>=len-1){
                    max=Math.max(max, arr[dq.peekFirst()]);
                }
            }
            res[len-1] = max;
        }
        
        
        for(int i=0;i<n;i++)System.out.print(res[i]+" ");
        
    }
}
