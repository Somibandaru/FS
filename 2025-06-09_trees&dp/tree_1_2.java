/*
In a distant future, humanity has begun interstellar colonization, establishing zones of habitation and control on a new planet. Scientists have recorded two types of data regarding how these zones were structured:

1. Survey Order (analogous to pre-order traversal) – This record details how the colonization started, with the first zone established and then expanding into new zones following a systematic approach.
2. Planetary Layout (analogous to in-order traversal) – This document shows how zones were positioned relative to each other on the map, based on territorial boundaries.

Using this information, scientists need to reconstruct the colonization hierarchy (binary tree of zones) and display them level wise.

Input Format:
--------------
An integer N representing the number of zones colonized.
A space-separated list of N integers representing the Planetary Layout Order (in-order).
A space-separated list of N integers representing the Survey Order ( pre-order ).

Output Format:
---------------
Print all zone IDs in level order:

Sample Input:
-------------
7
4 2 5 1 6 3 7
1 2 4 5 3 6 7

Sample Output:
---------------
3 2 4 5 6 7

Explanation:
The given Planetary Layout (in-order) and Survey Order (pre-order) correspond to the following colonization hierarchy:
        1
       / \
      2   3
     / \  / \
    4   5 6  7

Level Order: [1, 2, 3, 4, 5, 6, 7]

*/
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class test{
    public static TreeNode bt(int[] in,int[] pre,int instart,int inend,int prestart,int preend,Map<Integer,Integer> map){
        if(instart>inend) return null;
        TreeNode root = new TreeNode(pre[prestart]);
        int idx = map.get(pre[prestart]);
        int left = idx-instart;
        root.left = bt(in,pre,instart,idx-1,prestart+1,prestart+left,map);
        root.right = bt(in,pre,idx+1,inend,prestart+left+1,preend,map);
        return root;
    }
    public static void levelorder(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            System.out.print(curr.val+" ");
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] in = new int[n];
        int[] pre = new int[n];
        // List<Integer> pre = new ArrayList<>();
        for(int i=0;i<n;i++) in[i] = sc.nextInt();
        for(int i=0;i<n;i++) pre[i] = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(in[i],i);
        TreeNode root = bt(in,pre,0,n-1,0,n-1,map);
        levelorder(root);
        
    }
}
/// 2nd prog is for inorder and postorder
//  root.left = bt(in,pre,instart,idx-1,posstart,posstart+left-1,map);
// root.right = bt(in,pre,idx+1,inend,posstart+left,preend-1,map);
