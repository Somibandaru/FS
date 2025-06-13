/*You are building memory management for a smart home hub where apps are loaded on-demand. 
The hub has limited memory (cache size). If an app is not in memory (cache miss), it is loaded and 
a page fault occurs. If memory is full, the Least Recently Used (LRU) app is removed.

Simulate the LRU page replacement and count total page faults.

Input Format:
-------------
- Cache size
- Space-separated app access sequence (e.g., Thermostat Camera Lights)

Output Format:
--------------
Total page faults
Final cache contents

Sample Input:
-------------
3
Thermostat Camera Lights Thermostat Camera Doorbell Lights Thermostat

Sample Output:
--------------
Total Page Faults: 6
Final Cache: [Doorbell, Lights, Thermostat]


Sample Input:
--------------
2
AC Light Fan AC Heater Light

Sample Output:
--------------
Total Page Faults: 6
Final Cache: [Heater, Light]
  */
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");
        List<String> l = new ArrayList<>();
        int pf = 0;
        for(String s : str){
            if(!l.contains(s)){
                pf++;
                if(l.size() == n) l.remove(0);
                l.add(s);
            }else{
                l.remove(s);
                l.add(s);
            }
        }
        System.out.println("Total Page Faults: " + pf);
        System.out.println("Final Cache: " + l);
    }
}
