package Day2.vendingmachine.dao;

import Day2.vendingmachine.dto.VendingMachine;
import Day2.vendingmachine.service.VendingMachineInsufficientFundsException;
import Day2.vendingmachine.service.VendingMachineNoItemInventoryException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VendingMachineDao {
//    VendingMachine createFoodProduct(String name, BigDecimal price);
//    VendingMachine createDrinkProduct(String name, BigDecimal price);
    //Map<VendingMachine,Integer> addingProductsToVendingMachine() throws VendingMachinePersistenceException;
    void displayingProductsFromVendingMachine() throws VendingMachinePersistenceException;

    void buyingAProduct(BigDecimal userMoney, String productName) throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException, VendingMachinePersistenceException;
}
