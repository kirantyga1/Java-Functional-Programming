package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Programs {

	public static void main(String[] args) {

		// IntStream total = IntStream.rangeClosed(0, 3).map(Integer::new).sorted();
		// System.out.println(total.sorted());

		// List<String> names = Arrays.asList("Abhijeeth", "Don", "kiran", "Alekya",
		// "Adam", "Ram");

		// List<String> uniqueList =
		// names.stream().distinct().collect(Collectors.toList());
		// System.out.println(uniqueList);

		Long uniqueList2 = Stream.of("Abhijeeth", "Don", "kiran", "Alekya", "Adam", "Ram").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();
		List<String> uniqueList3 = Stream.of("Abhijeeth", "Don", "kiran", "Alekya", "Adam", "Ram")
				.filter(s -> s.startsWith("A")).collect(Collectors.toList());

		// Print Method-1
		List<String> uniqueList4 = Stream.of("kiran", "Alekya", "Abhijeeth", "Don", "Adam", "Ram")
				.filter(s -> s.length() >= 4).collect(Collectors.toList());
		System.out.println("-------------------------------------------");
		System.out.println(uniqueList4 /* + "" + uniqueList3 */);

		// Print Method-2
		Stream.of("Abhijeeth", "Don", "kiran", "Alekya", "Adam", "Ram").filter(s -> s.length() >= 4)
				.forEach(s -> System.out.println(s));

		System.out.println("-------------------------------------------");

		Stream.of("Maheshwari", "kiran", "Abhijeeth", "Don", "Adam", "Ram").filter(s -> s.length() >= 4).limit(1)
				.forEach(s -> System.out.println(s));
		System.out.println("-------------------------------------------");

		Stream.of("Maheshwari", "kiran", "Abhijeeth", "Don", "Adam", "Ram").filter(s -> s.endsWith("n"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("-------------------------------------------");

		Stream.of("Maheshwari", "kiran", "Abhijeeth", "Don", "Adam", "Ram").filter(s -> s.endsWith("n"))
				.forEach(s -> System.out.println(s));

		System.out.println("-------------------------------------------");

		// Merging 2 different lists
		List<String> stream1 = Arrays.asList("Kameshwar", "Subash", "Smith", "Miller", "Suresh", "Sai");
		List<String> stream2 = Arrays.asList("Mark", "Ponting", "Kohli", "Billings", "Dhoni", "Rahul");

		System.out.println("----------------Merged streams---------------------------");

		Stream.concat(stream1.stream(), stream2.stream()).sorted().forEach(s -> System.out.println(s));
		System.out.println("----------------Matching in streams---------------------------");
		boolean flag = stream1.stream().anyMatch(s -> s.equalsIgnoreCase("Miller"));
		System.out.println(flag);

		System.out.println("----------------Print unique numbers from Integer array---------------------------");

		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 1, 3, 4, 5);
		List<Integer> result = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(result);

		// Integer Stream
		System.out.println("----------------Integer Stream--------------------------");
		// IntStream.range(1, 10).skip(5).forEach(x->System.out.println(x));
		System.out.println(IntStream.range(1, 3).sum());

		System.out.println("----------------String  Stream Filtering--------------------------");

		List<String> tags = Arrays.asList("Hello", "Welcome", "To", "Java8World", "Hi","Hai");

		tags.stream().map(x -> x.toLowerCase()).filter(x -> x.startsWith("h")).sorted().forEach(x -> System.out.println(x));

	}
}
