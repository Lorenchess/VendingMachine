package vendingmachine.service;

import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;

import java.math.BigDecimal;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void displayInitialData() throws VendingMachinePersistenceException {
        dao.displayingProductsFromVendingMachine();

    }

    @Override
    public void buyProduct(BigDecimal userMoney, String productName) throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException, VendingMachinePersistenceException {
        dao.buyingAProduct(userMoney, productName);
        auditDao.writeAuditEntry("The " + productName + " was successfully bought");
    }
}
