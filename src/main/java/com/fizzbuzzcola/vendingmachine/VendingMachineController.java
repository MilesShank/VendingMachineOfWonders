package com.fizzbuzzcola.vendingmachine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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

    @GetMapping("/api/vend/acceptCoin/{coin}")
    public void machineAcceptsCoin(@PathVariable String coin){vendingMachine.acceptCoin(coin);}
}
