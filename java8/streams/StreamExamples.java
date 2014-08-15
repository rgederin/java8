package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import java8.sam.Employee;

public class StreamExamples {

	public static void main(String[] args) {
		/**
		 * forEach - Easy way to loop over Stream elements. You supply a lambda
		 * to forEach, and that lambda is called on each element of the Stream
		 */
		googlers().forEach(System.out::println);
		System.out.println();

		googlers().forEach(e -> e.setSalary(e.getSalary() * 11 / 10));
		googlers().forEach(System.out::println);
		System.out.println();

		/**
		 * map - Produces a new Stream that is the result of applying a Function
		 * to each element of original Stream
		 */
		Double[] nums = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		Double[] squares = Stream.of(nums).map(n -> n * n)
				.toArray(Double[]::new);
		Stream.of(squares).forEach(System.out::println);

		System.out.println();
		Stream.of(squares).map(Math::sqrt).forEach(System.out::println);
		Stream.of(nums).map(n -> n * n).map(Math::sqrt)
				.forEach(System.out::println);

		/**
		 * filter – Keeping Only the Elements that Pass a Predicate. Produces a
		 * new Stream that contain only the elements of the original Stream that
		 * pass a given test
		 */

		Integer[] intNums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// evens number greater than 3
		Stream.of(intNums).filter(n -> n % 2 == 0).filter(n -> n > 3)
				.forEach(System.out::println);

		/**
		 * findFirst – Returning the First Element of a Stream while
		 * Short-Circuiting Earlier Operations. Optional either stores a T or
		 * stores nothing. Useful for methods that may or may not find a value.
		 * New in Java 8.
		 */
		
		@SuppressWarnings("unused")
		Employee emp = googlers().filter(e -> e.getSalary() > 800000 && e.getSalary() < 8888888).findFirst().get();
	}

	private static Employee[] googlers = {
			new Employee("Larry", "Page", 1, 9999999),
			new Employee("Sergey", "Brin", 2, 8888888),
			new Employee("Eric", "Schmidt", 3, 7777777),
			new Employee("Nikesh", "Arora", 4, 6666666),
			new Employee("David", "Drummond", 5, 5555555),
			new Employee("Patrick", "Pichette", 6, 4444444),
			new Employee("Susan", "Wojcicki", 7, 3333333),
			new Employee("Peter", "Norvig", 8, 900000),
			new Employee("Jeffrey", "Dean", 9, 800000),
			new Employee("Sanjay", "Ghemawat", 10, 700000),
			new Employee("Gilad", "Bracha", 11, 600000) };

	public static List<Employee> getGooglers() {
		return (Arrays.asList(googlers));
	}

	private static Stream<Employee> googlers() {
		return (getGooglers().stream());
	}
}
