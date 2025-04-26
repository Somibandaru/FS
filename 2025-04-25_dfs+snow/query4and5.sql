
--  Query 4: Flatten Interests into Individual Rows:  
-- > Each customer's `profile` JSON contains an array of `interests`. Write a query to return one row per interest, along with the customer's `name`. Use the `FLATTEN` function to handle the array.

-- Sample Output::

-- NAME	INTEREST
-- Alice	"books"
-- Alice	"music"
-- Bob	"gaming"
-- Bob	"travel"

SELECT
  name,
  interest.value AS interest
FROM customer_profiles,
LATERAL FLATTEN(input => profile:"interests") AS interest
WHERE profile:"interests" IS NOT NULL;



--  Query 5: Count How Many Customers Have Each Interest:  
-- > Using the `profile:interests` array, count how many customers have each 
-- unique interest. Return two columns: `interest` and `total_customers`.
-- Flatten the interests array and group the results by interest.

-- Sample Output::

-- INTEREST	TOTAL_CUSTOMERS
-- books        	1
-- music       	1
-- gaming      	1
-- travel      	1



SELECT
  interest.value::STRING AS interest,
  COUNT(*) AS total_customers
FROM customer_profiles,
LATERAL FLATTEN(input => profile:"interests") AS interest
GROUP BY interest.value::STRING
ORDER BY total_customers DESC;

