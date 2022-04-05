package Day2.vendingmachine.ui;


import java.math.BigDecimal;

public class VendingMachineView {
   private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("\nMain Menu");
        io.print("1. Buy a Product");
        io.print("2. Exit Program");

        return io.readInt("Please select from the above choices.", 1, 2);
    }

    public BigDecimal getAndDisplayUserMoney() {
        BigDecimal userMoney = null;
        userMoney = io.readBigDecimal("Please enter your card or cash");
        io.print("You enter $" +userMoney);
       return userMoney;
    }


    public void displaySuccessBanner() {
        io.readString("Product successfully bought. Please press enter to continue");
    }

    public void displayWelcomeBanner() {
        io.print("Welcome to your Vending Machine!!\n");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }






















}
