package main.java;

public enum PaymentOption {
    BOLETO(false, 1),
    CARTÃO_PARCELADO(true, 3),
    CARTÃO_À_VISTA(false, 1),
    PAYPAL(false, 1);  // mudar para inglês com método como descrição em PTBR

    private final boolean installmentBuyingAllowed;
    private final int maximumNumberOfInstallmentsAllowed;

    PaymentOption(boolean installmentBuyingAllowed, int maximumNumberOfInstallmentsAllowed) {
        this.installmentBuyingAllowed = installmentBuyingAllowed;
        this.maximumNumberOfInstallmentsAllowed = maximumNumberOfInstallmentsAllowed;
    }


    public boolean isInstallmentBuyingAllowed() {
        return installmentBuyingAllowed;
    }

    public int getMaximumNumberOfInstallmentsAllowed() {
        return maximumNumberOfInstallmentsAllowed;
    }
}
