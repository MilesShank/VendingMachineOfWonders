package com.fizzbuzzcola.vendingmachine;

import java.math.BigDecimal;

public class VendingMachine {
    private BigDecimal totalMoney;

    public VendingMachine(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }
}
