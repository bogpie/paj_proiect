package exceptions;

public class NoUserFoundException extends Exception{
    public NoUserFoundException(String message) {
        super("User not found: " + message);
    }
}
