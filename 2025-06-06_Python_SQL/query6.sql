/*
Write a SQL query to list the student IDs and names of all students 
who scored less than 80 in any subject.

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
student_id      student_name                                                    
1               Alice                                                                   
4               David 


*/
use fs;

select distinct student_id,  student_name
from student_marks
where marks<80
