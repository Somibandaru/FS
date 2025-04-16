/*
Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false
*/
import java.util.*;
class window{
   public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       String s1 = sc.next();
       String s2 = sc.next();
       Map<Character, String> map = new HashMap<>();
       Set<String> set = new HashSet<>();
       
       System.out.println(backtrack(0,0,s1,s2,map,set));
       
   }
   public static boolean backtrack(int i, int j, String s1, String s2, Map<Character, String> map, Set<String> set){
       if(i==s1.length() && j==s2.length())return true;
       else if(i>=s1.length() || j>=s2.length())return false;
       
       char ch = s1.charAt(i);
       
       if(map.containsKey(ch)){
           String word = map.get(ch);
           if(!s2.startsWith(word, j))return false;
           
           return backtrack(i+1, j+word.length(), s1, s2, map, set);
       }
       else{
           for(int k=j+1;k<=s2.length();k++){
               String w = s2.substring(j, k);
               
               if(set.contains(w))continue;
               
               map.put(ch, w);
               set.add(w);
               
               if(backtrack(i+1, k, s1, s2, map, set))return true;
               
               map.remove(ch);
               set.remove(w);
           }
           
       }
       return false;
   }
}
