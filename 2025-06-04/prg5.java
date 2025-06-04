/*

Write Java function to return minimum number of denominations – given an infinite
supply of each denomination of {1, 2, 5, 10, 20, 50, 100, 200,500, 2000} and 
a target value N

Sample Input: 
-------------
187

Sample Output: 
--------------
[100, 50, 20, 10, 5, 2]

*/
import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr[] = {1, 2, 5, 10, 20, 50, 100, 200,500, 2000};
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        int i=arr.length-1;
        while(i>=0){
            if(n-arr[i]>=0){
                n-=arr[i];
                res.add(arr[i]);
            } 
            else i--;
            if(n==0) break;
        }
        System.out.println(res);
    }
}
