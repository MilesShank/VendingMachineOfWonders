package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class VendingMachineApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    public void vendingMachineShouldExist() {
        VendingMachine underTest = new VendingMachine(new BigDecimal("10.10"));
    }
}
