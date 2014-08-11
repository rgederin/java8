package java8.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Simple comparison between Java 7 and Java 8
 * @author Ruslan Gederin
 *
 */
public class Java7VSJava8 {

	private static String [] array = {"Java", "C#", "Scala", "Basic", "C++"};
	
	public static void main (String [] args){
		printSortJava8(Arrays.asList(array));
		printSortJava7(Arrays.asList(array));
	}
	
	/**
	 * Example of sorting and printing in Java 7
	 * @param list
	 */
	private static void printSortJava7(List<String> list){
		System.out
		.println("------------------------ Java 7 ----------------------");
		
		Comparator<String> lengthComparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		Collections.sort(list, lengthComparator);
		
		for (String string : list){
			System.out.println(string);
		}
	}
		
	/**
	 * Example of sorting and printing in Java 8
	 * @param list
	 */
	private static void printSortJava8(List<String> list) {
		System.out
				.println("------------------------ Java 8 ----------------------");

		list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		list.forEach(System.out::println);
	}
}
