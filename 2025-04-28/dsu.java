// You're working as a network administrator for a new startup that has set up 
// N computers in its office. Due to cost constraints, they’ve haphazardly laid out
// Ethernet cables between computers. Each cable connects exactly two computers, 
// and no two computers are connected by more than one cable.

// The management wants every computer to be part of a fully connected network, 
// where any computer can reach any other either directly or indirectly. 
// You're allowed to reallocate existing cables by removing them from 
// one connection and using them to connect a new pair of computers.

// However, you cannot create new cables — you can only reuse the existing ones. 
// Your task is to determine the minimum number of such cable reallocation 
// operations required to make the network fully connected. 
// If it’s not possible with the current number of cables, return -1.

// Input Format:
// -------------
// - N and C (integer): number of computers labeled from 0 to n - 1, and number 
// of connections.
// - C connections (List of integer pairs): each pair [a, b] represents 
// a cable directly connecting computers a and b

// Output Format:
// --------------
// An integer result.


// Sample Input-1:
// ---------------
// 4 3
// 0 1
// 0 2
// 1 2

// Sample Output-1:
// ----------------
// 1


// Sample Input-2:
// ---------------
// 6 5
// 0 1
// 0 2
// 0 3
// 1 2
// 1 3

// Sample Output-2:
// ----------------
// 2


// Sample Input-3:
// ---------------
// 6 4
// 0 1
// 0 2
// 0 3
// 1 2


// Sample Output-3:
// ----------------
// -1
import java.util.*;
class DSU{
    int p[];
    DSU(int n){
        p = new int[n];
        for(int i=0;i<n;i++)p[i]=i;
    }
    public int find(int x){
        if(p[x]!=x)p[x] = find(p[x]);
        return p[x];
    }
    public boolean union(int x,int y){
        int px=find(x);
        int py = find(y);
        if(px==py)return false;
        p[px]=py;
        return true;
    }
}
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[m][2];
        for(int i=0;i<m;i++){
            arr[i][0]= sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        DSU dsu = new DSU(n);
        int red=0;
        for(int i=0;i<m;i++){
            if(!dsu.union(arr[i][0], arr[i][1])){
                red++;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(dsu.find(i));
        }

        if(set.size()-1<=red)System.out.println(set.size()-1);
        else System.out.println(-1);
    }
}
