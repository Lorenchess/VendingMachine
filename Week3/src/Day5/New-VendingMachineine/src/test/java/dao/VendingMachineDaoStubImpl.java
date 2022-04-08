package dao;

import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.VendingMachine;
import vendingmachine.service.VendingMachineInsufficientFundsException;
import vendingmachine.service.VendingMachineNoItemInventoryException;

import java.math.BigDecimal;
import java.util.*;

public class VendingMachineDaoStubImpl implements VendingMachineDao {
    public VendingMachine onlyProduct;

    public VendingMachineDaoStubImpl() {
        onlyProduct = new VendingMachine("Apple Juice");
        onlyProduct.setPrice(new BigDecimal("0.50"));
        onlyProduct.setTotalUnits(50);
    }

    @Override
    public void displayingProductsFromVendingMachine() throws VendingMachinePersistenceException {

    }

    @Override
    public List<VendingMachine> getVendingMachineProducts() throws VendingMachinePersistenceException {
        List<VendingMachine> products = new ArrayList<>();
        products.add(onlyProduct);
        for (VendingMachine product : products) {
            System.out.println(product);
        }
        return products;
    }

    @Override
    public void buyingAProduct(BigDecimal userMoney, String productName) throws VendingMachinePersistenceException {

    }
}
