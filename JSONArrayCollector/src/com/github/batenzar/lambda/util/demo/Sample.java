package com.github.batenzar.lambda.util.demo;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.github.batenzar.lambda.util.JSONArrayCollector;

public class Sample {

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");

		System.out.println("===== Starting Case 01 Stream =====");
		
		JSONArray collect1 = list.stream() //
				.collect(new JSONArrayCollector<String>());
		
		System.out.println("Result");
		for (int i = 0; i < collect1.length(); i++) {
			System.out.println(collect1.getString(i));
		}
		
		System.out.println("===== Starting Case 02 Parallel =====");
		
		JSONArray collect2 = list.parallelStream() //
				.collect(new JSONArrayCollector<String>());
		
		System.out.println("Result");
		for (int i = 0; i < collect2.length(); i++) {
			System.out.println(collect2.getString(i));
		}
	}
}
