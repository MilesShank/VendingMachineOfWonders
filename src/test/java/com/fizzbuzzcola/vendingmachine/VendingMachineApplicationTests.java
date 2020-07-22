package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VendingMachineApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void vendingMachineShouldExist() {
        VendingMachine underTest = new VendingMachine(new BigDecimal("10.10"));
    }

    @Test
    public void vendingMachineShouldAcceptCoins() {
        VendingMachine underTest = new VendingMachine(new BigDecimal("10.10"));
        underTest.acceptCoin("quarter");
        assertEquals(BigDecimal.valueOf(10.35), underTest.getTotalMoney());
    }
}
