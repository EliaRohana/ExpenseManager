package com.elia.em.model;

/**
 * Created by Elia on 1/13/2017.
 */
public enum PaymentMode {
    cash("Cash"),
    credit_card("Credit Card"),
    bank_transfer("Bank Transfer"),
    check("Check"),
    paypal("PayPal"),
    other("Other");

    private String label;

    PaymentMode(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
