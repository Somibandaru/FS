// Sampoornesh Babu is working with Strings.
// He is trying to form a palindrome using two strings P and Q.
// The rules to form the palindrome are as follows:
// 	- Divide the strings P and Q into two parts, and length of P and Q are same.
// 	- Division of P and Q should be done at same index position.
// 	- After Division P -> P1 + P2 and Q -> Q1 + Q2, where + indicates concatenation.
// 	- Now, check whether P1 + Q2 or Q1 + P2 forms a palindrome or not.
// 	- if palindrome is formed print 'true', otherwise 'false'. 

// For Example: 'job' can be divided in the following ways:
// ""+"job", "j"+"ob",  "jo"+"b", "job"+"".

// Your task is to help Sampoornesh Babu to find whether palindrome can be 
// formed with the strings P and Q.

// Input Format:
// -------------
// Two space separated strings P and Q

// Output Format:
// --------------
// Print a boolean value, whether can you form a palindrome or not.

// Sample Input-1:
// ---------------
// mortal carrom

// Sample Output-1:
// ----------------
// true

// Explanation:
// ------------
// Divide P="mortal" and Q="carrom" at index 3 as follows:
//     P -> "mor" + "tal", P1 = "mor" and P2 = "tal"
//     Q -> "car" + "rom", Q1 = "car" and Q2 = "rom"

// P1 + Q2 = "morrom" is a palindrome,so print true.

// Sample Input-2:
// ---------------
// romans carrom

// Sample Output-2:
// ----------------
// false
//leetcode-1616

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public boolean check(String p, String q) {
        int i = 0;
        int j = p.length() - 1;
        while (i < j && p.charAt(i) == q.charAt(j)) {
            i++;
            j--;
        }
        return palin(p, i, j) || palin(q, i, j);
    }

    public boolean palin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}