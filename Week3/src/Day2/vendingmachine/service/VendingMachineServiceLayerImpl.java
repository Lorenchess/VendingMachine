package Day2.vendingmachine.service;

import Day2.vendingmachine.dao.VendingMachineAuditDao;
import Day2.vendingmachine.dao.VendingMachineDao;

import java.math.BigDecimal;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void displayInitialData() {
        dao.displayingProductsFromVendingMachine();

    }

    @Override
    public void buyProduct(BigDecimal userMoney, String productName) {
        dao.buyingAProduct(userMoney, productName);
    }
}
