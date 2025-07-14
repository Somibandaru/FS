// Akhila is given a string S, Where S conatins only [aeiou] letters.
// A special subsequence defined as a sequence of letters derived from S
// that contains all five vowels in order. It means a specail subsequence 
// will have one or more a's followed by the one or more e's followed by 
// one or more i's followed by one or more o's followed by one or more u's.

// Your task is to help Akhila to return the length of the longest special 
// subsequence in S.

// Input Format:
// -------------
// Your code should be read input from the given attached file as a string (no line breaks)

// Output Format:
// --------------
// An integer, the length of longest subsequence.

// Sample input-1:
// ---------------
// aeeiooua

// Sample Output-1:
// ----------------
// 7

// Explanation:
// ------------
// Given S = "aeeiooua", then "aeiou" and "aeeioou" are special subsequences
// but "aeio" and "aeeioua" are not


// Sample input-2:
// ---------------
// aeiaaioooaauuuaeiou

// Sample Output-2:
// ----------------
// 10
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        char input[] = sc.next().toCharArray();
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('e',1);
        map.put('i',2);
        map.put('o',3);
        map.put('u',4);
        
        int dp[] = new int[input.length];
        int max=0;

        for(int i=0;i<input.length;i++){
            if(input[i]=='a'){
                dp[i] = 1;
            }
            for(int j=0;j<i;j++){
                if(map.get(input[i]) == map.get(input[j])+1 || input[i]==input[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if(input[i]=='u') max = Math.max(max, dp[i]);
        }
        // for(int i=0;i<input.length;i++)System.out.print(dp[i]+" ");
        System.out.println(max);
        
    }
}

