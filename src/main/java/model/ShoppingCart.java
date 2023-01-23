package main.java.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {  //singleton
    private Map<Product, Integer> products = new HashMap<>();
    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total = total.add(entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
        }

        return total;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void empty() {
        products.clear();
    }

    public void add(Product product) {
        int previousQuantity = products.getOrDefault(product, 0);
        products.put(product, previousQuantity + 1);
    }
}
