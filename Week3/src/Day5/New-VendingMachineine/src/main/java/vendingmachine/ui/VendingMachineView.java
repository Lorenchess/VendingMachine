package vendingmachine.ui;


import java.math.BigDecimal;

public class VendingMachineView {
   private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("\nMain Menu");
        io.print("1. Buy a Product");
        io.print("2. Insert Money");
        io.print("3. Exit Program");

        return io.readInt("Please select from the above choices.", 1, 3);
    }

    public BigDecimal getUserMoney() {
        BigDecimal userMoney = null;
        userMoney = io.readBigDecimal("Please enter your cash amount:");
//        io.print("You have available $" +userMoney + " in your account.");
        return userMoney;
    }

    public String getUserProductName() {
        return io.readString("Please enter the name of the item you want to purchase:");
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
        io.print(errorMsg);
    }






















}
