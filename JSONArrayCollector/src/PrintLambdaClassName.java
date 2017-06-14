import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.json.JSONArray;

public class PrintLambdaClassName {

	public static void main(String[] args) {
		Supplier<JSONArray> sub = JSONArray::new;
		System.out.println("Suppiler class: " + sub.getClass().getSimpleName());
		
		Consumer<JSONArray> con = (a) -> {System.out.println(a);};
		System.out.println("Consumer class: " + con.getClass().getSimpleName());
		
		Predicate<String> predicate = (a) -> { return true;};
		System.out.println("Function class: " + predicate.getClass().getSimpleName());
		
		Function<String, String> function = (a) -> { return "hello";};
		System.out.println("Function class: " + function.getClass().getSimpleName());
		
		BiFunction<String, String, String> biFunction = (a,b) -> { return "hello";};
		System.out.println("Function class: " + biFunction.getClass().getSimpleName());
	}

}
