package java8.sam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Using Function interface
 * 
 * @author rgederin
 *
 */
public class FunctionExample {
	/**
	 * Java 7 style
	 */
	public static int salarySum(List<Employee> employees) {
		int sum = 0;
		for (Employee employee : employees) {
			sum += employee.getSalary();
		}
		return (sum);
	}

	/**
	 * Java 8 style You can reproduce salarySum via 
	 * mapSum(employees, Employee::getSalary). 
	 * But, now you can also do many other types of sums:
	 * int sumOfIds = mapSum(employees, Employee::getEmployeeId);
	 * int sumOfSalariesAndIds = mapSum(employees, e -> e.getSalary() + e.getEmployeeId()); 
	 * int totalFleetPrice = mapSum(listOfCars, Car::getStickerPrice); 
	 * int regionPopulation = mapSum(listOfCountries, Country::getPopulation); 
	 * int regionElderlyPopulation = mapSum(listOfCountries, c -> c.getPopulation() – c.getPopulationUnderSixty()); 
	 * int sumOfNumbers = mapSum(listOfIntegers, Function.identity());
	 */
	public static <T> int mapSum(List<T> entries, Function<T, Integer> mapper) {
		int sum = 0;
		for (T entry : entries) {
			sum += mapper.apply(entry);
		}
		return (sum);
	}
	
	/**
	 * Static method called transformedList.It should take a List of Strings and
	 * a Function<String,String> and return a new List that contains the results
	 * of applying the Function to each element of the original List
	 * 
	 */
	public static List<String> transformedList(List<String> candidates,
			Function<String, String> function) {
		List<String> list = new ArrayList<>();
		for (String string : candidates) {
			list.add(function.apply(string));
		}
		return list;
	}
	
	/**
	 * Generic version of above method
	 */
	public static <T> List<T> transformedListGeneric (List<T> candidates, Function<T, T> function){
		List <T> list = new ArrayList<>();
		for (T t : candidates){
			list.add(function.apply(t));
		}
		
		return list;
	}
	

	public static void main(String[] args) {
		String[] array = { "Java", "C#", "Scala", "Basic", "C++", "Ruby",
				"Pyton", "Perl", "Haskell", "Jet" };
		List<String> results;

		results = transformedList(Arrays.asList(array), s -> s + "!");
		results.forEach(System.out::println);
		System.out.println();
		results = transformedList(Arrays.asList(array), String::toUpperCase);
		results.forEach(System.out::println);
	}
}
