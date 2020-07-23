package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VendingMachineApplicationTests {
    private VendingMachine underTest;
    private Product testChips;
    @BeforeEach
    void setUp() {
        underTest = new VendingMachine(new BigDecimal("10.10"));
        testChips = new Product("Chips", BigDecimal.valueOf(1.25), 5);
        underTest.addProduct(testChips);

    }

    @Test
    void contextLoads() {
    }


    @Test
    public void vendingMachineShouldExist() {
        VendingMachine underTest = new VendingMachine(new BigDecimal("10.10"));
    }

    @Test
    public void vendingMachineShouldAcceptCoins() {
        underTest.acceptCoin("quarter");
        assertEquals(BigDecimal.valueOf(10.35), underTest.getTotalMoney());
    }

    @Test
    public void vendingMachineShouldRejectInvalidCoins() {
        underTest.acceptCoin("apple");
        assertThat(underTest.getCoinReturn()).containsExactlyInAnyOrder("apple");
    }

    @Test
    public void vendingMachineShouldHaveProducts() {
        Product testProduct = new Product("Cola", BigDecimal.valueOf(1.00), 5);
        underTest.addProduct(testProduct);
        assertThat(underTest.getProducts()).containsExactlyInAnyOrder(testProduct);
    }

    @Test
    public void vendingMachineShouldDispenseProduct(){
        underTest.selectProduct("Chips");

    }
}
