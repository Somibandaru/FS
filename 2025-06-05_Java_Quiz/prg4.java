// Problem 4: 
// Write a program that reads a sentence, count and display the total number of 
// vowels and consonants.

// Input: 
// ------
// Hello World

// Output:
// -------
// Vowels: 3, Consonants: 7
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int v=0, c=0;
        String str = sc.nextLine();
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') v++;
            else if(Character.isLetter(ch))c++;
        }
        System.out.println("Vowels: "+v+", Consonants: "+c);
    }
}
