package vendingmachine.dao;

import vendingmachine.service.VendingMachineNoItemInventoryException;

public interface VendingMachineAuditDao {
    void writeAuditEntry(String entry) throws VendingMachinePersistenceException, VendingMachineNoItemInventoryException;
}
