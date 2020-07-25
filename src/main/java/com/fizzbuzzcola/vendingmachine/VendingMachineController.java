package com.fizzbuzzcola.vendingmachine;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin
@RestController
public class VendingMachineController {
    private VendingMachine vendingMachine;

    public VendingMachineController(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }


    @GetMapping("/api/vend/machinedisplay")
    public String showMachineDisplay(){return vendingMachine.getMachineDisplay();}

    @GetMapping("/api/vend/products")
    public Collection<Product> getMachineProducts(){return vendingMachine.getProducts();}

    @GetMapping("/api/vend/acceptcoin/{coin}")
    public void machineAcceptsCoin(@PathVariable String coin){vendingMachine.acceptCoin(coin);}

    @GetMapping("/api/vend/dispenseproduct/{productName}")
    public void machineDispensesProduct(@PathVariable String productName){vendingMachine.dispenseProduct(productName); }

    @GetMapping("/api/vend/returncoins")
    public void machineReturnsCoins(){vendingMachine.dispenseCoins();}

    @GetMapping("/api/vend/getcoinreturn")
    public Collection<String> viewMachineCoinReturn(){return vendingMachine.getCoinReturn();}

    @GetMapping("/api/vend/emptycoinreturn")
    public void emptyMachineCoinReturn(){vendingMachine.emptyCoinReturn();}

    @GetMapping("/api/vend/products/{productName}")
    public Product viewMachineProduct(@PathVariable String productName){return vendingMachine.selectProduct(productName);}

}