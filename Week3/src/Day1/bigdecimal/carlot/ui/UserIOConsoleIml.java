package Day1.bigdecimal.carlot.ui;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserIOConsoleIml implements UserIO{
    final private Scanner scanner = new Scanner(System.in);

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }


    @Override
    public BigDecimal readBigDecimal(String msgPrompt) {
        boolean isInvalid = true;
        BigDecimal userInputNum = null;
        while(isInvalid) {
            try{
                String stringInput = readString(msgPrompt);
                userInputNum = BigDecimal.valueOf(Long.parseLong(stringInput));
                isInvalid = false;
            }catch(NumberFormatException e) {
                print("Invalid input for number. Please try again!");
            }
        }
        return userInputNum;
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public int readInt(String msgPrompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                String stringValue = this.readString(msgPrompt);
                num = Integer.parseInt(stringValue);
                invalidInput = false;
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }

    @Override
    public int readInt(String msgPrompt, int min, int max) {
        int result;
        do {
            result = readInt(msgPrompt);
        } while (result < min || result > max);

        return result;
    }
}
