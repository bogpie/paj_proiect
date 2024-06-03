package exceptions;

public class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super("Login failed: " + message);
    }
}
