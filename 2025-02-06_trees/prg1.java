// In a distant galaxy, an ancient civilization built a hierarchical communication 
// network of interconnected relay stations. The structure of this network can be 
// reconstructed using two ancient data logs:
//     - Beacon Activation Order (analogous to in-order traversal)
//     - Final Signal Sent Order (analogous to post-order traversal)
    
// Using these logs, we can reconstruct the original relay network and process q
// ueries about signals reaching specific hierarchical levels.

// Given the Beacon Activation Order and the Final Signal Sent Order of a galactic 
// communication network, reconstruct the relay network. After reconstructing 
// the hierarchy, and the output should list the relay stations in the order they 
// appear in a level-wise transmission sequence.

// Input Format:
// -------------
// - An integer N representing the number of relay stations in the network.
// - A space-separated list of N integers representing the Beacon Activation Order 
//     (similar to in-order traversal).
// - A space-separated list of N integers representing the Final Signal Sent Order 
//     (similar to post-order traversal).

// Output Format:
// --------------
// A list of integers, level-wise transmission sequence.


// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 4 5 2 6 7 3 1
// Sample Output:
// ---------------
// [1, 2, 3, 4, 5, 6, 7]


// Explanation:
// The logs correspond to the following hierarchical relay network:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7
// The level order is : 1 2 3 4 5 6 7 
import java.util.*;
class TreeNode{
    int val=0;
    TreeNode left, right;
    TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int in[] = new int[n];
        int post[] = new int[n];
        for(int i=0;i<n;i++){
            in[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            post[i] = sc.nextInt();
        }
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<n;i++){
            inMap.put(in[i], i);
        }
        TreeNode root = buildTree(in, post, 0, n-1, 0, n-1, inMap);
        
        System.out.println(traversal(root));
    }
    public static TreeNode buildTree(int[] in, int[] post,int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> inMap){
        if(inStart>inEnd || postStart>postEnd){
            return null;
        }
        
        int rootVal = post[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inMap.get(rootVal);
        int leftSize = rootIdx - inStart;
        
        root.left = buildTree(in, post, inStart, rootIdx-1, postStart, postStart+leftSize-1,inMap);
        root.right = buildTree(in, post, rootIdx+1, inEnd, postStart+leftSize, postEnd-1, inMap);
        
        return root;        
    }
    public static List<Integer> traversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            res.add(cur.val);
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right!=null){
                q.add(cur.right);
            }
        }
        return res;
        
    }
}
