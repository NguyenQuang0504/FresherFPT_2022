package Servlet;

public class DataInvalidException extends RuntimeException {
    
    public DataInvalidException() {
        super();
    }
    
    public DataInvalidException(String message) {
        super(message);
    }

}
