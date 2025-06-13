/*
You write a love letter to your friend. However, before your friend can read it, 
someone else takes it and rotates the characters of each word from left to right 
K times.

Your task is to determine how many of the words still remain the same even after 
this rotation.

Input Format:
-------------
input1: A string containing words separated by spaces.
input2: An integer K indicating the number of right rotations for each word.

Output Format:
--------------
An integer representing the number of words that remain unchanged after K right 
rotations.


Sample Input: 
-------------
ramram santan nnnn
3

Sample Output:
--------------
2


Sample Input: 
-------------
adasda
3

Sample Output:
--------------
0

*/
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int k = sc.nextInt();
        int c = 0;
        for(String s : str){
            int n = s.length();
            int a = k%n;
            String s1 = s.substring(n-a,n) + s.substring(0,n-a);
            if(s1.equals(s)) c++;
        }
        System.out.println(c);
    }
}
