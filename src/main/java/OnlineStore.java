package main.java;

import java.io.IOException;
import java.util.*;

public class OnlineStore {
    Client client;
    OnlineStoreView onlineStoreView;
    List<Product> products;

    OnlineStore(Client client, List<Product> products, OnlineStoreView onlineStoreView) {
        this.client = client;
        this.products = products;
        this.onlineStoreView = onlineStoreView;
    }

    public void run() throws IOException {
        onlineStoreView.showWelcomeMessage();

        while (true) {
            onlineStoreView.showUnloggedClientMenu(products);  // talvez tenha que passar o cliente

            int userOption = Character.getNumericValue(onlineStoreView.getClientOption());  // ver se dá para melhorar getClientOption

            if (userOption > 0 && userOption <= products.size()) {
                int productIndex = userOption - 1;
                client.addToShoppingCart(products.get(productIndex));
                System.out.println("adicionou produto de indice" + productIndex);
            } else if (userOption == Character.getNumericValue('C')) {
                System.out.println("carrinho");
                onlineStoreView.showShoppingCart(client.getShoppingCart());
            } else if (userOption == Character.getNumericValue('S')) {
                this.onlineStoreView.showFarewellMessage();
                return;
            } else {
                onlineStoreView.showInvalidOptionMessage();
            }
        }
    }

//    private void login() {
//        Map.Entry<String, String> credentials = this.onlineStoreView.getClientCredentials();
//
//        getClientFromCredentials(credentials);
//    }

//    private Client getClientFromCredentials(Map.Entry<String, String> credentials) {
//        return clients.stream().
//                       filter(client -> client.cpf.equals(credentials.getKey())).
//                       filter(client -> client.password.equals(credentials.getValue())).
//                       findAny().
//                       orElse(null);
//    }


}
