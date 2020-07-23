package com.fizzbuzzcola.vendingmachine;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


@Service
public class VendingMachine {

    private BigDecimal totalMoney;
    private BigDecimal quarter;
    private BigDecimal dime;
    private BigDecimal nickel;
    private Collection<String> coinReturn;
    private String machineDisplay;
    private HashMap<String, Product> products = new HashMap<>();

    protected VendingMachine() {}

    public VendingMachine(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
        this.quarter = new BigDecimal(".25");
        this.dime = new BigDecimal(".10");
        this.nickel = new BigDecimal(".05");
        this.coinReturn = new ArrayList<>();
        this.machineDisplay = "INSERT COIN";
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public Collection<String> getCoinReturn() {
        return coinReturn;
    }

    public String getMachineDisplay() {
        return machineDisplay;
    }

    public Collection<Product> getProducts() {
        return products.values();
    }

    public void acceptCoin(String insertedCoin) {
        if (insertedCoin.equalsIgnoreCase("quarter")) {
            totalMoney = totalMoney.add(quarter);
        } else if (insertedCoin.equalsIgnoreCase("dime")) {
            totalMoney = totalMoney.add(dime);
        } else if (insertedCoin.equalsIgnoreCase("nickel")){
            totalMoney = totalMoney.add(nickel);
        } else {
            coinReturn.add(insertedCoin);
        }
        machineDisplay = totalMoney.toString();
    }

    public void addProduct(Product product) {

        products.put(product.getName(),product);
    }

    public Product selectProduct(String productToSelect) {
        return products.get(productToSelect);
    }

    public void dispenseProduct(String selectedProduct) {
        Product ourSelectedProduct = products.get(selectedProduct);
        if(ourSelectedProduct.getPrice().compareTo(totalMoney)<=0){
            ourSelectedProduct.dispenseProduct();
            totalMoney.subtract(ourSelectedProduct.getPrice());
            machineDisplay = "THANK YOU";
        }
    }
}
