// Problem 3: 
// Write a program that finds the longest substring that reads the same forwards 
// and backwards.

// Input: 
// ------
// babad

// Output: 
// -------
// bab or aba
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String res="";
        
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                String check=str.substring(i, j+1);
                
                if(isPalin(check)){
                    if(res.length()<check.length()){
                        res=check;
                    }
                }
            }
        }
        System.out.println(res);
    }
    public static boolean isPalin(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))return false;
            
        }
        return true;
    }
}
