package main.java;

import main.java.model.Client;
import main.java.model.OnlineStore;
import main.java.model.Product;
import main.java.view.OnlineStoreView;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        OnlineStoreView onlineStoreView = new OnlineStoreView();
        List<Product> products = new ArrayList<>();

        products.add(new Product("caneta azul", BigDecimal.valueOf(0.01)));
        products.add(new Product("azul caneta", BigDecimal.valueOf(0.2)));
        products.add(new Product("abacaxi", BigDecimal.valueOf(3)));
        products.add(new Product("salmão", BigDecimal.valueOf(40)));
        products.add(new Product("remédio", BigDecimal.valueOf(500)));
        products.add(new Product("sapato", BigDecimal.valueOf(6000)));

        OnlineStore onlineStore = new OnlineStore(client, products, onlineStoreView);
        onlineStore.run();
    }
}
