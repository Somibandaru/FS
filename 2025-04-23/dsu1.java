/*
In the world of secret codes and cryptography, you are entrusted with deciphering a hidden message. 
You have two encoded keys, key1 and key2, both of equal length. Each character 
in key1 is paired with the corresponding character in key2. 

This relationship follows the standard rules of an equivalence cipher:
• Self-Mapping: Every character inherently maps to itself.  
• Mutual Mapping: If a character from key1 maps to one in key2, then that 
  character in key2 maps back to the one in key1.  
• Chain Mapping: If character A maps to B, and B maps to C, then A, B, and C 
  are all interchangeable in this cipher.

Using this mapping, you must decode a cipherText, by replacing every character 
with the smallest equivalent character from its equivalence group. 
The result should be the relatively smallest possible decoded message.


Input Format:
-------------
Three space separated strings, key1 , key2 and cipherText

Output Format:
--------------
Print a string, decoded message which is relatively smallest string of cipherText.

Example 1: 
input=
attitude progress apriori
output=
aaogoog


Explanation: The mapping pairs form groups: [a, p], [o, r, t], [g, i], [e, u], 
[d, e, s]. By substituting each character in cipherText with the smallest from 
its group, you decode the message to "aaogoog".


Constraints:  
• 1 <= key1.length, key2.length, cipherText.length <= 1000  
• key1.length == key2.length  
• key1, key2, and cipherText consist solely of lowercase English letters.

*/
import java.util.*;
class DSU{
    int p[];
    DSU(){
        p = new int[26];
        for(int i=0;i<26;i++){
            p[i] = i;
        }
    }
    public int find(int x){
        if(p[x]!=x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px==py)return;
        if(px<py) p[py] = px;
        else p[px]= py;
    }
}
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        char ch1[] = sc.next().toCharArray();
        char ch2[] = sc.next().toCharArray();
        String t = sc.next();
        
        DSU dsu = new DSU();
        for(int i=0;i<ch1.length;i++){
            int a = ch1[i]-'a';
            int b = ch2[i]-'a';
            dsu.union(a, b);
        }
        String res="";
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            int x = dsu.find(c-'a');
            res+=(char)(x+'a');
            
        }
        System.out.println(res);
    }
}
