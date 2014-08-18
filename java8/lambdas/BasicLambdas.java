package java8.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

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

		System.out.println();
		Runnable r1 = () -> System.out.println("My Runnable");
		new Thread(r1).start();
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

	private static boolean isPrime(int number) {
		IntPredicate isDivisible = index -> number % index == 0;
		return number > 1
				&& IntStream.range(2, number - 1).noneMatch(isDivisible);
	}

	/**
	 * //sum of all numbers
	 * sumWithCondition(numbers, n -> true)
	 * //sum of all even
	 * numberssumWithCondition(numbers, i -> i%2==0)
	 * //sum of all numbers greater
	 * than 5sumWithCondition(numbers, i -> i>5)
	 */
	public static int sumWithCondition(List<Integer> numbers,
			Predicate<Integer> predicate) {
		return numbers.parallelStream().filter(predicate).mapToInt(i -> i)
				.sum();
	}
}
