/*
query 1: List Top 2 Customers by Total Orders (Amount-wise)
Task:
Write a SQL query to find the top 2 customers who have spent the most 
(total of total_amount), regardless of order status.
Expected Output:
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
1005	6050.00
*/
use fstest;
select customer_id, sum(total_amount) as total_spent
from orders
group by customer_id
order by total_spent desc
limit 2;
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
query 2: Number of Orders Per Status Per Customer
Task:
Write a query to count how many orders each customer has placed under each 
status (delivered, cancelled, pending).
Expected Output:
customer_id
status
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
customer_id	status	order_count
1001	delivered	3
1002	delivered	2
1002	pending	1
1003	cancelled	1
1003	delivered	1
1004	cancelled	1
1004	delivered	1
1005	delivered	1
1005	pending	1
*/
use fstest;
select customer_id, status, count(*) as order_count
from orders
group by customer_id, status
order by customer_id
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*query 3: Monthly Revenue from Delivered Orders
Task:
Write a SQL query to calculate monthly total revenue from delivered orders.
Expected Output:
month (e.g., '2023-09')
revenue
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
month	revenue
2023-09	21081.24
*/
use fstest;
select date_format(order_date, '%Y-%m') as month, sum(total_amount) as revenue
from orders
where status = 'delivered'
group by month
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
query 4: 
Identify Employees with Perfect Attendance
Task:
Write a SQL query to find employees who were present on all recorded days
(i.e., no absent or leave entries).
Expected Output:
emp_id
emp_name
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
emp_id	emp_name
2	Bob
4	David
*/
use fstest;
select emp_id, emp_name
from employee_attendance
group by emp_id, emp_name
having count(*) = sum(case when status = 'present' then 1 else 0 end); 
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
query 5: 
Days Each Employee Was Absent in October 2023
Task:
Write a query to count the number of absent days for each employee only
in October 2023.
Expected Output:
emp_id
emp_name
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
emp_id	emp_name	absent_days
1	Alice	1
3	Charlie	3
*/
use fstest;
select emp_id, emp_name, count(*) as absent_days
from employee_attendance
where status = 'absent'
group by emp_id, emp_name
