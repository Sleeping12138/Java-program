package Demo1;

public class ElementIsEmptyException extends RuntimeException {
    public ElementIsEmptyException() {
    }

    public ElementIsEmptyException(String message) {
        super(message);
    }
}
