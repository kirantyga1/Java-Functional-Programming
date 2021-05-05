package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsPractice {

	public static void main(String[] args) throws IOException {

		// 1. Integer Stream
		IntStream.range(1, 10).forEach(x -> System.out.println(x));

		System.out.println("---------------------------");
		// 2. Integer Stream with skip
		IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));

		System.out.println("---------------------------");
		// 3. Integer Stream with sum
		System.out.println(IntStream.range(1, 5).sum());

		System.out.println("---------------------------");
		// 4. Stream.of sorted and find first
		System.out.println(Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst());

		System.out.println("---------------------------");
		// 5. Stream from Array sort, filter and print
		String[] names = { "Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah" };
		Arrays.stream(names).filter(x -> x.startsWith("S")).sorted().forEach(x -> System.out.println(x));

		System.out.println("---------------------------");
		// 6. Average of squares of an Int Array
		System.out.println(Arrays.stream(new int[] { 1, 2, 3, 4 }).map(x -> x * x).average());

		System.out.println("---------------------------");
		// 7. Stream from List, filter and print
		List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika",
				"Sarah");
		people.stream().map(x -> x.toLowerCase()).filter(x -> x.startsWith("a")).forEach(x -> System.out.println(x));

		System.out.println("---------------------------");
		// 8. Stream rows from text file, sort, filter and print
		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
		bands.sorted().filter(x -> x.length() > 13).forEach(x -> System.out.println(x));
		bands.close();

		System.out.println("---------------------------");
		// 9. Stream rows from text file and save to List
		List<String> bands2 = Files.lines(Paths.get("bands.txt")).filter(x -> x.contains("ing"))
				.collect(Collectors.toList());
		bands2.forEach(x -> System.out.println(x));
		bands.close();

		System.out.println("---------------------------");
		// 10. Stream rows from csv file and count
		Stream<String> rows = Files.lines(Paths.get("data.txt"));
		int rowCount = (int) rows.map(x -> x.split(",")).filter(x -> x.length == 3).count();
		System.out.println(rowCount);
		rows.close();

		System.out.println("---------------------------");
		// 11. Stream rows from csv file, parse data from rows
		Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
		rows2.map(x -> x.split(","))
			 .filter(x -> x.length == 4)
			 .filter(x -> Integer.parseInt(x[2]) > 15)
			 .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2] + " " + x[3]));
			   rows2.close();
			   
		System.out.println("---------------------------");
		// 12. Stream rows from csv file,store fields in HashMap
		Map<String, Integer> map = new HashMap<>();
		Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
		map=rows3.map(x -> x.split(","))
					 .filter(x -> x.length == 4)
					 .filter(x -> Integer.parseInt(x[1]) > 15)
					 .collect(Collectors.toMap(x->x[0], x->Integer.parseInt(x[1])));
					 rows3.close();
					 
				for(String key : map.keySet()) {
					System.out.println(key + " " +map.get(key));
				}
		
				// 13. Reduction - sum
				double total = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> a + b);
				System.out.println("Total = " + total);

				// 14. Reduction - summary statistics
				IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();
				System.out.println(summary);
			   
	}
}
