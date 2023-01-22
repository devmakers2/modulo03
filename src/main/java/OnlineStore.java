package main.java;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
                accessShoppingCart(client.getShoppingCart2());
            } else if (userOption == Character.getNumericValue('S')) {
                this.onlineStoreView.showFarewellMessage();
                return;
            } else {
                onlineStoreView.showInvalidOptionMessage();
            }
        }
    }

    private void accessShoppingCart(ShoppingCart shoppingCart) throws IOException {
        onlineStoreView.showShoppingCart2(shoppingCart);

        while (true) {
            onlineStoreView.showShoppingCartOptions();

            int option = onlineStoreView.getClientOption();
            if (option == 'F' || option == 'f') {
                finalizePurchase(shoppingCart);
                return;
            } else if (option == 'V' || option == 'v') {
                return;
            } else {
                onlineStoreView.showInvalidOptionMessage();
            }
        }
    }

    private void finalizePurchase(ShoppingCart shoppingCart) {
        boolean successfullyFinalized = false;
        while (!successfullyFinalized) {
            onlineStoreView.showPaymentOptions();

            int paymentOptionIndex = onlineStoreView.getIntegerClientOption() - 1;
            if (paymentOptionIndex < 0 || paymentOptionIndex >= PaymentOption.values().length) {
                onlineStoreView.showInvalidOptionMessage();
            } else {
                PaymentOption paymentOption = PaymentOption.values()[paymentOptionIndex];
                if (paymentOption.isInstallmentBuyingAllowed()) {
                    BigDecimal total = shoppingCart.getTotal();
                    successfullyFinalized = manageInstallmentsPurchase(paymentOption, total);
                } else {
                    successfullyFinalized = true;
                }
            }
        }

        onlineStoreView.showPurchaseCompletedMessage();

        shoppingCart.empty(); // voltar ao menu inicial com novo carrinho
    }

    private boolean manageInstallmentsPurchase(PaymentOption paymentOption, BigDecimal total) {
        int maximumNumberOfInstallmentsAllowed = paymentOption.getMaximumNumberOfInstallmentsAllowed();
        onlineStoreView.showInstallmentBuyingOptions(maximumNumberOfInstallmentsAllowed);

        int numberOfInstallments = onlineStoreView.getIntegerClientOption();
        if (numberOfInstallments < 0 || numberOfInstallments > maximumNumberOfInstallmentsAllowed) {
            onlineStoreView.showInvalidOptionMessage();
            return false;
        }

        BigDecimal installmentValue = total.divide(BigDecimal.valueOf(numberOfInstallments), RoundingMode.HALF_EVEN);
        onlineStoreView.showEachInstallmentValueMessage(installmentValue);
        return true;
    }
}
