//Ramesh and Suresh are best friends. 
//They decided to play a word game.
//
//The game rules are as follows:
//	- The game board shows a word W consist of two characters only A and B.
//	- You are allowed to replace a pair of neighbour letters AA with BB in W.
//	- Finally, The one who failed to replace the letters will lose the game.
//
//You can assume that Ramesh will start playing the game always.
//
//Your task is to determine if Ramesh can guarantee a win.
//Print 'true', if Ramesh guarantee a win, otherwise, print 'false'.
//
//Input Format:
//-------------
//A string W, word.
//
//Output Format:
//--------------
//Print a boolean value.
//
//
//Sample Input-1:
//---------------
//AAABAAAA
//
//Sample Output-1:
//----------------
//true
//
//Explanation:
//------------
//Given word is AAABAAAA 
//Ramesh -> AAABBBAA 
//Now whatever the pair Suresh replaced with BB, 
//one more replace is possible for Ramesh
//So, there is a guarantee for Ramesh to win.
//
//Sample Input-2:
//---------------
//AAAAAA
//
//Sample Output-2:
//----------------
//true
//
//
//Sample Input-3:
//---------------
//AAABAAA
//
//Sample Output-3:
//----------------
//false

import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        char ch[] = sc.next().toCharArray();
        
        System.out.println(backtrack(ch));
    }
    public static boolean backtrack(char ch[]){
        for(int i=1;i<ch.length;i++){
            if(ch[i-1]=='A' && ch[i]=='A'){
                ch[i-1]='B';
                ch[i]='B';
                boolean wins = backtrack(ch);
                ch[i]='A';
                ch[i-1]='A';
                if(!wins)return true;
            }
        }
        return false;
    }
}
