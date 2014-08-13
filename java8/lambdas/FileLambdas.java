package java8.lambdas;

import java.io.File;
import java.util.Arrays;

/**
 * Lambdas with files
 * @author Ruslan
 *
 */
public class FileLambdas {
	/**
	 * Get sub dir from given with lambda
	 */
	public static File[] getSubDirectories(File directory) {
		return directory.listFiles((f) -> f.isDirectory());
	}

	public static File[] getFilesWithExtension (File directory, String extension){
		return directory.listFiles((f) -> f.isFile() && f.getName().endsWith("."+extension));
	}
	public static void main(String[] args) {
		Arrays.asList(getSubDirectories(new File("C:\\"))).forEach(
				System.out::println);
		
		System.out.println();
		
		Arrays.asList(getFilesWithExtension(new File("C:\\"), "txt")).forEach(
				System.out::println);

	}
}
