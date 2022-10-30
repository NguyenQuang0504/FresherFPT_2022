package exception;

public class InvalidDOBException extends Exception{
    public InvalidDOBException() {
    }

    public InvalidDOBException(String message) {
        super(message);
    }

    public InvalidDOBException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDOBException(Throwable cause) {
        super(cause);
    }

    public InvalidDOBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
