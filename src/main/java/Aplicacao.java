package main.java;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        OnlineStoreView onlineStoreView = new OnlineStoreView();
        List<Product> products = new ArrayList<>(); // new HashMap<>();

        products.add(new Product("caneta azul", BigDecimal.valueOf(11)));
        products.add(new Product("azul caneta", BigDecimal.valueOf(22)));
        products.add(new Product("abacaxi", BigDecimal.valueOf(33)));
        products.add(new Product("salmão", BigDecimal.valueOf(44)));
        products.add(new Product("remédio", BigDecimal.valueOf(55)));
        products.add(new Product("sapato", BigDecimal.valueOf(66)));

        OnlineStore onlineStore = new OnlineStore(client, products, onlineStoreView);
        onlineStore.run();
    }
}
