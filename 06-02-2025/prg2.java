// In a distant galaxy, an ancient civilization built a hierarchical communication 
// network of interconnected relay stations. The structure of this network can be 
// reconstructed using two ancient data logs:
//     - Beacon Activation Order (analogous to in-order traversal)
//     - Final Signal Sent Order (analogous to post-order traversal)

// Using these logs, we can reconstruct the original relay network and process 
// queries about signals reaching specific hierarchical levels.

// Given the Beacon Activation Order and the Final Signal Sent Order of a galactic 
// communication network, reconstruct the relay network. After reconstructing the 
// hierarchy, process multiple queries to identify which stations transmitted 
// signals within a given range of levels. Each query consists of a lower level 
// and an upper level, and the output should list the relay stations in the order 
// they appear in a level-wise transmission sequence.

// Input Format:
// -------------
// An integer N representing the number of relay stations in the network.
// A space-separated list of N integers representing the Beacon Activation Order (similar to in-order traversal).
// A space-separated list of N integers representing the Final Signal Sent Order (similar to post-order traversal).
// An integer Q representing the number of queries.
// Q pairs of integers, each representing a query in the form:
// Minimum Transmission Depth (L)
// Maximum Transmission Depth (U)

// Output Format:
// --------------
// For each query, print the relay stations in order of their signal transmissions within the given depth range


// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 4 5 2 6 7 3 1
// 2
// 1 2
// 2 3

// Sample Output:
// --------------
// [1, 2, 3]
// [2, 3, 4, 5, 6, 7]


// Explanation:
// ------------
// The logs correspond to the following hierarchical relay network:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7
// Query 1 (Transmission Levels 1 to 2): 1 2 3
// Query 2 (Transmission Levels 2 to 3): 2 3 4 5 6 7
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
        int post[] = new int[n];
        for(int i=0;i<n;i++){
            in[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            post[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int query[][] = new int[m][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<2;j++){
                query[i][j]=sc.nextInt();
            }
        }
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<n;i++){
            inMap.put(in[i], i);
        }
        TreeNode root = build(in, post, 0, n-1, 0, n-1, inMap);
        List<List<Integer>> res = traverse(root);
        // System.out.println(res);
        for(int i=0;i<m;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=query[i][0];j<=query[i][1];j++){
                List<Integer> l = new ArrayList<>(res.get(j-1));
                // System.out.println(l);
                for(int x:l) temp.add(x);
                
            }
            System.out.println(temp);
        }
            
    }
    public static TreeNode build(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> inMap){
        if(inStart > inEnd || postStart> postEnd) return null;
        
        int rootVal = post[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inMap.get(rootVal);
        int leftSize = rootIdx - inStart;
        
        root.left = build(in, post, inStart, rootIdx-1, postStart, postStart+leftSize-1, inMap);
        root.right = build(in , post, rootIdx+1, inEnd, postStart+leftSize, postEnd-1, inMap);
        
        return root;
    }
    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> l= new ArrayList<>();
            for(int i=0;i<len;i++){
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
