package com.example.a2_adrien_alow5;

import java.io.Serializable;

public class Purchase implements Serializable {
    private String storeName;
    private double purchaseAmount;
    private boolean alreadyPayed;

    public Purchase(String storeName, double purchaseAmount, boolean alreadyPayed) {
        this.storeName = storeName;
        this.purchaseAmount = purchaseAmount;
        this.alreadyPayed = alreadyPayed;
    }
    public String getStoreName() {
        return storeName;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public boolean isAlreadyPayed() {
        return alreadyPayed;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void setAlreadyPayed(boolean alreadyPayed) {
        this.alreadyPayed = alreadyPayed;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "storeName='" + storeName + '\'' +
                ", purchaseAmount=" + purchaseAmount +
                ", alreadyPayed=" + alreadyPayed +
                '}';
    }
}
