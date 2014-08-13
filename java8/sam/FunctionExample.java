package java8.sam;

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
}
