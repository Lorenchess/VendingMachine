package vendingmachine.controller;

import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.service.VendingMachineInsufficientFundsException;
import vendingmachine.service.VendingMachineNoItemInventoryException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.ui.VendingMachineView;

import java.math.BigDecimal;

public class VendingMachineController {
    private VendingMachineView view;
    private VendingMachineServiceLayer service;
    public static BigDecimal userMoney;


    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() throws VendingMachinePersistenceException {
        boolean keepGoing = true;
        int menuSelection = 0;
        welcomeMessage();
        askForUsersMoney();
        displayInitialData();
        try{
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        buyAProduct();
                        break;
                    case 2:
                        askForUsersMoney();
                        break;
                    case 3:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        }catch (VendingMachinePersistenceException | VendingMachineInsufficientFundsException | VendingMachineNoItemInventoryException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void askForUsersMoney() {
        userMoney = view.getUserMoney();
    }

    private void displayInitialData() throws VendingMachinePersistenceException {
        displayingInitialData();
    }


    private void buyAProduct() throws VendingMachinePersistenceException, VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException {
        String userProduct = view.getUserProductName();
        service.buyProduct(userMoney, userProduct);
    }

    private void welcomeMessage() {
        view.displayWelcomeBanner();
    }

    private void displayingInitialData() throws VendingMachinePersistenceException {
        service.displayInitialData();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
