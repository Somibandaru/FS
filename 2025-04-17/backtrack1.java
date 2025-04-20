/*
Given a integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, where two consecutive 
values in BCS having N bits, must have one bit difference only. 
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4

*/
import java.util.*;
class back{
   public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       List<String> l = new ArrayList<>();
       Set<String> used = new HashSet<>();
       String str = "";
       for(int i=0;i<n;i++){
           str+="0";
       }
       
       backtrack(n, l, str, used);
       List<Integer> res = new ArrayList<>();
       for(String i:l){
           res.add(Integer.parseInt(i, 2));
       }
       System.out.println(l);
   }
   public static void backtrack(int n, List<String> l, String str, Set<String> used){
       l.add(str);
       used.add(str);
       
       if(l.size()==(int)Math.pow(2, n))return;
       
       for(int i=n-1;i>=0;i--){
           StringBuilder temp = new StringBuilder(str);
           char c = temp.charAt(i);
           c = c=='0'?'1':'0';
           temp.replace(i,i+1, ""+c);
           
           if(!used.contains(temp.toString())){
               backtrack(n, l, temp.toString(), used);
               if(l.size()==(int)Math.pow(2, n))return;
               l.remove(l.size()-1);
               used.remove(temp.toString());
           }
       }
   }
}
