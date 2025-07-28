// The laser show at the Lumbini Park is something not to be missed.
// But, as per govt rule they have to follow COVID-19 restrictions.
// The management planning to guide the audience to sit in the seats
// that maximizes the distance to the closest person, in order to
// practice the social distance in the auditorium.

// Please help usher to guide the audience to sit in a seat by following few rules:

// - There are N seats in a single row, seats are numbered from 0 to N-1.
// - Maximize the distance from person to the closest person.
// - If there are multiple seats with similar distance, they sit in the seat with the lowest number.
// - First person always sit in seat number 0.
// - If a person leaves the auditorium from a seat, please consider that the seat is vacant

// Create a class Auditorium and two functions in it.
// 1. int seat(): represent the seat number of audience to sit.
// 2. void leave(int s): person leaves the auditorium from a seat number 's'.

// Input Format:
// ----------------
// Line-1 -> two integers N and P, Number of seats N, Number of Operations P
// P lines of input -> each line contains funtion number and parameter list (if required).

// Output Format:
// ------------------
// Print the alloted seat numbers in one line as output.


// Sample Input-1:
// -------------------
// 10 6
// 1
// 1
// 1
// 1
// 2 4
// 1

// Sample Output-1:
// ---------------------
// 0 9 4 2 5

// NOTE:
// -----
// In the sample input:
//     - option 1 indicates, calling "int seat()" method.
//     - option 2 indicates, calling "void leave(seat_num)" method.
import java.util.*;
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = sc.nextInt();
        int arr[][] = new int[size][2];
        for(int i=0;i<size;i++){
            arr[i][0] = sc.nextInt();
            if(arr[i][0]==2){
                arr[i][1] = sc.nextInt();
            }
        }
        List<Integer> res = new ArrayList<>();

        List<Integer> seats = new ArrayList<>();
        for(int i=0;i<size;i++){
            if(arr[i][0]==1){
               
               res.add(insert(seats, n));
            }
            else seats.remove(Integer.valueOf(arr[i][1]));
        }
        System.out.println(res);
    }
    public static int insert(List<Integer> seats, int n){
        Collections.sort(seats);
        if(seats.isEmpty()) {seats.add(0); return 0;}
        
        int dist = Integer.MIN_VALUE;
        int idx=0, num=0;
        
        if(seats.get(0)!=0 && seats.get(0)>dist){
            dist = seats.get(0);
            idx = 0;
            num =0;
        }
        for(int i=1;i<seats.size();i++){
            int mid = (seats.get(i) + seats.get(i-1))/2;
            if((seats.get(i)-seats.get(i-1))/2>dist){
                dist = (seats.get(i)-seats.get(i-1))/2;
                idx = i;
                num = mid;
            }
        }
        if(seats.get(seats.size()-1)!=(n-1) && (n-1)-seats.get(seats.size()-1)>dist){
            num = n-1;
        }
        seats.add(num);
        return num;
    }
        
}
