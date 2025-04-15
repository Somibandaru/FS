/*
Bablu is working in a construction field.
He has N number of building blocks, where the height and width of all the blocks are same.
And the length of each block is given in an array, blocks[].

Bablu is planned to build a wall in the form of a square.
The rules to cunstruct the wall are as follows:
	- He should use all the building blocks.
	- He should not break any building block, but you can attach them with other.
	- Each building-block must be used only once.
	
Your task is to check whether Bablu can cunstruct the wall as a square
with the given rules or not. If possible, print true. Otherwise, print false.

Input Format:
-------------
Line-1: An integer N, number of BuildingBlocks.
Line-2: N space separated integers, length of each block.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
6
1 2 6 4 5 6

Sample Output-1:
----------------
true


Sample Input-2:
---------------
6
5 3 2 5 5 6

Sample Output-2:
----------------
false
*/
import java.util.*;
class backtrack{
   public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int arr[] =  new int[n];
       int sum=0, max=0;
       for(int i=0;i<n;i++) {
       	arr[i] = sc.nextInt();
       	sum+=arr[i];
       	max = Math.max(arr[i],  max);
       }
       
       if(sum%4!=0)System.out.println("false");
       else if(max>sum/4)System.out.println("false");
       else {
       	int sides[] = new int[4];
       	if(check(arr, n, sides, sum/4, 0)) {
       		System.out.println("true");
       	}
       	else System.out.println("false");
       }
   }
   public static boolean check(int arr[], int n, int sides[], int target, int idx) {
   	if(idx==n) {
   		for(int i=0;i<4;i++) {
   			if(sides[i]!=target)return false;
   		}
   		return true;
   	}
   	
   	for(int i=0;i<4;i++) {
   		if(arr[idx]+sides[i]<=target) {
   			sides[i]+=arr[i];
   			if(check(arr, n, sides, target, idx+1))return true;
   			sides[i]-=arr[idx];
   		}
   	}
   	
   	return false;
   }
}



