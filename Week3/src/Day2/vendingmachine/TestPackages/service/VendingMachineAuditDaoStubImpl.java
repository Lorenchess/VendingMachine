package Day2.vendingmachine.TestPackages.service;

import Day2.vendingmachine.dao.VendingMachineAuditDao;
import Day2.vendingmachine.dao.VendingMachinePersistenceException;
import Day2.vendingmachine.service.VendingMachineNoItemInventoryException;

public class VendingMachineAuditDaoStubImpl implements VendingMachineAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException, VendingMachineNoItemInventoryException {
        //do nothing . . .
    }
}
