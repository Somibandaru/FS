// Prabhath is working on words.  He used to take out every letter that was repeated 
// in the word. 
// A word W is given to Prabhath. His objective is to eliminate every duplicate 
// letter from W such that the resultant word R contains every unique letter from W
// and did not contain any duplicate letters. 
// And R should be at the top of the dictionary order.

// NOTE:
// -----
// He is not allowed to shuffle the relative order of the letters of the word W to
// create the word R.

// Input Format:
// -------------
// A String, the word W.

// Output Format:
// --------------
// Print a String, resultant word R.


// Sample Input-1:
// ---------------
// cbadccb

// Sample Output-1:
// ----------------
// adcb


// Sample Input-2:
// ---------------
// silicosis

// Sample Output-2:
// ----------------
// ilcos
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        char ch[] = sc.next().toCharArray();
        int freq[] = new int[26];
        boolean used[] = new boolean[26];
        
        Stack<Character> st = new Stack<>();
        for(char c:ch){
            freq[c-'a']++;
        }
        for(char c:ch){
            freq[c-'a']--;
            if(used[c-'a'])continue;
            while(!st.isEmpty() && c<st.peek() && freq[st.peek()-'a']>0){
                used[st.pop()-'a']=false;
            }
            used[c-'a']=true;
            st.push(c);
            
        }
        
        String res="";
        while(!st.isEmpty()){
            res = st.pop()+res;
        }
        System.out.println(res);
        
    }
}
