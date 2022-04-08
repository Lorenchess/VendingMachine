package Day2.vendingmachine.TestPackages.service;

import Day2.vendingmachine.dto.VendingMachine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineServiceLayerImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void displayInitialData() {
        Map<VendingMachine, Integer> myVendingMachineProducts =new HashMap<>();
        myVendingMachineProducts.forEach((k,v) -> System.out.println(k + ", Total available = " + v + " units."));
    }

    @Test
    void buyProduct() {
    }
}