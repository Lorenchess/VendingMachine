package Day2.vendingmachine.service;

import java.math.BigDecimal;

public interface VendingMachineServiceLayer {
    void displayInitialData();
    void buyProduct(BigDecimal userMoney, String productName);
}
