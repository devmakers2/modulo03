package main.java;

import java.io.IOException;
import java.util.List;

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
                onlineStoreView.showProductAddedToShoppingCartMessage();
            } else if (userOption == Character.getNumericValue('C')) {
                onlineStoreView.showShoppingCart(client.getShoppingCart());
                onlineStoreView.showShoppingCartOptions();

                int option = onlineStoreView.getClientOption();  // ver se maiusculo ou minusculo serve
                if (option == 'F') {
                    onlineStoreView.showPaymentOptions();
                    int paymentOptionIndex = onlineStoreView.getIntegerClientOption() - 1;

                    PaymentOption paymentOption = PaymentOption.values()[paymentOptionIndex];

                    if (paymentOption.isInstallmentBuyingAllowed()) {
                        int maximumNumberOfInstallmentsAllowed = paymentOption.getMaximumNumberOfInstallmentsAllowed();
                        onlineStoreView.showInstallmentBuyingOptions(maximumNumberOfInstallmentsAllowed);

                        int numberOfInstallments = onlineStoreView.getIntegerClientOption();

                        if (numberOfInstallments < 0 || numberOfInstallments > maximumNumberOfInstallmentsAllowed) {
                            onlineStoreView.showInvalidOptionMessage();
                        }

//                        onlineStoreView.showEachInstallmentValueMessage();
                    }

//                    switch (paymentOption) {
//                        case PaymentOption.BOLETO:
//                            break;
//                        case PaymentOption.CARTÃO_PARCELADO:
//                            break;
//                        case PaymentOption.CARTÃO_À_VISTA:
//                            break;
//                        case :
//                            break;
//                        default:
//                            onlineStoreView.showInvalidOptionMessage();
//                    }



                } else if (option == 'V') {
                    break;
                } else {
                    onlineStoreView.showInvalidOptionMessage();
                }

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
