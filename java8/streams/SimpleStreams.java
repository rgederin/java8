package java8.streams;

import java.util.Arrays;
import java.util.List;

public class SimpleStreams {
	private static String[] array = { "Java", "C#", "Scala", "Basic", "C++",
			"Ruby", "Pyton", "Perl", "Haskell", "Jet" };

	private static List<String> list = Arrays.asList(array);

	public static void main(String[] args) {

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
		 * filer
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
		
		
	}
}
