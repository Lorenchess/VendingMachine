package vendingmachine.dao;

import vendingmachine.dto.VendingMachine;
import vendingmachine.service.VendingMachineInsufficientFundsException;
import vendingmachine.service.VendingMachineNoItemInventoryException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VendingMachineDao {
//    VendingMachine createFoodProduct(String name, BigDecimal price);
//    VendingMachine createDrinkProduct(String name, BigDecimal price);
    //Map<VendingMachine,Integer> addingProductsToVendingMachine() throws VendingMachinePersistenceException;
    void displayingProductsFromVendingMachine() throws VendingMachinePersistenceException;
    List<VendingMachine> getVendingMachineProducts() throws VendingMachinePersistenceException;

    VendingMachine buyingAProduct(BigDecimal userMoney, String productName) throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException, VendingMachinePersistenceException;


}
