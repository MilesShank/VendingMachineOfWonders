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
    private HashMap<String, Integer> coins = new HashMap<>();

    protected VendingMachine() {}

    public VendingMachine(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
        this.quarter = new BigDecimal(".25");
        this.dime = new BigDecimal(".10");
        this.nickel = new BigDecimal(".05");
        this.coinReturn = new ArrayList<>();
        this.machineDisplay = "INSERT COIN";
        this.coins.put("Quarter", 20);
        this.coins.put("Dime", 20);
        this.coins.put("Nickel", 20);
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
            coins.replace("Quarter", (coins.get("Quarter") + 1));
        } else if (insertedCoin.equalsIgnoreCase("dime")) {
            totalMoney = totalMoney.add(dime);
            coins.replace("Dime", (coins.get("Dime") + 1));
        } else if (insertedCoin.equalsIgnoreCase("nickel")){
            totalMoney = totalMoney.add(nickel);
            coins.replace("Nickel", (coins.get("Nickel") + 1));
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
        if (ourSelectedProduct.getNumberInStock() <= 0){
            machineDisplay = "Product Out Of Stock";
        } else if(ourSelectedProduct.getPrice().compareTo(totalMoney)<=0){
            ourSelectedProduct.dispenseProduct();
            totalMoney = totalMoney.subtract(ourSelectedProduct.getPrice());
            machineDisplay = "THANK YOU";
        } else {
            machineDisplay = "Please enter $" + (ourSelectedProduct.getPrice().subtract(totalMoney));
        }
    }

    public void dispenseCoins() {
        while (totalMoney.compareTo(BigDecimal.valueOf(0)) != 0) {
            if (totalMoney.compareTo(quarter) >= 0) {
                totalMoney = totalMoney.subtract(quarter);
                coins.replace("Quarter", (coins.get("Quarter") - 1));
                coinReturn.add("Quarter");
            } else if (totalMoney.compareTo(dime) >= 0 ) {
                totalMoney = totalMoney.subtract(dime);
                coins.replace("Dime", (coins.get("Dime") - 1));
                coinReturn.add("Dime");
            } else if (totalMoney.compareTo(nickel) >= 0) {
                totalMoney = totalMoney.subtract(nickel);
                coins.replace("Nickel", (coins.get("Nickel") - 1));
                coinReturn.add("Nickel");
            }
        }
    }

    public int getCoinCount(String coin) {
        return coins.get(coin);
    }

    public boolean checkForExactChange(String productName) {
        Product productToCheck = products.get(productName);
        BigDecimal checkTotalMoney = totalMoney.subtract(productToCheck.getPrice());
        int quarters = coins.get("Quarter");
        int dimes = coins.get("Dime");
        int nickels = coins.get("Nickel");
        while (checkTotalMoney.compareTo(BigDecimal.valueOf(0)) != 0) {
            if (checkTotalMoney.compareTo(quarter) >= 0) {
                quarters--;
                checkTotalMoney = checkTotalMoney.subtract(quarter);
            } else if (checkTotalMoney.compareTo(dime) >= 0 ) {
                dimes--;
                checkTotalMoney = checkTotalMoney.subtract(dime);
            } else if (checkTotalMoney.compareTo(nickel) >= 0) {
                nickels--;
                checkTotalMoney = checkTotalMoney.subtract(nickel);
            }
            if (quarters <= 0 || dimes <= 0 || nickels <= 0) {
                return false;
            }
        }
        return true;
    }
}
