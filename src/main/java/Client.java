package main.java;

import java.util.HashMap;
import java.util.Map;

public class Client {
    Map<Product, Integer> shoppingCart = new HashMap<>();

    public void addToShoppingCart(Product product) {
        int previousQuantity = shoppingCart.getOrDefault(product, 0);
        shoppingCart.put(product, previousQuantity + 1);
    }

    public Map<Product, Integer> getShoppingCart() {
        return shoppingCart;
    }
}
