package Day1.bigdecimal.carlot.ui;

public class CarLotView {
    private UserIO io;

    public CarLotView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List of Cars");
        io.print("2. View a Car");
        io.print("3. Cars by Color");
        io.print("4. Cars by Price");
        io.print("5. Cars by Make & Model");
        io.print("6. Buy a Car");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
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
