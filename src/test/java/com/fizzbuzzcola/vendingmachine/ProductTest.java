package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTest {
    private Product underTest;

    @BeforeEach
    void setUp() {
        underTest = new Product("name", BigDecimal.valueOf(1.00), 5);
    }

    @Test
    public void canDispenseProduct() {
        underTest.dispenseProduct();
        assertEquals(4, underTest.getNumberInStock());
    }


}
