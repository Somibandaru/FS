/*
Ganesh has a habit of writing the words in backward order,
and writes the sentence without spaces.
 
Ganesh is given a sentence S (without spaces) and an integer C
His way of backward writing the sentence is as follows:
   - Break the sentence into 2C length words from begining to end.
   - Write the first C letters in backward direction of every 2C length word.
   - if there is a leftover word at the end of S with lenth lessthan 2C, then 
   - if length is lessthan C, write all the letters in backward direction.
   - if length is greater than or equal to C, write the first C letters
          in backward direction and keep the rest as it is.
           
 And return the sentence S after writing is completed.
 
Example of backward writing: 
Given sentence, S= "hellokmit" and C=2
Break the sentence into words: hell, okmi, t
Now apply backward writing on each word: ehll, komi, t
So, the final sentence is "ehllkomit"
 
 
Input Format:
-------------
Space separated string and integer, the word and C value
 
Output Format:
--------------
Print a string as result
 
 
Sample Input-1:
---------------
abcdefghijk 3

Sample Output-1:
----------------
cbadefihgjk
 

Sample Input-2:
---------------
appropriate 4
 
Sample Output-2:
----------------
rppaoprieta

*/
import java.util.*;
class str{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int c = sc.nextInt();
		
		List<String> l = new ArrayList<>();
		for(int i=0;i<str.length();i+=2*c) {
			if(i+2*c < str.length()) {
				l.add(str.substring(i, i+2*c));
				
			}
			else l.add(str.substring(i));
		}
		
		StringBuilder res = new StringBuilder();
		for(int i=0;i<l.size();i++) {
			StringBuilder temp = new StringBuilder();
			if(l.get(i).length()<c) {
				temp.append(l.get(i));
				temp.reverse();
				res.append(temp);
			}
			else {
				temp.append(l.get(i).substring(0, c));
				temp.reverse();
				res.append(temp);
				res.append(l.get(i).substring(c));
			}
			
		}
		System.out.println(res);
	}
}
