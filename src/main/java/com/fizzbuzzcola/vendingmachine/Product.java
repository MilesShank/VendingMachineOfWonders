package com.fizzbuzzcola.vendingmachine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

//@Entity
public class Product {
//    @Id
//    @GeneratedValue
//    private long id;
    private String name;
    private BigDecimal price;
//    @ManyToOne
    private VendingMachine vendingMachine;

    protected Product() {}

    public Product(String name, BigDecimal price, VendingMachine vendingMachine) {
        this.name = name;
        this.price = price;
        this.vendingMachine = vendingMachine;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

//    public long getId() {
//        return id;
//    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }
}
