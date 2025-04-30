-- Query1
-- Note:Create a Worksheet with the name micropartition

-- Write a SQL query to calculate the sum of sales (as total_sales) for all 
-- 'Electronics' products sold in the 'North' region during the year 2021.

-- Sample Output: 
-- TOTAL_SALES
-- 12762668

-- 
-- Step 1: Create Database and Schema
CREATE OR REPLACE DATABASE micro_partition_demo;
USE DATABASE micro_partition_demo;

CREATE OR REPLACE SCHEMA demo_schema;
USE SCHEMA demo_schema;

-- Step 2: Create sales_data Table
CREATE OR REPLACE TABLE sales_data (
  id BIGINT,
  sale_date DATE,
  region STRING,
  product_category STRING,
  sales_amount FLOAT
);

-- Step 3: Insert 5 Million Rows of Synthetic Data
INSERT INTO sales_data
SELECT
  SEQ4() AS id,
  DATEADD(DAY, UNIFORM(0, 3650, RANDOM()), DATE '2015-01-01') AS sale_date,
  CASE UNIFORM(1, 5, RANDOM())
    WHEN 1 THEN 'North'
    WHEN 2 THEN 'South'
    WHEN 3 THEN 'East'
    WHEN 4 THEN 'West'
    ELSE 'Central'
  END AS region,
  CASE UNIFORM(1, 4, RANDOM())
    WHEN 1 THEN 'Electronics'
    WHEN 2 THEN 'Clothing'
    WHEN 3 THEN 'Groceries'
    ELSE 'Home Decor'
  END AS product_category,
  UNIFORM(10, 1000, RANDOM())::FLOAT AS sales_amount
FROM TABLE(GENERATOR(ROWCOUNT => 5000000));

ALTER TABLE sales_data CLUSTER BY (sale_date);

-- Step 4: View Micro-Partition Info
SELECT SYSTEM$CLUSTERING_INFORMATION('sales_data');

-- Sample Queries
-- Query 1: Full table scan
SELECT COUNT(*) FROM sales_data;

-- Query 2: Filter by date
SELECT * FROM sales_data
WHERE sale_date BETWEEN '2020-01-01' AND '2020-12-31';

-- Query 3: Filter by region
SELECT region, COUNT(*)
FROM sales_data
WHERE region = 'North'
GROUP BY region;

-- Exercise 1: Records in 2019
SELECT COUNT(*) FROM sales_data
WHERE sale_date BETWEEN '2019-01-01' AND '2019-12-31';

-- Exercise 2: Add Clustering Key and Re-Test
-- ALTER TABLE sales_data CLUSTER BY (sale_date);
-- After adding, re-run:
SELECT SYSTEM$CLUSTERING_INFORMATION('sales_data');

-- Exercise 3: Storage Metrics
SELECT *
FROM INFORMATION_SCHEMA.TABLE_STORAGE_METRICS
WHERE TABLE_NAME = 'SALES_DATA';

-- BONUS: Clustering Depth
SELECT SYSTEM$CLUSTERING_DEPTH('sales_data');

-- Final Task: Query for total sales of Electronics in North during 2021
SELECT SUM(sales_amount) AS TOTAL_SALES
FROM sales_data
WHERE product_category = 'Electronics'
  AND region = 'North'
  AND sale_date BETWEEN '2021-01-01' AND '2021-12-31';









-- Query 2
-- Note:Work on same worksheet which is created for micropartition-query1. The 
-- worksheet name is should be micropartition. Don't create new worksheet

-- Write a SQL query to count the number of sales records (sales_count) for 
-- each region where sales occurred in January 2020. Your results should be
-- grouped by region and sorted alphabetically by region.

-- Sample Output:
-- REGION	SALES_COUNT
-- Central	8562
-- East	8516
-- North	8438
-- South	8567
-- West	8534
SELECT 
  region, 
  COUNT(*) AS sales_count
FROM sales_data
WHERE sale_date BETWEEN '2020-01-01' AND '2020-01-31'
GROUP BY region
ORDER BY region;


