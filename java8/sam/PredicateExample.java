package java8.sam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Using Predicate in Java 8
 * 
 * @author rgederin
 *
 */
public class PredicateExample {
	/**
	 * Java 7 style
	 */
	public static Employee findEmployeeByFirstName(List<Employee> employees,
			String firstName) {
		for (Employee e : employees) {
			if (e.getFirstName().equals(firstName)) {
				return (e);
			}
		}
		return (null);
	}

	/**
	 * Java 7 style
	 */
	public static Employee findEmployeeBySalary(List<Employee> employees,
			double salaryCutoff) {
		for (Employee e : employees) {
			if (e.getSalary() >= salaryCutoff) {
				return (e);
			}
		}
		return (null);
	}

	/**
	 * Java 7 style
	 */
	public static Employee findEmployeeById(List<Employee> employees, int id) {
		for (Employee e : employees) {
			if (e.getEmployeeId() == id) {
				return (e);
			}
		}
		return (null);
	}

	/**
	 * Java 8 style. We can now pass in different match functions to search on
	 * different criteria. Succinct and readable:
	 * 
	 * firstMatchingEmployee(employees, e -> e.getSalary() > 500000);
	 * firstMatchingEmployee(employees, e -> e.getLastName().equals("…"));
	 * firstMatchingEmployee(employees, e -> e.getId() < 10);
	 */
	public static Employee firstMatchingEmployee(List<Employee> candidates,
			Predicate<Employee> matchFunction) {
		for (Employee possibleMatch : candidates) {
			if (matchFunction.test(possibleMatch)) {
				return (possibleMatch);
			}
		}
		return (null);
	}

	/**
	 * Java 8 style. More general approach
	 */
	public static <T> T firstMatch(List<T> candidates,
			Predicate<T> matchFunction) {
		for (T possibleMatch : candidates) {
			if (matchFunction.test(possibleMatch)) {
				return (possibleMatch);
			}
		}
		return (null);
	}

	/**
	 * Java 8 style: Static method called allMatches. It should take a List of
	 * Strings and a Predicate<String>, and return a new List of all the values
	 * that passed the test. Several test examples:
	 * 
	 * List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
	 * List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
	 * List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);
	 */
	public static List<String> allMatches(List<String> candidates,
			Predicate<String> predicate) {
		List<String> list = new ArrayList<String>();
		for (String string : candidates) {
			if (predicate.test(string)) {
				list.add(string);
			}
		}
		return list;
	}
	
	/**
	 * Java 8 style General version of previous method
	 */
	public static <T> List<T> allMatchesGeneric (List<T> candidates, Predicate<T> predicate){
		List<T> list = new ArrayList<T>();
		for (T t : candidates){
			if (predicate.test(t)){
				list.add(t);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		String[] array = { "Java", "C#", "Scala", "Basic", "C++", "Ruby",
				"Pyton", "Perl", "Haskell", "Jet" };
		List<String> results;
		results = allMatches(Arrays.asList(array), s -> s.length() < 4);
		results.forEach(System.out::println);
		System.out.println();
		results = allMatches(Arrays.asList(array), s -> s.contains("b") || s.contains("B"));
		results.forEach(System.out::println);
		System.out.println();
		results = allMatchesGeneric(Arrays.asList(array), s -> s.contains("b") || s.contains("B"));
		results.forEach(System.out::println);
	}
}
