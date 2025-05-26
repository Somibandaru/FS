// /*
// Sharath is playing a game where there are N levels. Inorder to win the game he has to reach Nth level.

// The rule book explains "In one step you can either cross one level or two levels".

// Return the number of distinct possible ways to win the game.

// Constraints:

//     1 <= N <= 45

// Input Format:
// -------------
// Line-1: An Integer N represents number of levels.
  
// Output Format:
// --------------
// Print an integer.


// Sample Input-1:
// ---------------
// 2
  
// Sample Output-1:
// ----------------
// 2

// Explanation:
// ------------
// 1. 1-level+ 1-level =2
// 2. 2 levels in one step.
   
// Sample Input-2:
// ---------------
// 4
  
// Sample Output-2:
// ----------------
// 5

// Explanation:
// ------------
// 1. 1-level + 1-level + 1-level + 1-level = 4
// 2. 1-level + 1-level + 2-levels = 4
// 3. 1-level + 2-levels + 1-level = 4
// 4. 2-levels + 1-level + 1-level = 4
// 5. 2-levels + 2-levels  = 4
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int steps[] = new int[n+1];
        Arrays.fill(steps, -1);
        System.out.println(bt(steps, n));
        // for(int i:steps) System.out.println(i+" ");
    }
    public static int bt(int steps[], int n){
        if(n==0)return 1;
        else if(n<0) return 0;
        if(steps[n]!=-1)return steps[n];
        
        steps[n] = bt(steps, n-1) + bt(steps, n-2);
        return steps[n];
    }
}
