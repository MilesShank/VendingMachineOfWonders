package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

public class ProductTest {
    private Product underTest;
    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp(){
        vendingMachine = new VendingMachine(BigDecimal.valueOf(10.10));
        underTest = new Product("name", BigDecimal.valueOf(1.00), vendingMachine);
    }


}
