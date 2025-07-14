// /*
// A wall clock is a complete whole circle and cover 360°.
// You are given the time as HH:MM.
// Your task is to return the angle between the Hours hand and Minutes hand
// of the clock and the angle should not be reflex angle.

// Input Format:
// -------------
// A string time, HH:MM

// Output Format:
// --------------
// Print a double result, within 10^-5 of the original value.


// Sample Input-1:
// ---------------
// 04:30

// Sample Output-1:
// ----------------
// 45.00000


// Sample Input-2:
// ---------------
// 06:15

// Sample Output-2:
// ----------------
// 97.50000
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input[] = sc.next().split(":");
        int hours = Integer.parseInt(input[0]);
        int mins = Integer.parseInt(input[1]);
        
        double h = 30*hours +0.5*mins;
        double m = 6*mins;
        double angle = Math.abs(h-m);
        
        System.out.println(angle>180?360-angle:angle);
    }
}
