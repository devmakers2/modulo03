package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
    Map<Product, Integer> products = new HashMap<>();

    private  void addProduct(Product product, int quantity) {  // talvez fazer quantiy ser sempre 1?
        int previousQuantity = products.getOrDefault(product, 0);
        products.put(product, quantity + previousQuantity);
    }
}
