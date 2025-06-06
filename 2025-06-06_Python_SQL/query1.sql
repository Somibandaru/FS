/*
Write a SQL query to retrieve the latest 5 transactions (by date) made 
by a specific customer.

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
id      customer_id     amount      transaction_type    transaction_date        
10      101             8000.00     deposit             2023-10-09 09:30:00                             
8       101             3000.00     deposit             2023-10-07 13:15:00                             
7       101             6000.00     deposit             2023-10-06 16:00:00                             
6       101             4000.00     deposit             2023-10-05 14:30:00                             
5       101             7000.00     deposit             2023-10-04 12:00:00


*/

use fs;

select * from transactions
where customer_id=101 and transaction_type='deposit'
order by transaction_date DESC
limit 5
