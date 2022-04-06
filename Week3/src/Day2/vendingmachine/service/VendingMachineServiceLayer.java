package Day2.vendingmachine.service;

import Day2.vendingmachine.dao.VendingMachinePersistenceException;

import java.math.BigDecimal;

public interface VendingMachineServiceLayer {
    void displayInitialData() throws VendingMachinePersistenceException;
    void buyProduct(BigDecimal userMoney, String productName) throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException, VendingMachinePersistenceException;
}
