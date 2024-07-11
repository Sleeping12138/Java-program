package Demo2;

public class StackIsEmptyException extends RuntimeException {
    public StackIsEmptyException() {
    }

    public StackIsEmptyException(String message) {
        super(message);
    }
}
