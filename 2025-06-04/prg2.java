/*

Write a Java code to return the length of longest sub-string without repeating 
characters

Sample Input: 
-------------
abcabcbb

Sample Output: 
--------------
3


*/

import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int freq[] =new int[26];
        
        int i=0, max = 0;
        for(int j=0;j<str.length();j++){
            freq[str.charAt(j)-'a']++;
            
            while(freq[str.charAt(j)-'a']>1){
                freq[str.charAt(i)-'a']--;
                i++;
            }
            max = Math.max(max, j-i+1);
        }
        System.out.println(max);
        
    }
}
