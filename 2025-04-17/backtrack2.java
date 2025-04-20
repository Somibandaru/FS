/*Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]

*/

import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        List<String[]> list = new ArrayList<>();
        int i=0;
        while(i<input.length()){
            if(input.charAt(i)=='['){
                int j=i+1;
                while(j<input.length() && input.charAt(j)!=']'){
                    j++;
                }
                String temp[] = input.substring(i+1, j).split(",");
                list.add(temp);
                i=j+1;
            }
            else{
                int j=i;
                while(j<input.length() && input.charAt(j)!='['){
                    j++;
                }
                list.add(new String[]{input.substring(i, j)});
                i=j;
                
            }
        }
        List<String> res = new ArrayList<>();
        backtrack(res, list, new StringBuilder(), 0);
        Collections.sort(res);
        System.out.println(res);
    }
    public static void backtrack(List<String> res, List<String[]> list, StringBuilder str, int start){
        if(start==list.size()){
            res.add(str.toString());
            return;
        }
        
        for(int i=0;i<list.get(start).length;i++){
            int x = str.length();
            str.append(list.get(start)[i]);
            backtrack(res, list, str, start+1);
            str.setLength(x);
        }
        
    }
        
}
