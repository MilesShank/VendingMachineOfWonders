package com.fizzbuzzcola.vendingmachine;

import java.math.BigDecimal;

public class VendingMachine {

    private BigDecimal totalMoney;
    private BigDecimal quarter;
    private BigDecimal dime;
    private BigDecimal nickel;

    public VendingMachine(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
        this.quarter = new BigDecimal(".25");
        this.dime = new BigDecimal(".10");
        this.nickel = new BigDecimal(".05");
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void acceptCoin(String insertedCoin) {
        if (insertedCoin.equalsIgnoreCase("quarter")) {
            totalMoney = totalMoney.add(quarter);
        } else if (insertedCoin.equalsIgnoreCase("dime")) {
            totalMoney = totalMoney.add(dime);
        } else if (insertedCoin.equalsIgnoreCase("nickel")){
            totalMoney = totalMoney.add(nickel);
        }
    }
}
