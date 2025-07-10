/*
Given a list of EventAttendance (eventId, attendeeName, durationMinutes), 
Your task is to consider only attendees who stayed ≥ 60 minutes.
For each event, display the Event ID (ascending order), List of qualified 
attendee names (alphabetically sorted) and Count of such attendees.

Example 1
---------
Sample Input:
4
E101 John 90
E101 Alice 55
E101 Zara 75
E102 Mark 120

Sample output:
E101 [John, Zara] Count=2
E102 [Mark] Count=1

Example 2
---------
Sample Input:
11
E502 Carl 90
E502 Dan 45
E501 Ana 100
E502 Evan 75
E501 Beth 61
E502 Fred 20
E301 Ron 30
E301 Tony 60
E302 Lily 75
E302 Kevin 50
E301 Maya 90

Sample Output:
E301 [Maya, Tony] Count=2
E302 [Lily] Count=1
E501 [Ana, Beth] Count=2
E502 [Carl, Evan] Count=2

*/
import java.util.*;
import java.util.stream.*;
class EventAttendance{
    String id;
    String name;
    int dur;
    public EventAttendance(String id, String name, int dur){
        this.id = id;
        this.name = name;
        this.dur = dur;
    }
}
class test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<EventAttendance> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            String[] parts = sc.nextLine().split(" ");
            String id = parts[0];
            String name = parts[1];
            int dur = Integer.parseInt(parts[2]);
            l.add(new EventAttendance(id,name,dur));
        }
        l.stream()
            .filter(e -> e.dur >= 60)
            .collect(Collectors.groupingBy(
                e -> e.id,
                TreeMap::new,
                Collectors.mapping(e -> e.name,Collectors.toList())
            ))
            .forEach((id,names) -> {
                List<String> sortedn = names.stream()
                    .sorted()
                    .collect(Collectors.toList());
                System.out.println(id + " " + sortedn + " Count=" + sortedn.size());
            });
        
    }
}
