/*Write a program that takes an IP address and subnet mask (in CIDR notation, 
e.g., 192.168.1.1/24) as input and calculates the subnet mask in dotted decimal 
format.

Input Format:
---------------
An integer, CIDR

Output Format:
---------------
String, Subnet's IP Address


Sample Input-1:
---------------
25

Sample Output-1:
----------------
255.255.255.128


Sample Input-2:
---------------
22

Sample Output-2:
----------------
255.255.252.0
*/

/*
Write a program that takes an IP address and subnet mask (in CIDR notation, 
e.g., 192.168.1.1/24) as input and calculates the network and broadcast addresses.

Input Format:
---------------
A String, IPAddress
An integer, CIDR

Output Format:
---------------
Space separated IP addresses, netwrok IP and broadcast IP.


Sample Input-1:
-----------------
192.168.1.10
24

Sample Output-1:
------------------
192.168.1.0 192.168.1.255


Sample Input-2:
-----------------
192.0.2.1
24

Sample Output-2:
------------------
192.0.2.0 192.0.2.255
*/

import java.util.*;
class fs_30_01_cn1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int cidr = sc.nextInt();
        sc.close();
        int mask = 0xffffffff << (32-cidr);
        System.out.println(String.format("%d.%d.%d.%d",
            (mask >> 24) & 0xff,
            (mask >> 16) & 0xff,
            (mask >> 8) & 0xff,
            mask& 0xff)
        );
    }
}
