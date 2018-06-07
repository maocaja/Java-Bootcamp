package com.mcajamarca.figuras;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {

	
	public static void main(String[] args) {
		
		List<Integer> counts = Arrays.asList(1, 2, 3);
		Stream<Integer> asStream = counts.stream();
		asStream.forEach(x-> System.out.print(x * 2));
		asStream.forEach(System.out::print);
		
	}
}
