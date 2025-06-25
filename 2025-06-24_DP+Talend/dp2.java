// /*
// Gopal would like to go on Tour, and planned a schedule.
// Airport authority has created a new way of issuing tickets.
// Gopal purchased a set of airline tickets, 
// each ticket contains the 'departure from' and 'arrival to'.

// Redesign the Gopal's tour schedule in an order.
// Gopal intially must begin his tour from BZA.
// Hence the tour schedule's start point should begin with BZA. 

// You are given a list of flight tickets which Gopal has purchased.
// Your task is to find out and return the tour schedule that has the least 
// lexical order. Gopal must use all the tickets once and only once.

// Note:
// ------
// If there are multiple valid schedules, you should return the schedule 
// that has the smallest lexical order when read as a single string. 
// For example, the schedule ["BZA", "LGA"] has a smaller lexical order 
// than ["BZA", "LGB"].

// All airports are represented by three capital letters.
// You may assume all tickets form at least one valid schedule.

// Input Format:
// -------------
// Single Line of tickets separated by comma, and each ticket separated by space, 
// Gopal's flight tickets.

// Output Format:
// --------------
// Print the schedule, which is smallest lexical order of tour schedule.


// Sample Input-1:
// ----------------
// DEL HYD,BZA DEL,BLR MAA,HYD BLR

// Sample Output-1:
// --------------------
// [BZA, DEL, HYD, BLR, MAA]


// Sample Input-2:
// ------------------
// BZA BLR,BZA CCU,BLR CCU,CCU BZA,CCU BLR

// Sample Output-2:
// ------------------
// [BZA, BLR, CCU, BZA, CCU, BLR]
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input[]= sc.nextLine().split(",");
        List<String> res = new ArrayList<>();
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for(String s:input){
            String strs[] = s.split(" ");
            String from = strs[0];
            String to = strs[1];
            
            if(!map.containsKey(from)) map.put(from, new PriorityQueue<>());
            map.get(from).add(to);
            
        }
        dfs("BZA", map, res);
        System.out.println(res);
    }
    public static void dfs(String key, Map<String, PriorityQueue<String>> map, List<String> res){
        PriorityQueue<String> pq = map.get(key);
        while(pq!=null && !pq.isEmpty()){
            dfs(pq.poll(), map, res);
        }
        res.add(0, key);
    }
}
