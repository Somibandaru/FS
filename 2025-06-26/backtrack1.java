// Basava is interested in playing with digits.
// He wants to create a set of integers of length N, using the digits[0-9].
// The rules to create the integers are as follows:
// 	- digits in each integer are like d0,d1,d2...dn-1
// 	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

// Basava is given two integers N and D, where N is length of the integer and 
// D is the difference. Can you help Basava, to create such list of integers 
// and print all the possible integers in ascending order


// Note:
// -----
// Integers with leading 0's are not allowed


// Input Format:
// -------------
// Two space separated integers N and K.

// Output Format:
// --------------
// Print all the possible integers in ascending order.


// Sample Input-1:
// ---------------
// 3 5

// Sample Output-1:
// ----------------
// [161, 272, 383, 494, 505, 616, 727, 838, 949]


// Sample Input-2:
// ---------------
// 2 3

// Sample Output-2:
// ----------------
// [14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int d = sc.nextInt();
        List<String> res = new ArrayList<>();
        
        StringBuilder str = new StringBuilder();
        bt(n, d, str, res);
        
        System.out.println(res);
    }
    public static void bt(int n, int d, StringBuilder str, List<String> res){
        if(str.length()==n){
            res.add(str.toString());
            return;
        }
        for(int i=0;i<=9;i++){
            if(str.length()==0 && i==0)continue;
            if(str.length()==0 || Math.abs(i-(str.charAt(str.length()-1) -'0'))==d){
                str.append(""+i);
                bt(n, d, str, res);
                str.deleteCharAt(str.length()-1);
            }
        }
    }

}
