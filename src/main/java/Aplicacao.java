package main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        OnlineStoreView onlineStoreView = new OnlineStoreView();
        List<Product> products = new ArrayList<>(); // new HashMap<>();

        products.add(new Product("caneta azul"));
        products.add(new Product("azul caneta"));
        products.add(new Product("abacaxi"));
        products.add(new Product("salmão"));
        products.add(new Product("remédio"));
        products.add(new Product("sapato"));

        OnlineStore onlineStore = new OnlineStore(client, products, onlineStoreView);
        onlineStore.run();
    }
}
