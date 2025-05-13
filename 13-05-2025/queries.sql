/*SCHEMA
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


*/
-------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Find customers who have spent more than the average order total

-- Sample Output:
-- ==============

-- Name    Email                                                                                                           
-- Alice Johnson   alice.johnson@example.com                                                                               
-- Bob Smith       bob.smith@example.com                                                                                   
-- Diana Williams  diana.williams@example.com                                                                              
-- Ethan Brown     ethan.brown@example.com                                                                                 
-- George Clark    george.clark@example.com                                                                                
-- Charlie Davis   charlie.davis@example.com                                                                                               
use fs;
select c.Name,c.Email
from Customers c
join Orders o on c.CustomerID = o.CustomerID
where o.TotalCost >(
select AVG(TotalCost)
    from Orders
   
)
-------------------------------------------------------------------------------------------------------------------------------------------------------------
-- List product names that were included in the most expensive order

-- Sample Output:
-- ==============

-- Name                                                                                                                    
-- Laptop                                                                                                                  
-- Keyboard                                                                                               
use fs;

select distinct p.Name
from Orders o
join OrderItems oi on o.OrderID = oi.OrderID
join Products p on oi.productID = p.productID
where o.TotalCost = (
    select max(TotalCost)
    from Orders
);
 --------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Show customers who placed more orders than the average number of orders per 
-- customer

-- Sample Output:
-- ==============

-- CustomerID      Name    NumOrders                                                                                       
-- 1       Alice Johnson   4                                                                                               
-- 2       Bob Smith       3                                                                                               
-- 3       Charlie Davis   3                                                                                                 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
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
---------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Get product names that were never ordered

-- Sample Output:
-- ==============
-- Name                                                                                                                    
-- Headphones                                                                                             

select Name
from Products
where ProductID not in(
  select distinct ProductID 
  from OrderItems
)
