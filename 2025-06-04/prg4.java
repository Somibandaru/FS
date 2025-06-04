/*

Problem: 
Write Java code to identify if given two strings are Anagrams 
(strings that contain same set of alphabets)

Sample Input: 
-------------
listen silent

Sample Output: 
--------------
true

*/
import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        char c1[] = sc.next().toCharArray();
        char c2[] = sc.next().toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        String s1 = new String(c1);
        String s2 = new String(c2);
        System.out.println(s1.equals(s2));
        
        
    }
}
