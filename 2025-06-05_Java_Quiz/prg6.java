// Write a java program, for given a birthdate in yyyy-MM-dd format, calculate the person’s current age in years, months, and days.

// Input:
// ------
// 1990-05-25

// Output:
// -------
// Age: 34 years, 0 months, 10 days
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate t1 = LocalDate.parse(sc.nextLine(), format);
        
        LocalDate t2 = LocalDate.now();
        
        Period p = Period.between(t1, t2);
        
        System.out.println("Age: "+p.getYears()+" years, "+p.getMonths()+" months, "+p.getDays()+" days");
    }
}
