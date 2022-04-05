package Day2.vendingmachine.dao;

import Day2.vendingmachine.dto.Drink;
import Day2.vendingmachine.dto.Food;
import Day2.vendingmachine.dto.VendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDaoFileImpl implements VendingMachineDao{


    //Map or List?//string, vendingMachine  save the data in map or list
    private List<VendingMachine> myVendingMachine = new ArrayList<>();


    @Override
    public VendingMachine createFoodProduct(String name, BigDecimal price) {
        return new Food(name,price);
    }

    @Override
    public VendingMachine createDrinkProduct(String name, BigDecimal price) {
        return new Drink(name, price);
    }

    public void addingProductsToVendingMachine() {
        myVendingMachine.add(createDrinkProduct("Orange Juice", new BigDecimal("1.00")));
        myVendingMachine.add(createDrinkProduct("Apple Juice", new BigDecimal("1.00")));
        myVendingMachine.add(createDrinkProduct("Strawberry Juice", new BigDecimal("1.00")));
        myVendingMachine.add(createFoodProduct("Doritos", new BigDecimal("1.00")));
        myVendingMachine.add(createFoodProduct("Pop Corn", new BigDecimal("1.00")));
        myVendingMachine.add(createFoodProduct("Chocolate bar", new BigDecimal("1.00")));
    }









}
