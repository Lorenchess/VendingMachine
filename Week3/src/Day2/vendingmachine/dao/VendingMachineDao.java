package Day2.vendingmachine.dao;

import Day2.vendingmachine.dto.VendingMachine;

import java.math.BigDecimal;

public interface VendingMachineDao {
    VendingMachine createFoodProduct(String name, BigDecimal price);
    VendingMachine createDrinkProduct(String name, BigDecimal price);
}