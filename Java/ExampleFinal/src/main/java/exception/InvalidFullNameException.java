package exception;

public class InvalidFullNameException extends Exception{
    public InvalidFullNameException() {
    }

    public InvalidFullNameException(Throwable cause) {
        super(cause);
    }

    public InvalidFullNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidFullNameException(String message) {
        super(message);
    }

}
