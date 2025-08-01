// Bob Khan is working with various number systems.
// He has created two kinds of addressing systems to share information 
// between any two electronic devices.

// Addresses in Type-I has following properties:
// 	- This addressing has four parts, each part is called as 'octet'
// 	- each octet can have a decimal value between 0 to 255 only
// 	- each part is separated by periods(.) 
// 	- Leading 0's are not allowed.
// 	- each part should conatins atmost 3 digits.

// if any octet in the 4 parts, is not satisfying the rules
// specified said to be  "invalid" addressing.


// Addresses in Type-II has following properties:
// 	- This addressing has eight parts, each part is called as 'hextet'
// 	- each hextext can have a hexadecimal value between 0 to ffff only
// 	- each part is separated by colons (:) 
// 	- each part should conatins atmost 4 alphanumerics, 
// 	  as per hexademial number system.

// if any hextet in the 8 parts, is not satisfying the rules
// specified said to be "Invalid" addressing.
		
// You will be given an address as a string	addr.
// Your task is to find, whether the given address "addr" belongs to which asddress type.
// And return "Type-I" if belongs to "Type-I" Addressing, 
// return "Type-II" if belongs to "Type-II" Addressing, 
// return "Invalid" if not belongs to either "Type-I"  or "Type-II"Addressing.


// Input Format:
// -------------
// A string, an address addr.

// Output Format:
// --------------
// Print a string output, as mentioned in above statement.


// Sample Input-1:
// ---------------
// 213.234.45.12

// Sample Output-1:
// ----------------
// Type-I


// Sample Input-2:
// ---------------
// abcd:ef12:3456:7:dce8:fab9:1:0cda

// Sample Output-2:
// ----------------
// Type-II


// Sample Input-3:
// ---------------
// abcd:ef12:3456:7:0dce8:fab9:1:0cda

// Sample Output-3:
// ----------------
// Invalid


// Sample Input-4:
// ---------------
// 123.234.34@.31

// Sample Output-4:
// ----------------
// Invalid
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        if(checkOctet(input)) System.out.println("Type-I");
        else if(checkHextet(input)) System.out.println("Type-II");
        else System.out.println("INVALID");
    }
    public static boolean checkOctet(String s){
        String parts[] = s.split("\\.");
        if(parts.length!=4)return false;
        for(String x:parts){
            if(x.length()>3)return false;
            if(x.length()>1 && x.startsWith("0")) return false;
            int y=0;
            try{
                y = Integer.parseInt(x);
            }
            catch(NumberFormatException e){
                return false;
            }
            if(y<0 || y>255) return false;
        }
        return true;
    }
    public static boolean checkHextet(String s){
        String parts[] = s.split(":");
        if(parts.length!=8)return false;
        for(String x:parts){
            if(x.length()>4)return false;
            int y=0;
            try{
                y = Integer.parseInt(x, 16);
            }
            catch(NumberFormatException e){
                return false;
            }
            if(y<0 || y>0xffff) return false;
        }
        return true;
    }
}
