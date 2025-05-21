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
================================================================================================================================================================
query 1:
List customers who have made at least one order with a total cost higher 
than $1000

Sample Output:
==============
Name    Email                                                                                                           
Alice Johnson   alice.johnson@example.com                                                                               
George Clark    george.clark@example.com 
                                                                                      
*/

use fs;

-- Write your query below.
select c.Name, c.Email
from Customers c
join Orders o on o.CustomerID = c.CustomerID
where o.TotalCost > 1000
-- ================================================================================================================================================================
-- query 2:
-- Find all customers who have ordered a "Laptop".

-- Sample Output:
-- ==============
-- Name                                                                                                                    
-- Alice Johnson                                                                                                           
-- George Clark
select c.Name
from Customers c
join Orders o on o.CustomerID = c.CustomerID
join OrderItems o1 on o1.OrderID = o.OrderID
join Products p on p.ProductID = o1.ProductID
where p.Name = 'Laptop'
-- ================================================================================================================================================================
-- query 3:
-- List customers who have never placed an order.

-- Sample Output:
-- ==============
-- Name                                                                                                                    
-- Henry Taylor                                                                                                            
-- Irene Green 
select c.Name
from Customers c
left join Orders o on o.CustomerID = c.CustomerID
where o.OrderID is null
