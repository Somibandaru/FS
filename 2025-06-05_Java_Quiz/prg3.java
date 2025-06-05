// Problem 1: 
// Write a java program that reads a sentence and counts how many times each word 
// appears. Display only the words that occur more than once.

// Input: 
// ------
// this is a test this test is easy

// Output:
// -------
// this -> 2
// is -> 2
// test -> 2
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        
        Map<String, Integer> map = new LinkedHashMap<>();
        
        for(int i=0;i<str.length;i++){
            map.put(str[i], map.getOrDefault(str[i], 0)+1);
        }
        for(String x:map.keySet()){
            if(map.get(x)>1){
                System.out.println(x+" -> "+map.get(x));
            }
        }
    }
}
