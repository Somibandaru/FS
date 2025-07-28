// /*
// Sukumar is a mathematics teacher.
// Sukumar is always intersted to create logical problems.
// He has given a problem to the students to solve it.
// Students are given sentence with set of words, students has to find two words
// W1 and W2, such that there should be no common letters between W1 and W2, 
// and return the product of W1.length and W2.length.
// If there are no such words in the sentence return 0.

// Your task is to solve the problem given by Sukumar and help the students.

// Input Format:
// -------------
// Space separated strings, the sentence with set of words[].

// Output Format:
// --------------
// Print an integer, maximum product of two max length words.


// Sample Input-1:
// ---------------
// there is an wondeful event going to happen in the school

// Sample Output-1:
// ----------------
// 30

// Explanation: 
// ------------
// The two words will be "there", "school".
// or "going", "happen"..etc


// Sample Input-2:
// ---------------
// elegant jewels are made here

// Sample Output-2:
// ----------------
// 0

// Explanation: 
// ------------
// All words have atleast one letter in common.
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input[] = sc.nextLine().split(" ");
        
        Arrays.sort(input, (a,b)->b.length()-a.length());
        
        int max=0;
        
        for(int i=0;i<input.length;i++){
            Set<Character> set = new HashSet<>();
            for(char ch:input[i].toCharArray()){
                set.add(ch);
            }
            a: for(int j=i+1;j<input.length;j++){
                int len = input[i].length()*input[j].length();
                if(len<=max) break;
                
                for(char c:input[j].toCharArray()){
                    if(set.contains(c)) continue a;
                }
                max = Math.max(max, len);
                break;
            }
        }
        System.out.println(max);
        
    }
}
