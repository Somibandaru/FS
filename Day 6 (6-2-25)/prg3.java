// In a distant future, humanity has begun interstellar colonization, establishing 
// zones of habitation and control on a new planet. Scientists have recorded two 
// types of data regarding how these zones were structured:

// 1. Survey Order (analogous to pre-order traversal) – This record details how 
// the colonization started, with the first zone established and then expanding 
// into new zones following a systematic approach.
// 2. Planetary Layout (analogous to in-order traversal) – This document shows 
// how zones were positioned relative to each other on the map, based on 
// territorial boundaries.

// Using this information, scientists need to reconstruct the colonization hierarchy 
// (binary tree of zones) and analyze areas within a specific range of levels. 
// However, due to security concerns, patrol teams will scan these zones in a 
// zigzag pattern:
//     - Odd levels (starting from 1) should be inspected from left to right.
//     - Even levels should be inspected from right to left.

// Input Format:
// -------------
// An integer N representing the number of zones colonized.
// N space-separated integers representing the Planetary Layout Order (in-order).
// N space-separated integers representing the Survey Order (pre-order).
// Two space sepaarted integers,Lower Level (L), Upper Level (U)

// Output Format:
// --------------
// Print all zone IDs within the specified levels, but in spiral order:
//     - Odd levels → Left to Right.
//     - Even levels → Right to Left.

// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 1 2 4 5 3 6 7
// 2 3

// Sample Output:
// --------------
// 3 2 4 5 6 7

// Explanation:
// ------------
// The given Planetary Layout (in-order) and Survey Order (pre-order) correspond 
// to the following colonization hierarchy:

//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7

// Levels 2 to 3 in Regular Order:
// Level 2 → 2 3
// Level 3 → 4 5 6 7 

// Spiral Order:
// Level 2 (Even) → 3 2 (Right to Left)
// Level 3 (Odd) → 4 5 6 7 (Left to Right)
import java.util.*;
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int in[] = new int[n];
        int pre[] = new int[n];
        for(int i=0;i<n;i++){
            in[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            pre[i] = sc.nextInt();
        }
        int low = sc.nextInt();
        int up = sc.nextInt();
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<n;i++){
            inMap.put(in[i], i);
        }
        TreeNode root = buildTree(in, pre, 0, n-1, 0, n-1, inMap);
        List<List<Integer>> res = traverse(root);
        for(int i=low;i<=up;i++){
            List<Integer> temp = new ArrayList<>(res.get(i-1));
            if(i%2==0){
                Collections.reverse(temp);
            }
            for(int j:temp){
                System.out.print(j+" ");
            }
        }
    }
    public static TreeNode buildTree(int[] in, int pre[], int inStart, int inEnd, int preStart, int preEnd, Map<Integer, Integer> inMap){
        if(inStart>inEnd || preStart>preEnd){
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inMap.get(rootVal);
        int size = rootIdx-inStart;
        
        root.left = buildTree(in, pre, inStart, rootIdx-1, preStart+1, preStart+size, inMap);
        root.right = buildTree(in , pre, rootIdx+1, inEnd, preStart+size+1, preEnd, inMap);
        
        return root;
    }
    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                l.add(cur.val);
            
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            res.add(new ArrayList<>(l));
            
        }
        return res;
    }
}
