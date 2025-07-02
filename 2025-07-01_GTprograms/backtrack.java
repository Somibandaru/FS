// /*
// Naresh is working on expression of words.
// If you give him an expression like, [p,q,r]s[t,u],
// Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
// Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

// Naresh will be given an expression as a string EXP, like the above format.
// He needs to return all words that can be formed in like mentioned above, 
// Can you help Naresh to convert iven expression into a list of words, in
// lexicographical order.

// NOTE: 
// Expression consist of lowercase alphabets, comma, and square brackets only.

// Input Format:
// -------------
// A string EXP, expression.

// Output Format:
// --------------
// Print list of words, formed from the expression.


// Sample Input-1:
// ---------------
// [b]c[e,g]k

// Sample Output-1:
// ----------------
// [bcek, bcgk]


// Sample Input-2:
// ---------------
// [a,b][c,d]

// Sample Output-2:
// ----------------
// [ac, ad, bc, bd]


// Sample Input-3:
// ---------------
// [xyz]a[b,c]

// Sample Output-3:
// ----------------
// [xyzab, xyzac]
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        List<String[]> l = new ArrayList<>();
        int i=0;
        //[xyz]a[b,c]
        while(i<str.length()){
            if(str.charAt(i)=='['){
                i++;
                String s="";
                while(str.charAt(i)!=']')
                {   s+=str.charAt(i);
                    i++;
                }
                l.add(s.split(","));
                i++;
            }
            else{
                String s="";
                while(i<str.length() && str.charAt(i)!='['){
                    s+=str.charAt(i);
                    i++;
                }
                l.add(s.split(","));
            }
        }
        List<String> res = new ArrayList<>();
        bt(l, res, 0, "");
        Collections.sort(res);
        System.out.println(res);
    }
    public static void bt(List<String[]> l, List<String> res, int idx, String temp){
        if(idx==l.size()){
            res.add(temp);
            return;
        }
        
        for(int i=0;i<l.get(idx).length;i++){
            bt(l, res, idx+1, temp+l.get(idx)[i]);
        }
    }
}
