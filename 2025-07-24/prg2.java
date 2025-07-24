package dsaRoundPrep;

/*
Vihaan is given a list of words[]. 
He is asked to create a method which returns the numbers of characters in a word 
formed from long lasting frequent posteriority.

Posteriority is the word formed from the original word with few characters removed
without modifying the corresponding order of the left over characters.

An uncommon posteriority between the list of words is a word that is a posteriority
of one word but not the others.

Your task is to find the longest uncommon posteriority of the list of words.
Return 0 if no uncommon posteriority.


Input Format:
-------------
Space separated strings words[]

Output Format:
--------------
Print an integer, the length of longest uncommon prosperity.


Sample Input-1:
---------------
mom rar ama

Sample Output-1:
----------------
3


Sample Input-2:
---------------
ppp ppp pp

Sample Output-2:
----------------
-1
*/
import java.util.*;
class day1{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String input[] = sc.nextLine().split(" ");
		Arrays.sort(input, (a,b)->b.length()-a.length());
		
		for(int i=0;i<input.length;i++) {
			if(check(i, input[i], input)){
				System.out.println( input[i].length());
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
	public static boolean check(int idx, String s, String[] input) {
		for(int i=0;i<input.length;i++) {
			if(i==idx)continue;
			if(s.equals(input[i]))return false;
			
			int x=0, y=0;
			while(x<s.length() && y<input[i].length()) {
				if(s.charAt(x)==input[i].charAt(y)) x++;
				y++;
			}
			if(x==s.length())return false;
			
		}
		return true;
	}
}
