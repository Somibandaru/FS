// You are given a crystal with an energy level n. Your goal is to discover all 
// the different ways this crystal could have been created by combining smaller shards.

// Each combination must:
// - Use only shards with energy values between 2 and n - 1.
// - Be represented as a list of shard values whose product equals n.
// - Use any number of shards (minimum 2), and the order is ascending order.

// Your task is to return all unique shard combinations that can multiply together
// to recreate the original crystal.

// Example 1:
// ---------
// Input:
// 28

// Output:
// [[2, 14], [2, 2, 7], [4, 7]]

// Example 2:
// ----------
// Input:
// 23

// Output:
// []



// Constraints:
// - 1 <= n <= 10^4
// - Only shards with energy between 2 and n - 1 can be used.
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        bt(n, res, new ArrayList<>(), 1, 2);
        // Collections.sort(res, Comparator.comparingInt(a->a.get(0)));
        System.out.println(res);
    }
    public static void bt(int n, List<List<Integer>> res, List<Integer> l, int prod, int start){
        if(prod>n)return;
        if(prod==n){
            Collections.sort(l);
            if(!res.contains(l))
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=start;i<n;i++){
            if(n%i==0){
                l.add(i);
                bt(n, res, l, prod*i, i);
                l.remove(l.size()-1);
            }
        }
    }
}
