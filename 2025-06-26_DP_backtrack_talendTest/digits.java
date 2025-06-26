/*
Basava is interested in playing with digits.
He wants to create a set of integers of length N, using the digits[0-9].
The rules to create the integers are as follows:
	- digits in each integer are like d0,d1,d2...dn-1
	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

Basava is given two integers N and D, where N is length of the integer and 
D is the difference. Can you help Basava, to create such list of integers 
and print all the possible integers in ascending order


Note:
-----
Integers with leading 0's are not allowed


Input Format:
-------------
Two space separated integers N and K.

Output Format:
--------------
Print all the possible integers in ascending order.


Sample Input-1:
---------------
3 5

Sample Output-1:
----------------
[161, 272, 383, 494, 505, 616, 727, 838, 949]


Sample Input-2:
---------------
2 3

Sample Output-2:
----------------
[14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]
*/
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        for(int i=1;i<10;i++){
            gen(n-1,d,l,i,i);
        }
        System.out.println(l);
    }
    public static void gen(int n, int diff, List<Integer> l, int curr, int x){
        if(n == 0){
            l.add(curr);
            return;
        }
        Set<Integer> set = new HashSet<>();
        if(x+diff <= 9) set.add(x+diff);
        if(x-diff >= 0) set.add(x-diff);
        for(int a : set){
            gen(n-1,diff,l,curr*10+a,a);
        }
    }
}
