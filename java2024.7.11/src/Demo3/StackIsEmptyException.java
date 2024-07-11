package Demo3;

public class StackIsEmptyException extends RuntimeException {
    public StackIsEmptyException() {
    }

    public StackIsEmptyException(String message) {
        super(message);
    }
}
