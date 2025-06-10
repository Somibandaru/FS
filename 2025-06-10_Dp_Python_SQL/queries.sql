/*
query 1: 
Task:
Write a query to find the customer who has spent the most money across all 
their 'delivered' orders.
Expected Output Columns:

customer_id
total_spent

---------------
Database Name: fstest
---------------

TABLE: orders
Field   Type    Null    Key     Default Extra                                   
order_id        int     NO      PRI     NULL                                    
customer_id     int     YES             NULL                                    
order_date      date    YES             NULL                                    
total_amount    decimal(10,2)   YES             NULL                            
payment_mode    varchar(20)     YES             NULL                            
status  varchar(20)     YES             NULL                       

-------------------

Sample Output:
--------------
customer_id	total_spent
1001	9950.75
*/
use fstest;
select customer_id, sum(total_amount) as total_spent
from orders
where status='delivered'
group by customer_id
order by total_spent desc
limit 1;
-------------------------------------------------------------------------------------------------------------------------------------------------------
/*
query 2: 
Task:
Write a SQL query to find the average value of all orders for each payment mode
(e.g., Credit Card, UPI, Net Banking, etc.).

Expected Output Columns:

payment_mode

avg_order_value (rounded to 2 decimal places)
---------------
Database Name: fstest
---------------

TABLE: orders
Field   Type    Null    Key     Default Extra                                   
order_id        int     NO      PRI     NULL                                    
customer_id     int     YES             NULL                                    
order_date      date    YES             NULL                                    
total_amount    decimal(10,2)   YES             NULL                            
payment_mode    varchar(20)     YES             NULL                            
status  varchar(20)     YES             NULL                       

-------------------
Sample Output:
--------------
payment_mode	avg_order_value
Credit Card	2937.50
UPI	2862.69
Net Banking	1960.17
Wallet	999.99

*/

use fstest;
select payment_mode, round(avg(total_amount), 2) as avg_order_value
from orders
group by payment_mode
-------------------------------------------------------------------------------------------------------------------------------------------------------


/*
query 3: 
Task:
Write a query to identify customers who placed more than one order in the
same week.

Expected Output Columns:

customer_id

yr (Year)

wk (Week Number)

order_count

---------------
Database Name: fstest
---------------

TABLE: orders
Field   Type    Null    Key     Default Extra                                   
order_id        int     NO      PRI     NULL                                    
customer_id     int     YES             NULL                                    
order_date      date    YES             NULL                                    
total_amount    decimal(10,2)   YES             NULL                            
payment_mode    varchar(20)     YES             NULL                            
status  varchar(20)     YES             NULL                       

-------------------
Sample Output:
--------------
customer_id	yr	wk	order_count
1003	2023	36	2
*/
use fstest;
select customer_id, year(order_date) as yr, weekofyear(order_date) as wk, count(*) as order_count
from orders
group by customer_id, year(order_date), wk
having count(*)>1


-------------------------------------------------------------------------------------------------------------------------------------------------------

/*
query 4: 

Task:
Write a SQL query to calculate how many days each employee was present in each
calendar month.

Expected Output Columns:

emp_id
emp_name
month (in YYYY-MM format)
working_days

---------------
Database Name: fstest
---------------

TABLE: employee_attendance

Field	Type	Null	Key	Default	Extra
emp_id	int	YES		NULL	
emp_name	varchar(50)	YES		NULL	
login_date	date	YES		NULL	
status	varchar(10)	YES		NULL	
                     

-------------------
Sample Output:
--------------
emp_id	emp_name	month	working_days
1	Alice	2023-10	2
2	Bob	2023-10	3
4	David	2023-10	3
*/
use fstest;
select emp_id, emp_name, date_format(login_date, '%Y-%m') as month, count(*) as working_days
from employee_attendance
where status='present'
group by emp_id, emp_name, month



-------------------------------------------------------------------------------------------------------------------------------------------------------

