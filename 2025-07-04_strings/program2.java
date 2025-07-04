// Given two strings S1 and S2, find if S2 can match S1 or not.

// A match that is both one-to-one (an injection) and onto (a surjection), 
// i.e. a function which relates each letter in string S1 to a separate and 
// distinct non-empty substring in S2, where each non-empty substring in S2
// also has a corresponding letter in S1.

// Return true,if S2 can match S1.
// Otherwise false.

// Input Format:
// -------------
// Line-1 -> Two strings S1 and S2

// Output Format:
// --------------
// Print a boolean value as result.


// Sample Input-1:
// ---------------
// abab kmitngitkmitngit

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// aaaa kmjckmjckmjckmjc

// Sample Output-2:
// ----------------
// true

// Sample Input-3:
// ---------------
// mmnn pqrxyzpqrxyz

// Sample Output-3:
// ----------------
// false
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        System.out.println(bt(s1, s2, map, set, 0, 0));
        
    }
    public static boolean bt(String s1, String s2, HashMap<Character, String> map, Set<String> set, int idx1, int idx2){
        if(idx1==s1.length() && idx2==s2.length()) return true;
        if(idx1==s1.length() || idx2==s2.length()) return false;
        
        char ch = s1.charAt(idx1);
        
        if(map.containsKey(ch)){
            if(!s2.startsWith(map.get(ch), idx2)) return false;
            if(bt(s1, s2, map, set, idx1+1, idx2+map.get(ch).length())) return true;
        }
        else{
            for(int x=idx2+1;x<=s2.length();x++){
                String s = s2.substring(idx2, x);
                
                if(set.contains(s))continue;
                map.put(ch, s);
                set.add(s);
                
                if(bt(s1, s2, map, set, idx1+1, x)) return true;
                map.remove(ch);
                set.remove(s);
            }
        }
        return false;
    }
}
