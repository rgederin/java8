package java8.lambdas;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Method referencerces and functional interfaces examples
 * 
 * @author rgederin
 *
 */
public class BasicMethodRefernces {
	private static String[] array = { "Java", "C#", "Scala", "Basic", "C++",
			"Ruby", "Pyton", "Perl", "Haskell", "Jet" };

	public static void main(String[] args) {
		System.out
				.println("\nStrings that contain “e” first, everything else second (with method references): ");
		Arrays.sort(array, StringUtils::eChecker);
		Arrays.asList(array).forEach(System.out::println);

		StringUtils.betterString("String 1", "String 222", (s1, s2) -> true);
		StringUtils.betterString("String 1", "String 222",
				(s1, s2) -> s1.length() > s2.length());

	}
}

class StringUtils {

	/**
	 * Method for showing how to use method references
	 */
	public static int eChecker(String s1, String s2) {
		if (s1.contains("e") && s2.contains("e")) {
			return 0;
		} else if (s1.contains("e")) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * Method for showing how to use functional interface
	 */
	public static void betterString(String s1, String s2,
			TwoStringPredicate predicate) {
		if (predicate.isBetter(s1, s2)) {
			System.out.println("\nFirst string is better than second");
		} else {
			System.out.println("\nSecond string is better than second");
		}
	}
}

/**
 * Simple functional interface
 * 
 * @author rgederin
 *
 */
@FunctionalInterface
interface TwoStringPredicate {
	boolean isBetter(String s1, String s2);
}
