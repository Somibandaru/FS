// You are building an E-Commerce Product Insights Engine for a marketplace like 
// Amazon or Flipkart. The platform stores information about various products, 
// their pricing history, and user ratings.

// Your job is to:

//     1. Accept data for multiple products.
    
//     2. Each product has:
//         🎯 Multiple price entries (date + price)
//         🎯 Multiple ratings (user + stars out of 5)
        
//     3. Calculate:
//         🎯 Average price of the product
//         🎯 Price volatility score: Standard deviation of prices
//         🎯 Average rating

//     4. Classify products into Insight Tiers:
//         🟢 Stable & Loved: Volatility < 100 and Rating ≥ 4.0
//         🟡 Unstable but Popular: Volatility ≥ 100 and Rating ≥ 4.0
//         🔴 Unstable & Poorly Rated: Volatility ≥ 100 and Rating < 4.0
//         ⚪ Stable but Low-Rated: Volatility < 100 and Rating < 4.0
        
// Sample Input:
// -------------
// 2               // Number of products
// EchoDot         // ProductName
// 3               // Number of price entries
// 2024-06-01 3499 // priceDate priceAmount
// 2024-06-10 3299
// 2024-06-15 3599
// 2               // Number of ratings
// Alice 5         // userName stars
// Bob 4
// OldTV           // ProductName
// 4               // Number of price entries
// 2024-05-01 9999 // priceDate priceAmount
// 2024-05-10 10999
// 2024-05-15 11999
// 2024-05-20 8999
// 3               // Number of ratings
// Charlie 2       // userName stars
// Diana 3
// Eve 1

// Sample Output:
// --------------
// Product: EchoDot, AvgPrice: 3465.7, Volatility: 124.7, AvgRating: 4.5, Tier: Unstable but Popular
// Product: OldTV, AvgPrice: 10499.0, Volatility: 1118.0, AvgRating: 2.0, Tier: Unstable & Poorly Rated

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int m = Integer.parseInt(sc.nextLine());

            List<PriceEntry> prices = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                String[] parts = sc.nextLine().split(" ");
                prices.add(new PriceEntry(parts[0], Double.parseDouble(parts[1])));
            }

            int k = Integer.parseInt(sc.nextLine());
            List<Rating> ratings = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                String[] parts = sc.nextLine().split(" ");
                ratings.add(new Rating(parts[0], Integer.parseInt(parts[1])));
            }

            products.add(new Product(name, prices, ratings));
        }

        InsightEngine engine = new InsightEngineImpl();
        System.out.println("=== Product Insights Summary ===");
        for (Product p : products) {
            ProductInsight insight = engine.analyze(p);
            System.out.println(insight);
        }
    }
}

// TODO: Complete this POJO
class PriceEntry {
    // String date; double amount
}

// TODO: Complete this POJO
class Rating {
    // String userName; int stars
}

// TODO: Complete this POJO
class Product {
    // String name; List<PriceEntry>; List<Rating>
}

// TODO: Complete this POJO
class ProductInsight {
    // Product; double avgPrice; double volatility; double avgRating; String insightTier
    // Override toString() for output
}

interface InsightEngine {
    ProductInsight analyze(Product p);
}

// TODO: Implement InsightEngineImpl using Math.pow and Math.sqrt for std deviation
class InsightEngineImpl implements InsightEngine {
    public ProductInsight analyze(Product p) {
        // Logic:
        // - Calculate avgPrice
        // - Calculate standard deviation
        // - Calculate avgRating
        // - Tier assignment
        return null; // TODO
    }
}


