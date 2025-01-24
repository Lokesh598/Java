package org.java.learning.hackerrank.paypal;


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class InventoryClearanceSale {
}
interface ProductImpl {
    String getProductId();
    int getSalesVelocity();
    int getStockLevel();

}


class Product implements ProductImpl {
    private String productId;
    private int salesVelocity;
    private int stockLevel;

    // Constructor to initialize product properties
    public Product(String productId, int salesVelocity, int stockLevel) {
        this.productId = productId;
        this.salesVelocity = salesVelocity;
        this.stockLevel = stockLevel;
    }

    // Getters for the product properties
    public String getProductId() {
        return productId;
    }

    public int getSalesVelocity() {
        return salesVelocity;
    }

    public int getStockLevel() {
        return stockLevel;
    }
}

class InventoryClearance {
    public List<String> identifyClearanceItems(List<Product> products) {
        List<String> clearanceItems = new ArrayList<>();

        // Loop through each product and check eligibility for clearance
        for (Product product : products) {
            // A product is eligible if stock level >= 10 * sales velocity
            if (product.getStockLevel() >= 10 * product.getSalesVelocity()) {
                clearanceItems.add(product.getProductId());
            }
        }

        return clearanceItems;
    }
}

class TestInventoryClearance {
    public static void main(String[] args) {
    ProductImpl product1 = new Product("P1", 2, 20);
    ProductImpl product2 = new Product("P2", 5, 8);
    ProductImpl product3 = new Product("P3", 3, 10);

//    List&lt;Product&gt;
    List<Product> products = Arrays.asList((Product) product1, (Product) product2, (Product) product3);


    InventoryClearance clearance = new InventoryClearance();

//    List&lt;String&gt;
    List<String> clearanceItems = clearance.identifyClearanceItems(products);


//    System.out.println(&quot;Eligible for clearance: &quot; + clearanceItems);
    System.out.println("Eligible for clearance: " + clearanceItems);
}
}



