package Day2.vendingmachine.TestPackages.dao;

import Day2.vendingmachine.dao.VendingMachineDao;
import Day2.vendingmachine.dao.VendingMachinePersistenceException;
import Day2.vendingmachine.dto.VendingMachine;
import Day2.vendingmachine.service.VendingMachineInsufficientFundsException;
import Day2.vendingmachine.service.VendingMachineNoItemInventoryException;

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
        List<VendingMachine> products = new ArrayList<>();
        products.add(onlyProduct);
        for (var product : products) {
            System.out.println(product);
        }
    }

    @Override
    public void buyingAProduct(BigDecimal userMoney, String productName) throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException, VendingMachinePersistenceException {

    }
}
