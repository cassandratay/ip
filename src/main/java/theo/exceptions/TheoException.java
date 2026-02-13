package theo.exceptions;

public class TheoException extends RuntimeException {

    public TheoException(String message) {
        super("ERROR: " + message);
    }

}
