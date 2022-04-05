package Day2.vendingmachine.dao;

import Day2.vendingmachine.dto.Drink;
import Day2.vendingmachine.dto.Food;
import Day2.vendingmachine.dto.VendingMachine;
import Day2.vendingmachine.service.VendingMachineNoItemInventoryException;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class VendingMachineDaoFileImpl implements VendingMachineDao{


    //Map or List?//string, vendingMachine  save the data in map or list
    private Map<VendingMachine, Integer> myVendingM =new HashMap<>();


    @Override
    public VendingMachine createFoodProduct(String name, BigDecimal price) {
        return new Food(name,price);
    }

    @Override
    public VendingMachine createDrinkProduct(String name, BigDecimal price) {
        return new Drink(name, price);
    }

    @Override
    public Map<VendingMachine,Integer> addingProductsToVendingMachine() {

        myVendingM.put(createDrinkProduct("Orange Juice", new BigDecimal("1.00")), 50);
        myVendingM.put(createDrinkProduct("Apple Juice", new BigDecimal("1.00")), 50);
        myVendingM.put(createDrinkProduct("Strawberry Juice", new BigDecimal("1.00")), 50);
        myVendingM.put(createFoodProduct("Doritos", new BigDecimal("1.00")), 50);
        myVendingM.put(createFoodProduct("Chocolate bar", new BigDecimal("1.00")), 50);
        return myVendingM;
    }
    @Override
    public void displayingProductsFromVendingMachine() {
        Map<VendingMachine, Integer> products = addingProductsToVendingMachine();
        products.forEach((k,v) -> System.out.println(k + ", Total available = " + v + " units."));
    }

    @Override
    public void buyingAProduct(BigDecimal userMoney, String productName) {
        Set<VendingMachine> myProducts = myVendingM.keySet();

        VendingMachine userProduct = null;
        for (var product : myProducts) {
            if (product.getName().equalsIgnoreCase(productName)){
                userProduct = product;
            } else {
                //throw new VendingMachineNoItemInventoryException();
                System.out.println("No item found");
            }
        }
        myVendingM.computeIfPresent(userProduct,(key, val) -> --val);
        displayingProductsFromVendingMachine();
    }


}
