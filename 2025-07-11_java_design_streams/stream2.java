/*
Mr Gnanesh is working with inteegrs,
He is given a list of N tokens, the tokens are printed a number on it.
You are given the list of numbers printed on Tokens as a list[] of size N.
You need to help Mr Gnanesh, to find the top F frequent numbers printed 
on tokens.

Note: If the frequency of two tokens is same, pick the numbers in sorted order(Asc).

Input Format:
----------------
Line-1 -> Two Integers, N and F
Line-2 -> N space separated integers, list[]

Output Format:
------------------
Print a list of integers of size F, top F frequent elements.


Sample Input-1:
---------------
8 3
2 1 2 1 3 2 1 4

Sample Output-1:
----------------
[1, 2, 3]

Explanation: 
------------
2 occurs 3 times, 1 occurs 3 times, 3 occurs 1 time, 4 occurs 1 time.
So the top 3 tokens are 1,2,3.


Sample Input-2:
---------------
10 3
1 4 2 4 2 2 3 4 1 3

Sample Output-2:
----------------
[2, 4, 1]
*/
import java.util.*;
import java.util.stream.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        Map<Integer,Long> map = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        List<Integer> res = map.entrySet().stream()
            .sorted((a,b) -> {
                int compare = b.getValue().compareTo(a.getValue());
                if(compare == 0) return a.getKey().compareTo(b.getKey());
                else return compare;
            })
            .limit(f)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        System.out.println(res);
    }
}
