import java.time.ZonedDateTime;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        PredicateDemo predicateDemo = new PredicateDemo();
        System.out.println(predicateDemo.test(""));;

        Predicate<String> predicate = string -> string==null;
        Predicate<String> predicate1 = string -> string.isEmpty();
        System.out.println(predicate1.or(predicate).test("aa"));

        System.out.println(ZonedDateTime.now());
    }
}
