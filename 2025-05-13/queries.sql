/*                                                                                    
Customers:
==========
Field   Type    Null    Key     Default Extra                                                                           
CustomerID      int     NO      PRI     NULL                                                                            
Name    varchar(255)    YES             NULL                                                                            
Email   varchar(255)    YES             NULL                                                                            
Address varchar(255)    YES             NULL                                                                            
PhoneNumber     varchar(20)     YES             NULL                                                                    

Orders:
=======
Field   Type    Null    Key     Default Extra                                                                           
OrderID int     NO      PRI     NULL                                                                                    
CustomerID      int     YES     MUL     NULL                                                                            
OrderDate       date    YES             NULL                                                                            
TotalCost       decimal(10,2)   YES             NULL                                                                    
Status  varchar(20)     YES             NULL                                                                            

OrderItems:
============
Field   Type    Null    Key     Default Extra                                                                           
OrderItemID     int     NO      PRI     NULL                                                                            
OrderID int     YES     MUL     NULL                                                                                    
ProductID       int     YES     MUL     NULL                                                                            
Quantity        int     YES             NULL                                                                            
UnitPrice       decimal(10,2)   YES             NULL                                                                    

Products:
=========
Field   Type    Null    Key     Default Extra                                                                           
ProductID       int     NO      PRI     NULL                                                                            
Name    varchar(255)    YES             NULL                                                                            
Description     varchar(255)    YES             NULL                                                                    
Price   decimal(10,2)   YES             NULL  

query1 :Find customers who have spent more than the average order total

Sample Output:
==============

Name    Email                                                                                                           
Alice Johnson   alice.johnson@example.com                                                                               
Bob Smith       bob.smith@example.com                                                                                   
Diana Williams  diana.williams@example.com                                                                              
Ethan Brown     ethan.brown@example.com                                                                                 
George Clark    george.clark@example.com                                                                                
Charlie Davis   charlie.davis@example.com   
*/

use fs;

-- Write your query below.
select c.Name, c.Email
from Customers c
join Orders o 
on o.CustomerID = c.CustomerID
where o.TotalCost> (
  select avg(TotalCost)
  from Orders
  )


-- query2:List product names that were included in the most expensive order

-- Sample Output:
-- ==============

-- Name                                                                                                                    
-- Laptop                                                                                                                  
-- Keyboard  
select p.Name
from Orders o
join OrderItems o1 on o.OrderID = o1.OrderID
join Products p on p.ProductID = o1.ProductID
where o.TotalCost = (
select MAX(TotalCost)
from Orders
)

-- query 3:Show customers who placed more orders than the average number of orders per 
-- customer

-- Sample Output:
-- ==============

-- CustomerID      Name    NumOrders                                                                                       
-- 1       Alice Johnson   4                                                                                               
-- 2       Bob Smith       3                                                                                               
-- 3       Charlie Davis   3   
select c.CustomerID, c.Name, count(*) as NumOrders
from Customers c
join Orders o on o.CustomerID = c.CustomerID
group by c.CustomerId
having count(*)>(
    select avg(orderCount) from(
        select count(*) as orderCount
        from Orders
        group by CustomerID)
    as CustomerOrders
    )

-- query 4:
-- Find the name of the customer who spent the most in total

-- Sample Output:
-- ==============

-- Name    TotalSpent                                                                                                      
-- Alice Johnson   1625.00                                                                                                 
-- George Clark    1200.00                                                                                                 
-- Bob Smith       1050.00                                                                                                 
-- Charlie Davis   1050.00                                                                                                 
-- Diana Williams  750.00                                                                                                  
-- Ethan Brown     550.00                                                                                                  
-- Fiona Adams     250.00    
select c.Name,  sum(o.TotalCost) as TotalSpent
from Customers c
join Orders o on c.CustomerID = o.CustomerID
group by c.Name
order by TotalSpent DESC;


-- query 5: Get product names that were never ordered

-- Sample Output:
-- ==============
-- Name                                                                                                                    
-- Headphones                                                                                             
select p.Name as Name
from Products p 
left join OrderItems o on p.ProductID = o.ProductID
where o.OrderID is NULL
