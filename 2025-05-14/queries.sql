
/*Customers:
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

-- Find customers who have placed at least one order with a cost greater than the
-- average order cost for that customer:
-- Sample Output:
-- ==============

-- Name    OrderID TotalCost                                                                                               
-- Alice Johnson   1001    1250.00                                                                                         
-- Bob Smith       1002    850.00                                                                                          
-- Diana Williams  1005    450.00                                                                                          
-- Charlie Davis   1010    950.00                                                                                          
                                 
use fs;
select c.Name,o.OrderId,o.TotalCost
from Customers c
join Orders o on c.CustomerID = o.CustomerID
where o.TotalCost>(
     select avg(o2.TotalCost)
     from Orders o2
     where o2.CustomerID = o.CustomerID
     group by o2.CustomerID
     
     
)
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- Find the distinct names of customers who have placed at least one order that includes the
-- most expensive product in the catalog.

-- Sample Output:
-- ==============
-- Name                                                                                                                    
-- Alice Johnson                                                                                                           
-- George Clark    

use fs;
select distinct c.Name
from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderItems oi on oi.OrderID = o.OrderID
where oi.UnitPrice = (
select max(UnitPrice) from OrderItems
)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- List orders where the total cost is higher than the total cost of any other 
-- order made by the same customer:

-- Sample Output:
-- ==============
-- OrderID CustomerID      TotalCost                                                                                       
-- 1001    1       1250.00                                                                                                 
-- 1002    2       850.00                                                                                                  
-- 1005    4       450.00                                                                                                  
-- 1006    5       550.00                                                                                                  
-- 1007    6       250.00                                                                                                  
-- 1008    7       1200.00                                                                                                 
-- 1010    3       950.00    
use fs;
select o1.OrderID,o1.CustomerID,o1.TotalCost
from Orders o1
where o1.TotalCost> all(
select o2.TotalCost 
from Orders o2
where o1.CustomerID = o2.CustomerID and o1.OrderID!=o2.OrderID
)
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Find the customers who placed orders that include more items than any other 
-- order they’ve placed:
-- Sample Output:
-- ==============

-- OrderID Name    ItemCount                                                                                               
-- 1010    Charlie Davis   2                                                                                               
-- 1005    Diana Williams  2                                                                                               
-- 1006    Ethan Brown     2                                                                                               
-- 1007    Fiona Adams     1                                                                                               
-- 1008    George Clark    2                                                                                               

use fs;
SELECT o.OrderID, c.Name, SUM(oi.Quantity) AS ItemCount
FROM Orders o
JOIN Customers c ON o.CustomerID = c.CustomerID
JOIN OrderItems oi ON o.OrderID = oi.OrderID
GROUP BY o.OrderID, c.Name, o.CustomerID
HAVING SUM(oi.Quantity) > ALL (
    SELECT SUM(oi2.Quantity)
    FROM Orders o2
    JOIN OrderItems oi2 ON o2.OrderID = oi2.OrderID
    WHERE o2.CustomerID = o.CustomerID AND o2.OrderID != o.OrderID
    GROUP BY o2.OrderID
);
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- FFind the names of customers whose total spending is greater than the average 
-- total spending of all customers.
-- Sample Output:
-- ==============

-- Name                                                                                                                    
-- Alice Johnson                                                                                                           
-- Bob Smith                                                                                                               
-- Charlie Davis                                                                                                           
-- George Clark                                                                                                            

use fs;
select c.Name
from Customers c
join Orders o on o.CustomerID = c.CustomerID
group by o.CustomerID,c.Name
having sum(o.TotalCost)>(
select avg(total)
from(
select sum(TotalCost) as total
from Orders
group by CustomerID
) as totaaal
)
