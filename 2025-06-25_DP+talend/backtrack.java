// Bunny is playing with binary strings. He wants to break
// a binary string B into 3 parts, of length atleast '1',
// when we merge the 3 parts will result the string B.

// Your task is to find the count the various forms to break 
// the Binary String B into 3 parts, where each part should 
// contain equal number of 1's.


// Input Format:
// -------------
// A string S.

// Output Format:
// --------------
// Print an integer, count the various forms to break.


// Sample Input-1:
// ---------------
// 01010010

// Sample Output-1:
// ----------------
// 6

// Explanation:
// ------------
// There are six forms to break S into 3 parts 
// where each part contain the equal number of  1's.
// 01 | 01 | 0010
// 01 | 010 | 010
// 01 | 0100 | 10
// 010 | 1 | 0010
// 010 | 10 | 010
// 010 | 100 | 10


// Sample Input-2:
// ---------------
// 010010

// Sample Output-2:
// ----------------
// 0
import java.util.*;
class test{
    static int res=0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int num=ones(input);
        if(num==0){
            int n = input.length();
            System.out.println((n-1)*(n-2)/2);
            System.exit(0);
        }
        if(num%3!=0){
            System.out.println(0);
            System.exit(0);
        }
        
        int count=num/3;
        bt(input, count, 0, 0, 0);
        System.out.println(res);
    }
    public static void bt(String input, int count, int sum, int groups, int idx){
        if(idx==input.length()){
            if(groups==2 && sum==count) res++;
            return;
        }

        if(input.charAt(idx)=='0'){
            bt(input, count, sum, groups, idx+1);
        }
        else if(sum<count){
            bt(input, count, sum+1,  groups, idx+1);
        }
        
        if(sum==count && groups<2){
            if(input.charAt(idx)=='0')bt(input, count, 0, groups+1, idx+1);
            else bt(input, count, 1, groups+1, idx+1);
        }
        
    }
    public static int ones(String s){
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')c++;
        }
        return c;
    }
}
