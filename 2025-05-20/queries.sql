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

query 1:

List each customer along with the number of orders they’ve placed.

Sample Output:
==============

CustomerID      Name    OrderCount                                                                                      
1       Alice Johnson   4                                                                                               
2       Bob Smith       3                                                                                               
3       Charlie Davis   3                                                                                               
4       Diana Williams  2                                                                                               
5       Ethan Brown     1                                                                                               
6       Fiona Adams     1                                                                                               
7       George Clark    1                                                                                               
8       Henry Taylor    0                                                                                               
9       Irene Green     0        


*/

use fs;

-- Write your query below.
select c.CustomerID, c.Name, count(o.OrderID) as OrderCount
from Customers c
left join Orders o on c.CustomerID = o.CustomerID
group by c.CustomerID, c.Name
/*
=======================================================================================================================================================================
query 2: Find customers who have ordered the most expensive product.

Sample Output:
==============

CustomerID      Name    Email   Address PhoneNumber                                                                     
1       Alice Johnson   alice.johnson@example.com       123 Apple St, New York, NY      123-456-7890                    
7       George Clark    george.clark@example.com        213 Birch St, San Francisco, CA 555-666-7777                                                                              


*/
use fs;

-- Write your query below.
select c.CustomerID, c.Name, c.Email, c.Address, c.PhoneNumber
from Customers c
join Orders o on c.CustomerID = o.CustomerID
join OrderItems o1 on o.OrderID = o1.OrderID
where o1.UnitPrice = (
    select max(Price)
    from Products
)
/*
=====================================================================================================================================================================

query 3: Show each product along with the total quantity sold across all orders.

Sample Output:
==============
ProductID       Name    TotalQuantitySold                                                                               
101     Laptop  2                                                                                                       
102     Smartphone      2                                                                                               
103     Headphones      NULL                                                                                            
104     Keyboard        5                                                                                               
105     Mouse   8                                                                                                       
106     Monitor 2                                                                                                       
107     Printer 1                                                                                                       
108     Tablet  1                                                                                                       
109     External SSD    1                                                                                               
110     Smartwatch      2                                                                                

*/

use fs;

-- Write your query below.
select p.ProductID, p.Name, sum(o1.Quantity) as TotalQuantitySold
from Products p
left join OrderItems o1 on o1.ProductID = p.ProductID
group by p.ProductID
order by p.ProductID
/*
=====================================================================================================================================================================

query 4: List customers who have never placed an order.

Sample Output:
==============
CustomerID      Name    Email   Address PhoneNumber                                                                     
8       Henry Taylor    henry.taylor@example.com        456 Spruce St, Denver, CO       111-222-3333                    
9       Irene Green     irene.green@example.com 789 Willow St, Austin, TX       444-555-6666                                                                                                           

*/

use fs;

-- Write your query below.
select c.CustomerID, c.Name, c.Email, c.Address, c.PhoneNumber
from Customers c
left join Orders o on c.CustomerID = o.CustomerID
where o.OrderID IS null

/*
=====================================================================================================================================================================
query 5:
 Find orders where the total cost is higher than the total amount spent by at
 least one other

Sample Output:
==============

OrderID CustomerID      OrderDate       TotalCost       Status                                                          
1001    1       2024-10-10      1250.00 Shipped                                                                         
1002    2       2024-10-12      850.00  Processing                                                                      
1005    4       2024-10-13      450.00  Shipped                                                                         
1006    5       2024-10-12      550.00  Processing                                                                      
1008    7       2024-10-15      1200.00 Delivered                                                                       
1009    4       2024-10-14      300.00  Processing                                                                      
1010    3       2024-10-15      950.00  Shipped                                                                         
                                                                                                      
*/

use fs;

-- Write your query below.
select o.OrderID, o.CustomerID, o.OrderDate, o.TotalCost, o.Status
from Orders o
where o.TotalCost > any(
    select sum(o1.TotalCost)
    from Orders o1
    group by o1.CustomerID
)
