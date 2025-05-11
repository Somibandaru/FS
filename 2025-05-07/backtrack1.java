/*Pramod plans to design a program that generates all possible valid IP addresses from a given string S.
It is guaranteed that S contains only digits.

Help Pramod by designing a program that returns all valid IP addresses generated from S.
The IP addresses must be printed in lexicographic order.

Note:

- A valid IP address consists of exactly four integers, each ranging from 0 to 255, separated by single dots (.).
- IP address segments cannot contain leading zeros.
- Valid IP addresses must fall within the range 0.0.0.0 to 255.255.255.255.

Examples of invalid IP addresses: 123.012.234.255, 123.234.345.34.

Input Format:
-------------
A string S, contains only digits [0-9].

Output Format:
--------------
Print all possible IP addresses which are valid.


Sample Input-1:
---------------
23323311123

Sample Output-1:
----------------
[233.233.11.123, 233.233.111.23]


Sample Input-2:
---------------
12345678

Sample Output-2:
----------------
[1.234.56.78, 12.34.56.78, 123.4.56.78, 123.45.6.78, 123.45.67.8]


Sample Input-3:
---------------
02550255

Sample Output-3:
----------------
[0.25.50.255, 0.255.0.255]*/
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        List<String> l = new ArrayList<>();
        bt(l, input, "", 0, 0);

        System.out.println(l);
    }
    public static void bt(List<String> l, String input, String str, int idx, int part){
        if(idx==input.length() && part==4){
            // System.out.println(str.substring(0,str.length()-1));
            l.add(str.substring(0,str.length()-1));
            return;
        }
        if(idx>=input.length()||part>=4)return;
        for(int len=1;len<=3 && idx+len<=input.length();len++){
            String s = input.substring(idx, idx+len);
            if(isValid(s)){
                bt(l, input, str+s+".", idx+len, part+1);
            }
        }
    }
    public static boolean isValid(String str){
        if(str.length()>1 && str.startsWith("0"))return false;
        return Integer.parseInt(str)>=0 && Integer.parseInt(str)<=255;
    }
}
