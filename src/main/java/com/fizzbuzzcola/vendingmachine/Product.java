package com.fizzbuzzcola.vendingmachine;

import org.springframework.stereotype.Service;


import java.math.BigDecimal;


public class Product {

    private String name;
    private BigDecimal price;

    private VendingMachine vendingMachine;
    private int numberInStock;

    protected Product() {}

    public Product(String name, BigDecimal price, VendingMachine vendingMachine, int numberInStock) {
        this.name = name;
        this.price = price;
        this.vendingMachine = vendingMachine;
        this.numberInStock = numberInStock;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }



    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void dispenseProduct() {
        numberInStock--;
    }
}
