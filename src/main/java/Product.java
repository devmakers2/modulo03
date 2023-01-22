package main.java;

public class Product {
    // cada produto concreto terá um field static com a quantidade; bom na verdade talvez usando Map para produto nao precise

    private String name;

    Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
