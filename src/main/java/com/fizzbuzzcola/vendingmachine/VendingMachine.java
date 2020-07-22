package com.fizzbuzzcola.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class VendingMachine {

    private BigDecimal totalMoney;
    private BigDecimal quarter;
    private BigDecimal dime;
    private BigDecimal nickel;
    private Collection<String> coinReturn;

    public VendingMachine(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
        this.quarter = new BigDecimal(".25");
        this.dime = new BigDecimal(".10");
        this.nickel = new BigDecimal(".05");
        this.coinReturn = new ArrayList<>();
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public Collection<String> getCoinReturn() {
        return coinReturn;
    }

    public void acceptCoin(String insertedCoin) {
        if (insertedCoin.equalsIgnoreCase("quarter")) {
            totalMoney = totalMoney.add(quarter);
        } else if (insertedCoin.equalsIgnoreCase("dime")) {
            totalMoney = totalMoney.add(dime);
        } else if (insertedCoin.equalsIgnoreCase("nickel")){
            totalMoney = totalMoney.add(nickel);
        } else {
            coinReturn.add(insertedCoin);
        }
    }
}
