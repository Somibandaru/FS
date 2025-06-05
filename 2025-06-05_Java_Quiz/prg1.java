// Write a Java Program to read a sentence and print each word reversed, but 
// maintain the original word order.

// Input: 
// ------
// Java is fun

// Output:
// -------
//  avaJ si nuf
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        for(int i=0;i<str.length;i++){
            StringBuilder s = new StringBuilder(str[i]);
            s.reverse();
            System.out.print(" "+s);
        }
        
    }
}
