package main.java.model;

public enum PaymentOption {
    BOLETO("boleto", false, 1),
    CARD_IN_INSTALLMENTS("cartão parcelado", true, 3),
    CARD_IN_ONE_INSTALLMENT("cartão à vista", false, 1),
    PAYPAL("PayPal", false, 1);

    private final String descriptionInPortuguese;
    private final boolean installmentBuyingAllowed;
    private final int maximumNumberOfInstallmentsAllowed;

    PaymentOption(String descriptionInPortuguese, boolean installmentBuyingAllowed, int maximumNumberOfInstallmentsAllowed) {
        this.descriptionInPortuguese = descriptionInPortuguese;
        this.installmentBuyingAllowed = installmentBuyingAllowed;
        this.maximumNumberOfInstallmentsAllowed = maximumNumberOfInstallmentsAllowed;
    }

    public String getDescriptionInPortuguese() {
        return descriptionInPortuguese;
    }

    public boolean isInstallmentBuyingAllowed() {
        return installmentBuyingAllowed;
    }

    public int getMaximumNumberOfInstallmentsAllowed() {
        return maximumNumberOfInstallmentsAllowed;
    }
}
