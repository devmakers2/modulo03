package main.java;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OnlineStoreView {
    void showProducts(List<Product> products) {
        System.out.println("Esses são nossos produtos! Escolha um para adicionar ao seu carrinho!");

        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + 1 + " - " + products.get(i));
        }
    }

//    void showProducts(Map<Product, Integer> products) {
//        System.out.println("Esses são nossos produtos! Escolha um para adicionar ao seu carrinho!");
//
//        int i0 = 1;
//
//        for (Product product : products.keySet()) {  // poderia ser o entrySet com as quantidades?
//            System.out.println(i0 + " - " + product);
//            i0++;
//        }
//    }

    void showInitialMenu() {
        System.out.println("N - cadastrar novo cliente");
        System.out.println("C - ver meu carrinho");
        System.out.println("L - fazer login");
        System.out.println("S - sair");
    }

    int getClientOption() throws IOException {
        int option = System.in.read();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        return option;
    }

    public void showWelcomeMessage() {
        System.out.println("Olá! É um prazer lhe receber na Loja Virtual!");
    }

    public void showInvalidOptionMessage() {
        System.out.println("Opção inválida. Por favor, tente novamente.");
    }

    public void showUnloggedClientMenu(List<Product> products) {
        System.out.println();
        showProducts(products);
        System.out.println();
        System.out.println("ou escolha uma opção abaixo:");
        showInitialMenu();
    }

    public void showFarewellMessage() {
        System.out.println("Muito obrigado por visitar nossa Loja Online! Até breve!");
    }

    public void showShoppingCart(Map<Product, Integer> shoppingCart) {
        System.out.println();
        System.out.println("Estes são os produtos no seu carrinho:");
        System.out.println("  produto   -   preço   -   quantidade");
        System.out.println("--------------------------------------");

        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            total = total.add(entry.getKey().getPrice());

            System.out.format("%11s - R$ %,.2f  x %d", entry.getKey().getName(), entry.getKey().getPrice(), entry.getValue());
            System.out.println();
        }
        System.out.println();
        System.out.format("total = R$ %,.2f", total);
        System.out.println();
    }

    public void showShoppingCartOptions() {
        System.out.println();
        System.out.println("Por favor, escolha uma opção:");
        System.out.println("F - finalizar compra");
        System.out.println("V - voltar ao menu anterior");
    }
}
