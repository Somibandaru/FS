// /*
// Mr Saurabh is given a list of words.
// Your task is to help Mr Saurabh to find the size of largest group

// A group is formed using the following rules:
// - Pick one smallest word (in length) and form a group with this word
//   (if it is not part of any other group yet)
// - Add a letter at any place in the word without changing the relative order 
//   of the letters in it, and if it forms a word which is existing in the list[],
//   then add the word to the group.
// - Repeat the above two steps, till all the words in the list are part of groups.

// NOTE:You move form more than one group.

// Input Format:
// -------------
// Space separated words, wordsList[].
// many money n an mony any one mone on
// Output Format:
// --------------
// Print an integer result


// Sample Input-1:
// ---------------
// many money n an mony any one mone on

// Sample Output-1:
// ----------------
// 5

// Explanation:
// ------------
// the words group is : [n, on, one, mone, money]


// Sample Input-2:
// ---------------
// a ab abb babb abab baba bab abbaa

// Sample Output-2:
// ----------------
// 4
import java.util.*;
class test{
    static int max=0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input[] = sc.nextLine().split(" ");
        Arrays.sort(input, (a,b)->{
            return a.length()-b.length();
        });
        bt(input, 0, new ArrayList<>());
        System.out.println(max);
    }
    public static void bt(String input[], int idx, List<String> group){
        max = Math.max(max, group.size());
        if(idx==input.length)return;
        
        for(int i=idx;i<input.length;i++){
            if(group.size()==0 || check(input[i], group.get(group.size()-1))){
                group.add(input[i]);
                bt(input, i+1, group);
                group.remove(group.size()-1);
            }
        }
        
    }
    public static boolean check(String a, String b){
        if(a.length()!=b.length()+1)return false;
        int c=0;
        int i=0, j=0;
        while(i<b.length() && j<a.length()){
            if(a.charAt(j)!=b.charAt(i)){
                c++;
                j++;
            }
            else{
                i++;
                j++;
            }
        }
        while(j<a.length()) {
            j++;
            c++;
        }
        return  c==1;
    }
}