/*
query 5: 

Task:
Write a query to find employees who were absent for 3 or more days in October.

Expected Output Columns:

emp_id
absent_days

---------------
Database Name: fstest
---------------

TABLE: employee_attendance

Field	Type	Null	Key	Default	Extra
emp_id	int	YES		NULL	
emp_name	varchar(50)	YES		NULL	
login_date	date	YES		NULL	
status	varchar(10)	YES		NULL	
                     

-------------------

Sample Output:
--------------
emp_id	consecutive_absences
3	3
*/
use fstest;
select emp_id, count(*) as consecutive_absences
from employee_attendance
where status='absent' and month(login_date)=10
group by emp_id
having consecutive_absences>=3
-------------------------------------------------------------------------------------------------------------------------------------------------------

/*
query 6: 
Task:
Write a SQL query to determine which employee had the highest attendance
percentage in October 2023.
Assume each date entry counts as 1 working day.

Expected Output Columns:

emp_id
emp_name
attendance_percent
---------------
Database Name: fstest
---------------

TABLE: employee_attendance

Field	Type	Null	Key	Default	Extra
emp_id	int	YES		NULL	
emp_name	varchar(50)	YES		NULL	
login_date	date	YES		NULL	
status	varchar(10)	YES		NULL	
                     

-------------------
Sample Output:
--------------
emp_id	emp_name	attendance_percent
4	David	100.00
*/
use fstest;
select emp_id, emp_name, round((count(*)/30)*1000,2)  as attendance_percent
from employee_attendance
where status = 'present'
group by emp_id, emp_name
order by attendance_percent desc
limit 1;
-------------------------------------------------------------------------------------------------------------------------------------------------------

/*
query 7: 

Task:
Write a query to identify students who have completed every course they 
enrolled in (i.e., have no active or dropped status).

Expected Output Columns:
student_id

---------------
Database Name: fstest
---------------

TABLE: course_enrollments

Field	Type	Null	Key	Default	Extra
enrollment_id	int	YES		NULL	
student_id	int	YES		NULL	
course_name	varchar(100)	YES		NULL	
enrollment_date	date	YES		NULL	
completion_percent	decimal(5,2)	YES		NULL	
status	varchar(15)	YES		NULL	
-------------------
Sample Output:
--------------
student_id
101
104
*/
use fstest;
select distinct student_id
from course_enrollments
where status='completed'
-------------------------------------------------------------------------------------------------------------------------------------------------------

/*
query 8: 

Task:
Write a SQL query to compute the average completion percentage for each course.

Expected Output Columns:

course_name
avg_progress

---------------
Database Name: fstest
---------------

TABLE: course_enrollments

Field	Type	Null	Key	Default	Extra
enrollment_id	int	YES		NULL	
student_id	int	YES		NULL	
course_name	varchar(100)	YES		NULL	
enrollment_date	date	YES		NULL	
completion_percent	decimal(5,2)	YES		NULL	
status	varchar(15)	YES		NULL	

-------------------

Sample Output:
--------------
course_name	avg_progress
Java Programming	45.00
Python Programming	41.67
Database Design	10.00
Web Development	68.33
*/
use fstest;
select course_name, round(avg(completion_percent),2) as avg_progress
from course_enrollments
group by course_name
-------------------------------------------------------------------------------------------------------------------------------------------------------

/*
query 9: 

Task:
Write a query to identify students who enrolled in more than 3 courses but 
have not completed any of them.

Expected Output Columns:
student_id
---------------
Database Name: fstest
---------------

TABLE: course_enrollments

Field	Type	Null	Key	Default	Extra
enrollment_id	int	YES		NULL	
student_id	int	YES		NULL	
course_name	varchar(100)	YES		NULL	
enrollment_date	date	YES		NULL	
completion_percent	decimal(5,2)	YES		NULL	
status	varchar(15)	YES		NULL	
-------------------

Sample Output:
--------------
student_id
105

*/
use fstest;
select student_id from course_enrollments
where status != 'completed'
group by student_id
having count(*)>3
