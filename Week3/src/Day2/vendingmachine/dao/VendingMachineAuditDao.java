package Day2.vendingmachine.dao;

import Day2.vendingmachine.service.VendingMachineNoItemInventoryException;

public interface VendingMachineAuditDao {
    void writeAuditEntry(String entry) throws VendingMachinePersistenceException, VendingMachineNoItemInventoryException;
}
