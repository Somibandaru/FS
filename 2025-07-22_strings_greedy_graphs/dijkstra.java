// Given N satellite stations, numbered 1 to N.
// These satellites are connected to send signals from one to other.
// To send a signal from satellite 's' to satellite 'd', it takes 
// an amount of time 't'.

// You are given a list of travel times as directed edges times[i] = (s, d, t).

// Your task to find the time taken to recieve signal from a satellite station K, 
// to all N-1 satellite stations. If it is impossible, return -1 .

// Input Format:
// -------------
// Line-1 ->   Three integers, N number of satellite stations, 
//             K is the satellite to send signal and T is the number of edges.
// Next T lines -> Three space separated integers, 's' is the source, 
//             'd' is the destination, 
// 			't' is the time taken recieve signal from 's' to 'd'.

// Output Format:
// --------------
// Print an integer as your result.


// Sample Input-1:
// ---------------
// 4 2 3
// 2 1 1
// 2 3 1
// 3 4 1

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// 5 2 4
// 2 1 1
// 2 3 2
// 3 4 3
// 5 1 4

// Sample Output-2:
// ----------------
// -1


// Sample Input-3:
// ---------------
// 5 2 4
// 2 1 1
// 2 3 2
// 3 4 3
// 1 5 6

// Sample Output-3:
// ----------------
// 7
import java.util.*;
class Pair{
    int node, time;
    Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        int e = sc.nextInt();
        int arr[][] = new int[e][3];
        for(int i=0;i<e;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for(int []x:arr){
            if(!graph.containsKey(x[0])) graph.put(x[0], new ArrayList<>());
            graph.get(x[0]).add(new Pair(x[1], x[2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.time));
        pq.add(new Pair(start, 0));
        
        Map<Integer, Integer> map = new HashMap<>();
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int time = p.time;
            
            if(map.containsKey(node)) continue;
            
            map.put(node, time);
            if(graph.containsKey(node)){
                for(Pair b: graph.get(node)){
                    if(!map.containsKey(b.node)) pq.add(new Pair(b.node, time+b.time));
                }
            }
        }
        if(map.size()!=n){
            System.out.println(-1);
            System.exit(0);
        }
        
        int max=0;
        for(Integer i:map.values()){
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
