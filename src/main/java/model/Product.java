package main.java.model;

import java.math.BigDecimal;

public class Product {
    // cada produto concreto terá um field static com a quantidade; bom na verdade talvez usando Map para produto nao precise

    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
