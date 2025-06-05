/*
Write a java program to read a comma-separated values file and print its 
contents in table format, replacing commas with tabs or spaces.

Input File: 
------
file.csv

Output:
-------
name age
John 20
Jane 25

Explanation:
-------------
File contains:- 

name,age
John,20
Jane,25


*/
import java.util.*;
import java.io.*;
class test{
    public static void main(String args[]) throws IOException{
        Scanner x = new Scanner();
        String input = x.next();
        Scanner sc = new Scanner(new File(input));
        while(sc.hasNextLine()){
            String l[] = sc.nextLine().split(",");
            for(String s:l){
                System.out.print(s+" ");
            }
            System.out.println();
            
        }
        
    }
}
