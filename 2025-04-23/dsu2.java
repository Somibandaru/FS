/*You are a database integrity engineer working for a global cloud company. 
Your team maintains a distributed database network, where each server either:
    - Stores equivalent data to another server (serverX == serverY).
    - Stores different data from another server (serverX != serverY).

The transitive consistency rule must be followed:
    - If A == B and B == C, then A == C must be true.
    - If A == B and B != C, then A != C must be true.

Your task is to analyze the given constraints and determine whether they 
follow transitive consistency. If all relations are consistent, return true; 
otherwise, return false

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false

Explanation:
------------
{a, b} form one equivalence group.
{c} is declared equal to {a} (c == a), which means {a, b, c} should be equivalent.
However, b != c contradicts b == a and c == a.

Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true
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
        if(p[x]!=x) p[x] = find(p[x]);
        return p[x];
    }
    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px==py)return;
        if(px<py)p[py] = px;
        else p[px] = py;
    }
}
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        DSU dsu = new DSU();
        for(int i=0;i<str.length;i++){
            if(str[i].substring(1, 3).equals("==")){
                int x = str[i].charAt(0)-'a';
                int y = str[i].charAt(3)-'a';
                dsu.union(x, y);
            }
        }
        boolean res=true;
        for(int i=0;i<str.length;i++){
            if(str[i].substring(1, 3).equals("!=")){
                int x = str[i].charAt(0)-'a';
                int y = str[i].charAt(3)-'a';
                if(dsu.find(x)==dsu.find(y)){
                    res=false;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
