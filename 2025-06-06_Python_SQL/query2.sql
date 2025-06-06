/*
Write a SQL query to calculate the total amount of deposits made by each customer.


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
customer_id     total_deposit                                                   
101             35500.00                                                                
102             1000.00 


*/

use fs;

select customer_id, sum(amount) as total_deposit
from transactions
where transaction_type='deposit'
group by customer_id
