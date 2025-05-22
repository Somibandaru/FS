// Mr Robert is working with strings.
// He selected two strings S1 and S2, may differ in length,
// consists of lowercase alphabets only.

// Mr Robert has to update the strings S1, S2 to meet any one of the criteria:
// 	- All the alphabets in S1 should be less than all the alphabets in S2.
// 	- All the alphabets in S2 should be less than all the alphabets in S1.
// 	- Both S1 and S2 should have only one distinct alphabet in it.
// To Achieve, one of the criteria, you are allowed to replace any one letter in 
// the string with any other lowercase alphabet.

// Your task is to help Mr Robert, to find the minimum replacements to be done to 
// update the strings S1 and S2 to meet one of the criteria mentioned above.

// Input Format:
// -------------
// Two space separated strings S1 and S2.

// Output Format:
// --------------
// Print an integer, minimum number of replacements.

// Sample Input-1:
// ---------------
// apple ball

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// Consider the best way to make the criteria true:
// - Update S2 to "baaa" in 2 replacements, and Update S1 to "cpple" in 1 replacement
// then every alphabet in S2 is less than every alphabet in S1.
//         (OR)
// - Update S1 to "ppppp" in 3 replacements, then every alphabet in S2 is less 
// than every alphabet in S1.

// Sample Input-2:
// ---------------
// kmit kmec

// Sample Output-2:
// ----------------
// 2

import java.util.*;

class MinimumReplacements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for (int i = 0; i < s1.length(); i++)
            freq1[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++)
            freq2[s2.charAt(i) - 'a']++;
        int a = s1less(freq1, freq2, true);
        int b = s1less(freq1, freq2, false);
        int c = onediff(freq1, freq2, s1.length(), s2.length());
        System.out.println(Math.min(c, Math.min(a, b)));
    }

    public static int s1less(int freq1[], int freq2[], boolean flag) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 25; i++) { // 25 bcoz cutoff cant be z(i=25)
            int cnt1 = 0;
            int cnt2 = 0;
            if (flag) { // s1<s2-cutoff(i)->
                for (int j = i + 1; j < 26; j++)
                    cnt1 += freq1[j]; // cnt1->how many s1>i
                for (int j = 0; j <= i; j++)
                    cnt2 += freq2[j]; // cnt2-> how many s2<i
            } else { // s2<s1-curoff(i)->
                cnt1 = 0; // cnt1->how many s1<i
                cnt2 = 0; // cnt2->how many s2>i
                for (int j = i + 1; j < 26; j++)
                    cnt2 += freq2[j];
                for (int j = 0; j <= i; j++)
                    cnt1 += freq1[j];
            }
            min = Math.min(min, cnt1 + cnt2);
        }
        return min;
    }

    public static int onediff(int freq1[], int freq2[], int l1, int l2) {
        int min = Integer.MAX_VALUE; //
        int mfreq1 = 0;
        int mfreq2 = 0;
        for (int i = 0; i < 26; i++) {
            if (mfreq1 < freq1[i])
                mfreq1 = freq1[i];
            if (mfreq2 < freq2[i])
                mfreq2 = freq2[i];
        }
        return (l1 - mfreq1) + (l2 - mfreq2);
    }
}