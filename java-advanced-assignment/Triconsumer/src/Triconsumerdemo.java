public class Triconsumerdemo {
    
    public static void main(String[] args) {
        Triconsumerdemo tconsumer = new Triconsumerdemo();
        tconsumer.print("Hemanth", 0, true, (str, in, bool) -> System.out.println(str + " " + in + " " + bool));
    }
	private void print(String str, Integer in, Boolean bool, TriConsumer<String, Integer, Boolean> consumer) {
        consumer.accept(str, in, bool);
    }
}

@FunctionalInterface
interface TriConsumer<A, B, C> {
    void accept(A a, B b, C c);
}