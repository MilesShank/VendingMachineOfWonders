package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

public class ProductTest {
    private Product underTest;

    @BeforeEach
    void setUp(){
        underTest = new Product("name", BigDecimal.valueOf(1.00));
    }
}
