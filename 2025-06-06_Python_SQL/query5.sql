/*
Write a SQL query to find the average marks scored in each subject.


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
subject     avg_marks                                                               
Math        85.4000                                                                 
Science     81.0000  


*/
use fs;

select subject, avg(marks) as avg_marks
from student_marks
group by subject
