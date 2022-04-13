package Day4.DVDLibrary.ui;

import java.util.Scanner;

public class UserIOConsoleImpl  implements UserIO{
    final private Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param prompt message to user to get input
     * @param min  minimum number from the user menu
     * @param max  maximum number from the user menu
     * @return user input number after being checked in range
     */
    @Override
    public int readInt(String prompt, int min, int max) {
        int userInput = 0;
        boolean inNotInRange = true;
        while(inNotInRange){
            userInput = readInt(prompt);
            if (userInput >= min && userInput <= max) {
                inNotInRange = false;
            }
        }
        return userInput;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    /**
     * Method that shows message until the user enters a valid value for number
     * @param prompt message to user to get input
     * @return user input validated
     */

    @Override
    public int readInt(String prompt) {
        boolean isInvalid = true;
        int userInputNum = 0;
        while(isInvalid) {
            try{
               String stringInput = readString(prompt);
                userInputNum = Integer.parseInt(stringInput);
                isInvalid = false;
            }catch(NumberFormatException e) {
                print("Invalid input for number. Please try again!");
            }
        }
        return userInputNum;
    }

    /**
     * Takes in a message and displays it in the console
     * @param msg message to be display on console
     */

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
