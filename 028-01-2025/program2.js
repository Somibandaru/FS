/*
Given an array of product objects, each with name, price, 
and inStock (boolean). Use filter to include only products 
that are in stock, map to get their quantities, and reduce 
to find the total quantity of these in-stock products.


Sample Input:
-------------
5
Laptop 1000 5 true
Phone 500 3 false
Tablet 300 8 true
Monitor 200 6 false
Keyboard 50 12 true

Sample Output: 
--------------
25

Explanation:
------------
In-stock products are Laptop, Tablet, and Keyboard.
Quantities are 5, 8, and 12.
Total quantity = 5 + 8 + 12 = 25

*/
const readline = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout
});

function solution(products) {
  //Write your code here and return number
  const result = products.filter(p=>p.inStock)
                         .map(p=>p.quantity)
                         .reduce((acc,num)=>acc+num,0)
    return result;
}

readline.question("", (N) => {
  N = parseInt(N);
  let products = [];
  let count = 0;

  readline.on("line", (line) => {
    const [name, price, quantity, inStock] = line.split(" ");
    products.push({ name, price: parseFloat(price), quantity: parseInt(quantity), inStock: inStock === 'true' });
    count++;

    if (count === N) {
      const totalQuantity = solution(products);
      console.log(totalQuantity);
      readline.close();
    }
  });
});

-----------------------------------------------------------------------------
/*
You are a treasure hunter exploring an ancient vault filled with 
treasure boxes. The vault is represented as an array treasures of 
n integers, where each integer corresponds to the value of a treasure. 
You have a special key that allows you to scan and select treasures 
from a sub-vault (a segment of the array) of size k. Additionally, 
you have a magical power factor f and a priority filter x.

The priority-weighted treasure sum of a sub-vault is calculated as follows:
	1. Count the occurrences of each treasure value in the sub-vault.
	2. Assign a priority score to each treasure based on its frequency 
	multiplied by the treasure's value raised to the power of f 
	(i.e., priority_score[treasure] = frequency[treasure] * (value^f)).
	3. Select only the top x treasures based on their priority scores. 
	If two treasures have the same priority score, the treasure with 
	the higher value is prioritized.
	4. Calculate the total value of the selected treasures.

Your task is to return an integer array priority_sums of length n - k + 1, 
where priority_sums[i] represents the priority-weighted treasure sum for 
the sub-vault corresponding to treasures[i..i + k - 1].

Input Format:
---------------
Line-1: Four space separated integers, N, K, X, F
Line-2: N space separated integers, boxes[].

Output Format:
-----------------
An integer array, priority_sums[], of length n - k + 1


Sample Input-1:
-----------------
8 5 2 2
1 2 3 1 2 2 3 4

Sample Output-1:
--------------------
[7, 9, 10, 7]

Explanation:
We calculate the priority-weighted treasure sum for each sub-vault:

1. Sub-vault 1: [1, 2, 3, 1, 2]
   - Frequencies: {1: 2, 2: 2, 3: 1}
   - Priority scores:
     - 1 → 2 * (1^2) = 2
     - 2 → 2 * (2^2) = 8
     - 3 → 1 * (3^2) = 9
   - Top 2 treasures by priority: 3 (score 9) and 2 (score 8).
   - Total value: 2 + 3 + 2  = 7.

2. Sub-vault 2: [2, 3, 1, 2, 2]
   - Frequencies: {2: 3, 3: 1, 1: 1}
   - Priority scores:
     - 2 → 3 * (2^2) = 12
     - 3 → 1 * (3^2) = 9
     - 1 → 1 * (1^2) = 1
   - Top 2 treasures by priority: 2 (score 12) and 3 (score 9).
   - Total value: 2 + 2 + 2 + 3 = 9.

3. Sub-vault 3: [3, 1, 2, 2, 3]
   - Frequencies: {3: 2, 2: 2, 1: 1}
   - Priority scores:
     - 3 → 2 * (3^2) = 18
     - 2 → 2 * (2^2) = 8
     - 1 → 1 * (1^2) = 1
   - Top 2 treasures by priority: 3 (score 18) and 2 (score 8).
   - Total value: 3 + 2 + 2 + 3 = 10.

4. Sub-vault 4: [1, 2, 2, 3, 4]
   - Frequencies: {1: 1, 2: 2, 3: 1, 4: 1}
   - Priority scores:
     - 2 → 2 * (2^2) = 8
     - 3 → 1 * (3^2) = 9
     - 4 → 1 * (4^2) = 16
     - 1 → 1 * (1^2) = 1
   - Top 2 treasures by priority: 4 (score 16) and 3 (score 9).
   - Total value: 3 + 4  = 7.

Sample Input-2:
-----------------
6 3 2 1
5 5 6 7 5 6

Sample Output-1:
--------------------
[16, 13, 13, 13]

Constraints:
1. 1 <= n == treasures.length <= 50
2. 1 <= treasures[i] <= 50
3. 1 <= x <= k <= treasures.length
4. 1 <= f <= 10
*/
import java.util.*;
public class test{
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int f = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] sums = new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            HashMap<Integer,Integer> h = new HashMap<>();
            for(int j=i;j<i+k;j++){
                h.put(arr[j],h.getOrDefault(arr[j],0)+1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                int prA = h.get(a)*(int)Math.pow(a,f);
                int prB = h.get(b)*(int)Math.pow(b,f);
                if(prA!=prB){
                    return prB-prA;
                }
                return b-a;
            });
            for(int t:h.keySet()){
                pq.add(t);
            }
            int sum=0;
            for(int j=0;j<x && !pq.isEmpty();j++){
                int t = pq.poll();
                sum+=t*h.get(t);
            }
            sums[i]=sum;
        }
        System.out.println(Arrays.toString(sums));
       
    }
}
