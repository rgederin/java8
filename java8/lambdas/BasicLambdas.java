package java8.lambdas;

import java.util.Arrays;

/**
 * Simple lambdas examples
 * 
 * @author rgederin
 *
 */
public class BasicLambdas {
	private static String[] array = { "Java", "C#", "Scala", "Basic", "C++",
			"Ruby", "Pyton", "Perl", "Haskell", "Jet" };

	public static void main(String[] args) {
		lambdasSort();
	}
	
	/**
	 * Using lambdas for sorting
	 */
	private static void lambdasSort() {
		System.out.println("Shortest to longest: ");
		Arrays.sort(array, (s1, s2) -> s1.length() - s2.length());
		Arrays.asList(array).forEach(System.out::println);

		System.out.println("\nLongest to shortest: ");
		Arrays.sort(array, (s1, s2) -> (s2.length() - s1.length()));
		Arrays.asList(array).forEach(System.out::println);

		System.out.println("\nAlphabetically by the first character only: ");
		Arrays.sort(array, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
		Arrays.asList(array).forEach(System.out::println);

		System.out
				.println("\nStrings that contain “e” first, everything else second: ");
		Arrays.sort(array, (s1, s2) -> {
			if (s1.contains("e") && s2.contains("e")) {
				return 0;
			} else if (s1.contains("e")) {
				return -1;
			} else {
				return 1;
			}
		});
		Arrays.asList(array).forEach(System.out::println);
	
	}
}

