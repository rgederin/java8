package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SimpleStreams {
	private static String[] array = { "Java", "C#", "Scala", "Basic", "C++",
			"Ruby", "Pyton", "Perl", "Haskell", "Jet" };

	private static List<String> list = Arrays.asList(array);

	public static void main(String[] args) {
		
		Stream<Integer> stream = Stream.of(1,2,3,4);
		Stream<String> stream1 = Stream.generate(() -> {return "abc";});
		Stream<String> stream2 = Stream.iterate("abc", (i) -> i);
		LongStream is = Arrays.stream(new long[]{1,2,3,4});
		IntStream is2 = "abc".chars();

		/**
		 * Loop down the words and print each on a separate line, with two
		 * spaces in front of each word.
		 */
		list.stream().map(e -> "  " + e).forEach(System.out::println);
		System.out.println();

		/**
		 * map
		 */
		list.stream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println();

		list.stream().map(e -> e + " language").forEach(System.out::println);
		System.out.println();

		/**
		 * filter
		 */
		list.stream().filter(e -> e.length() % 2 == 0)
				.forEach(System.out::println);
		System.out.println();

		/**
		 * Turn the strings into uppercase, keep only the ones that are shorter
		 * than 4 characters, of what is remaining, keep only the ones that
		 * contain “A”, and print the first result
		 */
		String s = list.stream().map(String::toUpperCase)
				.filter(e -> e.length() >= 3).filter(e -> e.contains("A"))
				.findFirst().get();
		System.out.println(s);
		
		/**
		 * sorted - We can use sorted() to sort the stream elements by passing Comparator argument. 
		 */
		Stream<String> names2 = Stream.of("aBc", "d", "ef", "123456");
		List<String> reverseSorted = names2.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted); // [ef, d, aBc, 123456] 
		
		Stream<String> names3 = Stream.of("aBc", "d", "ef", "123456");
		List<String> naturalSorted = names3.sorted().collect(Collectors.toList());
		System.out.println(naturalSorted); //[123456, aBc, d, ef]
		
		/**
		 * flatMap() example: We can use flatMap() to create a stream from the stream of list. Let’s see a simple example to clear this doubt
		 */
		System.out.println();
		Stream<List<String>> namesOriginalList = Stream.of(    Arrays.asList("Pankaj"),     Arrays.asList("David", "Lisa"),    Arrays.asList("Amit"));
		//flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList.flatMap(strList -> strList.stream()); 
		flatStream.forEach(System.out::println);
		
		
	}

	/**
	 * find out sum of all the integers greater than 10
	 */
	private static int sumStream(List<Integer> list) {
		return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
	}
}
