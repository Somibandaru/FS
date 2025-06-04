/*
Problem: 
--------
Write a Java code to identify the nth largest number without 
sorting the array


Sample Input:
-------------
4 2
3 1 5 2

Sample Output:
--------------
3

*/
import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++) pq.add(sc.nextInt());
        
        while(k>1){
            // System.out.print(pq.poll()+" ");
            pq.poll();
            k--;
        }
        System.out.println(pq.peek());
    }
}
