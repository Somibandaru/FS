-- <!--
-- Write an SQL query to retrieve the id, region, and amount of the first 5 sales
-- records in the "big_sales_clustered" table from the "South" region that 
-- occurred in the year 2023. Ensure the results are ordered by sale_date in 
-- ascending order.
-- Sample Output:

-- ID	REGION	AMOUNT
-- 778686	South	879
-- 883181	South	424
-- 969451	South	506
-- 342531	South	108
-- 342401	South	719

-- -->
SELECT id, region, amount
FROM big_sales_clustered
WHERE region = 'South'
  AND sale_date BETWEEN '2023-01-01' AND '2023-12-31'
ORDER BY sale_date ASC
LIMIT 5;
