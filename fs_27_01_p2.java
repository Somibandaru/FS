/*The Kingdom of CodeLand has a long bridge made of square tiles, where each tile 
is painted either red ('R') or blue ('B'). A critical mission has been assigned 
to you: ensure that a section of the bridge is sturdy enough to support heavy 
traffic. Blue tiles are reinforced, while red tiles are weak and need to be 
reinforced by painting them blue.

You are given a 0-indexed string bridge of length n, where bridge[i] represents 
the color of the i-th tile. Each character in bridge is either 'R' (red) or 'B' (blue).

Your goal is to ensure that there is at least one segment of k consecutive blue 
tiles on the bridge to support heavy traffic. You can repaint a red tile ('R') 
to a blue tile ('B') in one operation.

Write a program to determine the minimum number of repaint operations needed to 
create a segment of k consecutive blue tiles.

Input Format:
---------------
Space separated string and integer, S and K

Output Format:
-----------------
An integer value.


Sample Input-1:
------------------
RRBRBBRRBR 4

Sample Output-1:
--------------------
2

Explanation:
-------------
One way to achieve 4 consecutive blue tiles is to repaint the 1st and 8th tiles 
to get bridge = "RBBBBBBRBR".
This requires 2 operations.

Sample Input-2:
------------------
BRBRRBB 3

Sample Output-2:
--------------------
1

Explanation:
--------------
One way to achieve 3 consecutive blue tiles is to repaint the 2nd tile to get 
bridge = "BBBRRBB". This requires only 1 operation.

Sample Input-3:
------------------
BBBRRBRBRR 5

Sample Output-3:
--------------------
2

Explanation:
--------------
One way to achieve 5 consecutive blue tiles is to repaint the 4th and 9th tiles 
to get bridge = "BBBBBBBRRR". This requires 2 operations.
*/

import java.util.*;
public class fs_27_01_p2 {
    public static void main(String args[]){
        // Scanner sc = new Scanner(System.in);
        // String s = sc.next();
        // int k = sc.nextInt();
        // int min = Integer.MAX_VALUE;
        // int ans = Integer.MAX_VALUE;
        // int n = s.length();
        // for(int i=0;i<=n-k;i++){
        //     int paint = 0;
        //     for(int j=i;j<i+k;j++){
        //         if(s.charAt(j)!='B') paint++;
        //     }
        //     min = Math.min(min,paint);
        // }
        
        // System.out.println(min);
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        int l = 0, r = 0, cr = 0; 
        int min = Integer.MAX_VALUE;
        char[] s = str.toCharArray();
        int n = str.length();
        while(r<n){
            char ch = s[r];
            if(ch == 'R') cr++;
            if(r-l+1 == k){
                min = Math.min(min,cr);
                if(s[l]== 'R') cr--;
                l++;
            }
            r++;
        }
        System.out.println(min);
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxcount = 0;
        int maxlen = 0;
        int i = 0;
        for(int j=0;j<s.length();j++){
            count[s.charAt(j) - 'A']++;
            maxcount = Math.max(maxcount, count[s.charAt(j) - 'A']);
            if((j-i+1)-maxcount > k){
                count[s.charAt(i) - 'A']--;
                i++;
            }
            maxlen = Math.max(maxlen, j-i+1);
        }
        return maxlen;
    }
}