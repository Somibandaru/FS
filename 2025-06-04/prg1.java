/*
Problem: Write a program to count each word's first index and total occurrences 
in a sentence.

Sample Input: 
apple banana apple orange banana apple

Sample Output:
apple -> first index: 0, count: 3
banana -> first index: 6, count: 2
orange -> first index: 19, count: 1

*/
import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        String s[] = str.split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Integer> l = new ArrayList<>();
        
        int i=0;
        for(int j=0;j<s.length;j++){
            int idx=0;
            if(j==0){
                idx = str.indexOf(s[j]+" ");
                if(!map.containsKey(s[j])) l.add(idx);
            }
            else if(j==s.length-1){
                idx = str.indexOf(" "+s[j]);
                if(!map.containsKey(s[j])) l.add(idx+1);
            }
            else{
                
                 idx = str.indexOf(" "+s[j]+" ");
                 if(!map.containsKey(s[j])) l.add(idx+1);
            }
                
            map.put(s[j], map.getOrDefault(s[j], 0)+1);
            
            i+=s[j].length()+2;
        }
        
        int a=0;
        for(String x:map.keySet()){
            System.out.println(x+" -> first index: "+l.get(a)+", count: "+map.get(x));
            a++;
        }
    }
}
