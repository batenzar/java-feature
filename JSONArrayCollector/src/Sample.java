import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.github.batenzar.lambdautil.JSONArrayCollector;

public class Sample {

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");

		JSONArray collect = list.stream() //
				.filter(a -> a.equals("B")) //
				.collect(new JSONArrayCollector<String>());
		
		System.out.println("Result");
		for (int i = 0; i <= collect.length(); i++) {
			System.out.println(collect.get(i));
		}
	}
}
