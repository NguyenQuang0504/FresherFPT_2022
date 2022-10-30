package exception;

import java.text.ParseException;

public class BirthDayException extends Exception {
    public BirthDayException() {
    }

    public BirthDayException(String message) {
        super(message);
    }
}
