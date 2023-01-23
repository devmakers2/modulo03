package main.java.model;

public class Client {
    private ShoppingCart shoppingCart = new ShoppingCart();

    public void addToShoppingCart(Product product) {
        shoppingCart.add(product);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
