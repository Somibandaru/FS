/*

Write Java code to print system date & time in format like 
2021-10-02 10:30:00 AM

Sample Output: 2025-06-04 11:35:27 AM

*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class Solution
{
    public static void main(String[] args) 
    {
        LocalDateTime l = LocalDateTime.now();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");

        String res = l.format(format);
        System.out.println(res);
    }
}
