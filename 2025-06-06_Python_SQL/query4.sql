/*
Write a SQL query to retrieve the top 5 students based on their total marks 
across all subjects.


---------------
Database Name: fs
---------------

TABLE: student_marks
-------------------
    student_id INT,
    student_name VARCHAR(50),
    subject VARCHAR(30),
    marks INT



Sample Output:
--------------
student_id      student_name    total_marks                                     
3               Charlie         183                                                             
5               Eva             181                                                             
2               Bob             175                                                             
1               Alice           155                                                             
4               David           138  


*/
use fs;

select student_id, student_name, sum(marks) as total_marks
from student_marks 
group by student_id, student_name
order by total_marks desc
-- select * from student_marks
