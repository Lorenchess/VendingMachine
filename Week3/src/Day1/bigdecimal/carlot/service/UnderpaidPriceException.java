package Day1.bigdecimal.carlot.service;

public class UnderpaidPriceException extends Exception{
    public UnderpaidPriceException(String message) {
        super(message);
    }

    public UnderpaidPriceException(String message, Throwable cause) {
        super(message, cause);
    }
}
