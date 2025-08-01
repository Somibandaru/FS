/*Mr Ashoka planted N trees in a land around the Flag Post which is at the center 
of the land, i.e., (0,0) position. You will be given the positions of N trees
as trees[], where tree[i]=[Xi,Yi], where Xi, Yi are the positions of i-th tree
with respect to X-axis and Y-axis. And you are also an integer C.

The distance between any two trees on the land plane is the Euclidean distance 
(i.e., sqrt((x1 - x2)^2 + (y1 - y2)^2).

Your task is to return positions of the C trees Nearest to the Flag post. 
The answer is supposed to be sorted based on distance, if the distances 
are same keep the original order of the trees[].


Input Format:
-------------
Line-1: Two space separate integers, N and C
Next N Lines: Two space separated integers, x,y

Output Format:
--------------
Print the positionf of C Nearest Trees.

Sample Input-1:
---------------
4 4
-3 -3
3 -3
3 3
-3 3

Sample Output-1:
----------------
[-3, -3] [3, -3] [3, 3] [-3, 3]


Sample Input-2:
---------------
4 3
2 -1
1 2
2 4
3 2

Sample Output-2:
----------------
[2, -1] [1, 2] [3, 2]
*/
import java.util.*;
class Tree{
	int x, y, dist, i;
	Tree(int x, int y, int i){
		this.x = x;
		this.y = y;
		this.dist = x*x + y*y;
		this.i = i;
	}
}
class day1{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		Tree t[] = new Tree[n];
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y=sc.nextInt();
			t[i] = new Tree(x, y, i);
			
		}
		Arrays.sort(t, (a,b)->{
			if(a.dist!=b.dist) return a.dist-b.dist;
			return a.i-b.i;
		});
		
		List<List<Integer>> res = new ArrayList<>();
		for(int i=0;i<c;i++) {
			res.add(Arrays.asList(t[i].x, t[i].y));
		}
		System.out.println(res);
		
	}
}
