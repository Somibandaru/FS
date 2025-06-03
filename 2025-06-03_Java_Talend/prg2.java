// Write Java code for a method which takes a String (a sentence) as input 
// and returns a HashMap. The Map key is String (word in the String) and 
// value is frequency of the word in the given sentence.
// (In the words ignore any special characters)

// Sample Input:
// ---------------
// Java is fun, and Ja#va@ is powerful 

// Sample Output:
// -----------------
// java: 2
// is: 2
// fun: 1
// and: 1
// powerful: 1
import java.util.*;
import java.util.regex.*;
class WordFrequency{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        
        Pattern p= Pattern.compile("[^a-zA-Z0-9]");
        
        for(int i=0;i<str.length;i++){
            str[i] = str[i].toLowerCase();
            Matcher m = p.matcher(str[i]);
            if(m.find()){
                String s = "";
                for(char ch:str[i].toCharArray()){
                    if(Character.isDigit(ch)||Character.isLetter(ch)) s+=ch;
                }
                str[i] = s;
                // System.out.println(s);
            }
            
            map.put(str[i], map.getOrDefault(str[i], 0)+1);
        }
        for(String x:map.keySet()){
            System.out.println(x+": "+map.get(x));
        }
        
    }
}
