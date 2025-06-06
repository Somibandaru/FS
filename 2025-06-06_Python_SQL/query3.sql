/*
Write a SQL query to find the customer who made the highest single deposit, 
along with the deposit amount and date.

---------------
Database Name: fs
---------------

TABLE: transactions
-------------------
    id INT PRIMARY KEY,
    customer_id INT,
    amount DECIMAL(10,2),
    transaction_type VARCHAR(10),  -- e.g., 'deposit', 'withdraw'
    transaction_date TIMESTAMP



Sample Output:
--------------
customer_id     amount      transaction_date                                        
101             8000.00     2023-10-09 09:30:00 


*/
use fs;

select customer_id, amount, transaction_date
from transactions
order by amount desc
limit 1
