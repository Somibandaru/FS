
/*
You are a student organizer, and you are given n students. Each student has two values:
    Student Name: A unique identifier for the student.
    Score: The score achieved by the student.

Your goal is to organize these students in the order of their scores (highest score first). 
If two students have the same score, order them alphabetically by their names. 

Write a program to simulate how the students are organized using a priority queue.

Input Format:
-------------
Line-1: An integer, N
Next N lines: space sepaarted string and integer, name and score of each student.

Output Format:
--------------
Organized students data as shown in samples.


Sample Input-1:
---------------
5
Alice 85
Bob 92
Charlie 78
Diana 95
Eve 88

Sample Output-1:
----------------
(Diana, 95)
(Bob, 92)
(Eve, 88)
(Alice, 85)
(Charlie, 78)


Sample Input-2:
---------------
4
Bob 90
Charlie 85
Diana 92
Alice 85

Sample Output-2:
----------------
(Diana, 92)
(Bob, 90)
(Alice, 85)
(Charlie, 85)

*/
import java.util.*;
class Task{
    String name;
    int score;
    Task(String name,int score){
        this.name = name;
        this.score = score;
    }
    
}
public class StudentOrganizer{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b)->{
            if(b.score!=a.score){
                return b.score-a.score;
            }
          
                return a.name.compareTo(b.name);
            
           
        });
        for(int i=0;i<n;i++){
            String name = sc.next();
            int score = sc.nextInt();
            pq.add(new Task(name,score));
        }
       while(!pq.isEmpty()){
           Task k = pq.poll();
           System.out.println("("+k.name+","+k.score+")");
       }
    }
}
