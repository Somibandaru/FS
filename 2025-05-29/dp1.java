/*
Amogh is an Antiquarian, The person who collects antiques.
He found a rear keyboard which has following keys,
Keys are 'N', 'S', 'C' and 'P'

1st Key - 'N': Print one character 'N' on Console.
2nd Key - 'S': Select the whole Console.
3rd Key - 'C': Copy selected content to buffer.
4th Key - 'P': Print the buffer on Console, and append it after what has 
already been printed.

Now, your task is to find out maximum numbers of 'N's you can print
after K keystrokes . 

Input Format:
-------------
An integer K

Output Format:
--------------
Print an integer, maximum numbers of 'N's you can print.


Sample Input-1:
-------------------
3

Sample Output-1:
-------------------- 
3

Explanation: 
---------------
We can print at most get 3 N's on console by pressing following key sequence:
N, N, N



Sample Input-2:
-------------------
7

Sample Output-2:
---------------------
9
Explanation: 
---------------
We can print at most get 9 N's on console by pressing following key sequence:
N, N, N, S, C, P, P*/
import java.util.*;
class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = i;
            for(int j=2;j<=i-3;j++){
                dp[i] = Math.max(dp[i],dp[j]*(i-j-1));
            }
        }
        System.out.println(dp[n]);
        
    }

}
//using backtracking TLE
// import java.util.*;
// class test{
//     public static void main(String args[]){
//     static int max=0;
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         StringBuilder str = new StringBuilder();
//         bt(n, 0, str, 0);
//         System.out.println(max);
//     }
//     public static void bt(int n, int count, StringBuilder str, int copied){
//         if(n<0)return;
//         if(n==0){
//             max = Math.max(max, count);
//             // System.out.print(str+" ");
//             return;
//         }
//         bt(n-1, count+1, str.append('N'), copied);
//         if(count>0 && str.charAt(str.length()-1)!='C'){
//             bt(n-2, count, str.append("SC"), count);
//         }
//         if(str.charAt(str.length()-1)=='P' || str.charAt(str.length()-1)=='C')
//             bt(n-1, count+copied, str.append('P'), copied);
        
//     }
// }
