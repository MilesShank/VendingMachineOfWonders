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

    @BeforeEach
    void setUp() {
        underTest = new VendingMachine(new BigDecimal("10.10"));
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
}
