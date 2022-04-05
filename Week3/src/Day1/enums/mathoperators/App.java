package Day1.enums.mathoperators;


public class App {

    public static void main(String[] args) {
        IntMath doMath = new IntMath();
        MathOperator userOperator = doMath.getMathOperator("Select your Operator: PLUS / MINUS / MULTIPLY / DIVIDE");
        int firstOperand = doMath.getUserInput("Type your first operand");
        int secondOperand = doMath.getUserInput("Type your second operand");
        int result = doMath.calculate(userOperator,firstOperand,secondOperand);
        doMath.printResults(userOperator, firstOperand,secondOperand,result);
    }






















}
