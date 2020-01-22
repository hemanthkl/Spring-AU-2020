package exception_using_wrapperlambda;
import java.util.function.Consumer;
public class Main {
    static Consumer<Integer> handleException(Consumer<Integer> consumer) {
        return value -> {
            try {
                consumer.accept(value);
            } catch (ArithmeticException err) {
                System.err.println("Exception : " + err.getMessage());
            }
        };
    }
    private void printConsumer(Integer value, Consumer<Integer> consumer) {
        consumer.accept(value);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.printConsumer(5, handleException(value -> System.out.println(50 / value)));
        main.printConsumer(0, handleException(value -> System.out.println(50 / value)));
    }
}