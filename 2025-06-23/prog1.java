/*
Mr Rajendra Tapadia is given a number N as string to Mr Satyam, and ask him 
to find the number of ways to make that number N equal to zero by using 
the following steps:
    - He need to perform either '+' or '-' operation between two adjacent digits
    - You can repeat the above step to make the N value to 0.
    
For example: if N is 454522 then it's possible to perform the '+'/'-' operations 
the following way, 4+5-4-5-2+2, 4-5-4+5-2+2, 4+5-4-5+2-2 or 4-5-4+5+2-2.
A total of 4 ways.

Your task is to help Mr Satyam to find the number of ways possible to make N to 0
using the above steps. Print "invalid", if it is not possible.

Input Format:
-------------
A String, the number N.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
13741

Sample Output-1:
----------------
2

Explanation: 
------------
The ways are, 1+3-7+4-1 and 1-3+7-4-1.


Sample Input-2:
---------------
2351

Sample Output-2:
----------------
invalid*/
import java.util.*;
class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().split("");
        int[] a = new int[str.length];
        for(int i=0;i<a.length;i++) a[i] = Integer.parseInt(str[i]);
        int[] count = new int[1];
        bt(a,count,a[0],1);
        System.out.println(count[0]==0?"invalid":count[0]);
    }
    public static void bt(int[] a,int[] count,int sum,int index){
        if(index==a.length){
            // System.out.println(sum);
            if(sum==0) count[0]++;
            return;
        }
        if(index<a.length){
            bt(a,count,sum+a[index],index+1);
            bt(a,count,sum-a[index],index+1);
        }
    }
}
