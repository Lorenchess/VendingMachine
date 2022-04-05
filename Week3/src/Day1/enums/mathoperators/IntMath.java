package Day1.enums.mathoperators;

import java.util.Scanner;

public class IntMath {
        static Scanner sc = new Scanner(System.in);
        public int calculate(MathOperator operator, int operand1, int operand2) {
            switch (operator) {
                case PLUS:
                    return operand1 + operand2;
                case MINUS:
                    return operand1 - operand2;
                case MULTIPLY:
                    return operand1 * operand2;
                case DIVIDE:
                    return operand1 / operand2;
                default:
                    throw new UnsupportedOperationException();
            }
        }
        public int getUserInput(String prompt) {
            int userInput = 0;
            try {
                printMsg(prompt);
                userInput = Integer.parseInt(sc.nextLine());

            }catch (Exception e){
                printMsg("Invalid input for number" + e);
            }
            return userInput;
        }

        public void printMsg(String msg) {
            System.out.println(msg);
        }

        public  MathOperator getMathOperator(String prompt) {
            String userInputOperator = null;
            try {
                printMsg(prompt);
                userInputOperator = sc.nextLine();
                userInputOperator = userInputOperator.toUpperCase();

            }catch (Exception e){
                printMsg("Invalid input " + e);
            }
            return MathOperator.valueOf(userInputOperator);
        }

        public void printResults(MathOperator userOperator, int firstOperand, int secondOperand, int result) {
            System.out.println("The result of "+ firstOperand + " "+ userOperator+ " " + secondOperand+ " is "+result);
            sc.close();
        }













}
