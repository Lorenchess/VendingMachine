package service;

import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.service.VendingMachineNoItemInventoryException;

public class VendingMachineAuditDaoStubImpl implements VendingMachineAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException, VendingMachineNoItemInventoryException {
        //do nothing . . .
    }
}
