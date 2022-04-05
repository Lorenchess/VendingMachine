package Day1.bigdecimal.carlot.service;

public class OverpaidPriceException extends Exception{
    public OverpaidPriceException(String message) {
        super(message);
    }

    public OverpaidPriceException(String message, Throwable cause) {
        super(message, cause);
    }
}
