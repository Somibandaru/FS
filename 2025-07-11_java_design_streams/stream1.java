/*
Mr Sudhakar is working with Strings,
He is given a String S, He wants to sort the characters in S in descending order
based on the frequency of the characters. If two or more characters have same 
frequency then arrange them in sorted-order.

Your task is to help Mr Sudhakar to convert the string S into sorted order of 
frequency.

Note: The frequency of a character is the number of times it appears in the string.

Input Format:
----------------
A String S, conatins bothe lower case and upper case letters.

Output Format:
------------------
Print a string after conversion.


Sample Input-1:
---------------
divide

Sample Output-1:
----------------
ddiiev

Explanation: 
------------
d and e have same frequecy and i and v have same frequency.
So sorted-order is ddeevi.


Sample Input-2:
---------------
TomAto

Sample Output-2:
----------------
ooATmt


Sample Input-3:
---------------
rrrppp

Sample Output-3:
----------------
ppprrr
*/
import java.util.*;
import java.util.stream.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character,Long> map = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        String result = map.entrySet().stream()
            .sorted((a,b) -> {
                int compare = b.getValue().compareTo(a.getValue());
                if(compare == 0) return Character.compare(a.getKey(),b.getKey());
                else return compare;
            })
            .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue().intValue()))
            .collect(Collectors.joining());
        System.out.println(result);
    }
}
