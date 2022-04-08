package Day2.vendingmachine.dao;

import Day2.vendingmachine.controller.VendingMachineController;
import Day2.vendingmachine.dto.Coins;
import Day2.vendingmachine.dto.VendingMachine;
import Day2.vendingmachine.service.VendingMachineInsufficientFundsException;
import Day2.vendingmachine.service.VendingMachineNoItemInventoryException;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


public class VendingMachineDaoFileImpl implements VendingMachineDao{
    private final String VENDING_MACHINE_FILE;
    public static final String DELIMITER = "::";

    public VendingMachineDaoFileImpl() {
        VENDING_MACHINE_FILE = "C:\\Users\\Ramon Lorente\\Desktop\\c184-Java-React\\Week3\\src\\Day2\\vendingmachine\\dao\\VendingMachineFile";
    }

    public VendingMachineDaoFileImpl(String vendingMachineTextFile) {
        VENDING_MACHINE_FILE = vendingMachineTextFile;
    }

    private Map<VendingMachine, Integer> myVendingMachineProducts =new HashMap<>();



    @Override
    public void displayingProductsFromVendingMachine() throws VendingMachinePersistenceException {
        loadVendingMachine();
        myVendingMachineProducts.forEach((k,v) -> System.out.println(k + ", Total available = " + v + " units."));
    }

    @Override
    public void buyingAProduct(BigDecimal userMoney, String productName) throws VendingMachineInsufficientFundsException, VendingMachinePersistenceException {
        loadVendingMachine();
        VendingMachine userProduct = null;
        Set<VendingMachine> myProducts = myVendingMachineProducts.keySet();

        int enoughMoney = 0;

        for (var product: myProducts){
            if (product.getName().equalsIgnoreCase(productName)){
                System.out.println(product + " was selected.");
                userProduct = product;
                enoughMoney = userMoney.compareTo(userProduct.getPrice());
            }
        }
        checkProductAndUserMoney(enoughMoney,userProduct,userMoney);
        writeVendingMachine();
    }

    private void checkProductAndUserMoney(int comparedMoney, VendingMachine userProduct, BigDecimal userMoney) throws VendingMachineInsufficientFundsException, VendingMachinePersistenceException {
        loadVendingMachine();
        if (comparedMoney >= 0) {
            if (userProduct != null) {
                myVendingMachineProducts.compute(userProduct,(key, val) -> {
                    if (val > 0){
                        return --val;
                    }else{
                        try {
                            throw new VendingMachineNoItemInventoryException("Item is not longer available.");
                        } catch (VendingMachineNoItemInventoryException e) {
                            System.out.println("Item is not longer available.");
                        }
                        return val;
                    }
                });
                writeVendingMachine();
                var change = updateUserMoneyAvailable(userMoney, userProduct);

                giveUserChangeInCoins(change);

            } else {
                System.out.println("Product not found");
            }
        } else {
            printUserAmountNeedIt(userProduct.getPrice(),userMoney);
            throw new VendingMachineInsufficientFundsException("You have not enough founds.");
        }

         myVendingMachineProducts.forEach((key, val) -> System.out.println("Updated " + key + ", Total available = " + val + " units."));

        //writeVendingMachine(); does nothing
    }

    private BigDecimal updateUserMoneyAvailable(BigDecimal userMoney, VendingMachine userProduct) throws VendingMachinePersistenceException {
        loadVendingMachine();
        VendingMachineController.userMoney = userMoney.subtract(userProduct.getPrice());
        System.out.println("Updated money "+VendingMachineController.userMoney);

        return VendingMachineController.userMoney;
    }


    private void giveUserChangeInCoins(BigDecimal amount) throws VendingMachinePersistenceException {
        loadVendingMachine();
        BigInteger quarters, dimes, nickels, pennies, cents;

          cents = amount.multiply(BigDecimal.valueOf(100)).toBigInteger(); //to convert to pennies

          quarters = cents.divide(Coins.QUARTER.getValue());
          cents = cents.remainder(Coins.QUARTER.getValue());

          dimes = cents.divide(Coins.DIME.getValue());
          cents = cents.remainder(Coins.DIME.getValue());

          nickels = cents.divide(Coins.NICKEL.getValue());
          cents = cents.remainder(Coins.NICKEL.getValue());

          pennies = cents.divide(Coins.PENNY.getValue());
          cents = cents.remainder(Coins.PENNY.getValue());
        System.out.println("Here is your change..."+quarters + " coins in quarter, "+ dimes + " coins in dimes, "+nickels + " coins nickels, and "+ pennies +" coins pennies. For a total of $" + amount);

    }

    private BigDecimal calculateUserAmountNeedItToPurchase(BigDecimal priceOfItem, BigDecimal userFounds ) throws VendingMachinePersistenceException {
        loadVendingMachine();
        BigDecimal totalToPutInMachine = priceOfItem.subtract(userFounds);
        return totalToPutInMachine;
    }

    private void printUserAmountNeedIt(BigDecimal priceOfItem, BigDecimal userFounds) throws VendingMachinePersistenceException {
        loadVendingMachine();
        BigDecimal amount = null;
        amount = calculateUserAmountNeedItToPurchase(priceOfItem,userFounds );
        System.out.println(" You need $"+ amount + " more in your account to purchase the item selected.");
    }

    private VendingMachine unmarshallVendingMachine(String vendingMachineAsText){

        String[] vendingMachineTokens = vendingMachineAsText.split(DELIMITER);


        String productName = vendingMachineTokens[0];

        VendingMachine vendingMachineFromFile = new VendingMachine(productName);

        vendingMachineFromFile.setPrice(new BigDecimal(vendingMachineTokens[1]));

        vendingMachineFromFile.setTotalUnits(Integer.parseInt(vendingMachineTokens[2]));


        return vendingMachineFromFile;
    }


    private void loadVendingMachine() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(VENDING_MACHINE_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        VendingMachine currentVendingMachine;

        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a VM
            currentVendingMachine = unmarshallVendingMachine(currentLine);

            // We are going to use the vm as the map key for our student object.
            // Put currentVM into the map using vm as the key
            myVendingMachineProducts.put(currentVendingMachine, currentVendingMachine.getTotalUnits()); //need to check this part
        }
        // close scanner
        scanner.close();
    }

    private String marshallVendingMachine(VendingMachine aVendingMachine, int value){

        String vendingMachineAsText = aVendingMachine.getName() + DELIMITER;

        // add the rest of the properties in the correct order:

        // Price
        vendingMachineAsText += aVendingMachine.getPrice() + DELIMITER;

        //Total Units
        vendingMachineAsText += value;

        return vendingMachineAsText;
    }


    private void writeVendingMachine() throws VendingMachinePersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(VENDING_MACHINE_FILE, false));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save student data.", e);
        }

        String vendingMachineAsText;


        for (Map.Entry<VendingMachine,Integer> entry: myVendingMachineProducts.entrySet()) {

            vendingMachineAsText = marshallVendingMachine(entry.getKey(), entry.getValue()); //pass a list of key with values

            // write the machine object to the file
            out.println(vendingMachineAsText);
            // force PrintWriter to write line to the file
            out.flush();

        }
        // Clean up
        out.close();
    }









}
