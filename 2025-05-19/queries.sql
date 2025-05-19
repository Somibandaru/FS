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


*/
-- query 1:
-- Find customers who have placed orders with a total cost greater than the average
-- total cost of all orders

-- Sample Output:
-- ==============

-- Name                                                                                                                    
-- Name    Email                                                                                                           
-- Alice Johnson   alice.johnson@example.com                                                                               
-- Bob Smith       bob.smith@example.com                                                                                   
-- Charlie Davis   charlie.davis@example.com                                                                               
-- Diana Williams  diana.williams@example.com                                                                              
-- Ethan Brown     ethan.brown@example.com                                                                                 
-- George Clark    george.clark@example.com                                                                                                          
                                                                                            


use fs;

-- Write your query below.
select c.Name, c.Email
from Customers c
join Orders o on c.CustomerId = o.CustomerId
group by c.CustomerID, c.Name
having sum(o.TotalCost) >(
    select avg(o1.TotalCost)
    from Orders o1
)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
-- query 2:Retrieve product names that have been ordered more than the average quantity of
-- all products

-- Sample Output:
-- ==============

-- Name                                                                                                                    
-- Laptop                                                                                                                  
-- Smartphone                                                                                                              
-- Keyboard                                                                                                                
-- Mouse                                                                                                                   
-- Monitor                                                                                                                 
-- Smartwatch 
select p.Name
from Products p
join OrderItems o on o.ProductID = p.ProductID
group by p.ProductID
having count(*) >all
(
    select avg(Quantity)
    from OrderItems
    group by ProductID
)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
--query 3:
-- Find customers who ordered the most expensive product
-- Sample Output:
-- ==============

-- Name    Email                                                                                                           
-- Alice Johnson   alice.johnson@example.com                                                                               
-- George Clark    george.clark@example.com                                                                                                           

select c.Name, c.Email
from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderItems o1 on o.OrderID = o1.OrderID
where o1.UnitPrice=(
    select max(UnitPrice)
    from OrderItems
)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
--query 4:
-- List order IDs where all items in the order are priced above the average product
-- price

-- Sample Output:
-- ==============

-- OrderID                                                                                                                 
-- 1002 
select o1.OrderID
from OrderItems o1
join Products p on o1.ProductID = p.ProductId
group by o1.OrderID
having MIN(p.Price)>(
    select avg(Price)
    from Products
)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------
--
-- query 5:
-- Find the names of products that are only ordered by customers who live in a
-- specific city (e.g., 'New York')

-- Sample Output:
-- ==============

-- Name                                                                                                                    
-- Keyboard 
select distinct p.Name
from Products p
join OrderItems o on p.ProductID = o.ProductID
join Orders o1 on o.OrderID = o1.OrderID
join Customers c on o1.CustomerID = c.CustomerID
where c.Address Like '%New York%'
and p.ProductID not in(
    select o2.ProductID
from OrderItems o2 
join Orders o3 on o2.OrderID = o3.OrderID
join Customers c1 on o3.CustomerID = c1.CustomerID
where c1.Address not Like '%New York%'
)
