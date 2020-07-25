package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VendingMachineApplicationTests {
    private VendingMachine underTest;
    private Product testChips;
    @BeforeEach
    void setUp() {
        underTest = new VendingMachine(new BigDecimal("10.10"));
        testChips = new Product("Chips2", BigDecimal.valueOf(1.25), 5);
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
        assertEquals(21, underTest.getCoinCount("Quarter"));

    }

    @Test
    public void vendingMachineShouldRejectInvalidCoins() {
        underTest.acceptCoin("apple");
        assertThat(underTest.getCoinReturn()).containsExactlyInAnyOrder("apple");
    }

    @Test
    public void vendingMachineShouldHaveProducts() {
        Product testProduct = new Product("Cola2", BigDecimal.valueOf(1.00), 5);
        underTest.addProduct(testProduct);
        assertThat(underTest.getProducts()).contains(testProduct);
    }

    @Test
    public void vendingMachineShouldDispenseProduct(){
        underTest.dispenseProduct("Chips2");
        assertEquals(4, testChips.getNumberInStock());
        assertEquals(BigDecimal.valueOf(8.85), underTest.getTotalMoney());
        assertEquals("THANK YOU", underTest.getMachineDisplay());
    }

    @Test
    public void vendingMachineShouldNotDispenseProductIfNotEnoughMoneyHasBeenAdded(){
        VendingMachine testVendingMachine = new VendingMachine(BigDecimal.valueOf(0));
        testVendingMachine.addProduct(testChips);
        testVendingMachine.dispenseProduct("Chips2");
        assertEquals(5, testChips.getNumberInStock());
        assertEquals(BigDecimal.valueOf(0), testVendingMachine.getTotalMoney());
        assertEquals("Please enter $1.25", testVendingMachine.getMachineDisplay());
    }

    @Test
    public void vendingMachineShouldReturnCoins(){
        VendingMachine testVendingMachine = new VendingMachine(BigDecimal.valueOf(.65));
        testVendingMachine.dispenseCoins();
        assertEquals(18,testVendingMachine.getCoinCount("Quarter"));
        assertEquals(19,testVendingMachine.getCoinCount("Dime"));
        assertEquals(19,testVendingMachine.getCoinCount("Nickel"));
        ArrayList<String> expectedReturn = new ArrayList<>();
        expectedReturn.add("Quarter");
        expectedReturn.add("Quarter");
        expectedReturn.add("Dime");
        expectedReturn.add("Nickel");
        assertEquals(expectedReturn, testVendingMachine.getCoinReturn());
    }

    @Test
    public void vendingMachineShouldUpdateDisplayWhenOutOfStockProductIsSelected() {
        Product testProduct = new Product("Cola2", BigDecimal.valueOf(2.00), 0);
        underTest.addProduct(testProduct);
        underTest.dispenseProduct("Cola2");
        assertEquals("Product Out Of Stock", underTest.getMachineDisplay());
    }

    @Test
    public void vendingMachineShouldHaveCollectionOfCoins(){
        assertEquals(20, underTest.getCoinCount("Quarter"));
        assertEquals(20, underTest.getCoinCount("Dime"));
        assertEquals(20, underTest.getCoinCount("Nickel"));
    }

    @Test
    public void vendingMachineShouldCheckIfExactChangeIsRequired(){
        Product testProduct = new Product("Antiviral Cola", BigDecimal.valueOf(9.00), 5);
        underTest.addProduct(testProduct);
        assertTrue(underTest.checkForExactChange("Antiviral Cola"));
        assertFalse(underTest.checkForExactChange("Chips2"));
    }

    @Test
    public void shouldBeAbleToEmptyCoinReturn(){
        underTest.dispenseProduct("Chips");
        underTest.emptyCoinReturn();
    }
}
