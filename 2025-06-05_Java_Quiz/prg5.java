// Write a java program that reads two timestamps (yyyy-MM-dd HH:mm:ss format) and
// display the time elapsed between them in minutes and seconds.

// Input: 
// ------
// 2025-06-04 10:30:00
// 2025-06-04 11:15:40

// Output: 
// -------
// Elapsed: 45 minutes 40 seconds
import java.util.*;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        
        LocalDateTime t1 = LocalDateTime.parse(sc.nextLine(), format);
        LocalDateTime t2 = LocalDateTime.parse(sc.nextLine(), format);
        
        Duration d= Duration.between(t1, t2);
        long sec = Math.abs(d.getSeconds());
        
        long mins = sec/60;
        long s = sec%60;
        
        System.out.println("Elapsed: "+mins+" minutes "+s+" seconds");
    }
}



       
