package Day2.vendingmachine.controller;

import Day2.vendingmachine.service.VendingMachineNoItemInventoryException;
import Day2.vendingmachine.service.VendingMachineServiceLayer;
import Day2.vendingmachine.ui.VendingMachineView;

import java.math.BigDecimal;

public class VendingMachineController {
    private VendingMachineView view;
    private VendingMachineServiceLayer service;
    public static BigDecimal userMoney;


    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing) {
                welcomeMessage();
                askUserMoneyAndDisplayData();
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:

                        break;
                    case 2:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        }catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private void askUserMoneyAndDisplayData() {
       userMoney = view.getAndDisplayUserMoney();
        displayingInitialData();
    }

    private void buyAProduct() {
        //view.getAndDisplayUserMoney();
        //ask user for name of product
        //service.buyProduct();
    }

    private void welcomeMessage() {
        view.displayWelcomeBanner();
    }

    private void displayingInitialData() {
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
