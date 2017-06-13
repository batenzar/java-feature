package com.github.batenzar.lambdautil;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import org.json.JSONArray;

public class JSONArrayCollector<T> implements Collector<T, JSONArray, JSONArray> {

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#supplier()
	 */
	@Override
	public Supplier<JSONArray> supplier()
	{
		System.out.println("supplier");
		return (Supplier<JSONArray>)JSONArray::new;
	}

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#accumulator()
	 */
	@Override
	public BiConsumer<JSONArray, T> accumulator()
	{
		System.out.println("accumulator");
		return (a, b) -> {
			System.out.println("classa: " + a.getClass().getSimpleName() + " classb: " + b.getClass().getSimpleName());
			System.out.println("a: " + a + " b: " + b);
			a.put(b);
		};
	}

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#combiner()
	 */
	@Override
	public BinaryOperator<JSONArray> combiner()
	{
		System.out.println("combiner");
		return (a, b) -> {
			for (int i = 0; i < b.length(); i++) {
				a.put(b.get(i));
			}
			return a;
		};
	}

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#finisher()
	 */
	@Override
	public Function<JSONArray, JSONArray> finisher()
	{
		System.out.println("finisher");
		return (a) -> a;
	}

	/* (non-Javadoc)
	 * @see java.util.stream.Collector#characteristics()
	 */
	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics()
	{
		System.out.println("characteristics");
		return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
	}

}