import java.util.function.Predicate;

public class PredicateDemo implements Predicate<String> {
    @Override
    public boolean test(String string) {
        return string==null||string.isEmpty();
    }
}
