package java8.date;

import java.time.Duration;
import java.time.Instant;

/**
 * java.time.Instant: Instant class is used to work with machine readable time
 * format, it stores date time in unix timestamp.
 * 
 * @author Ruslan
 *
 */
public class InstantExample {
	public static void main(String[] args) {
		// Current timestamp
		Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = " + timestamp);

		// Instant from timestamp
		Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time = " + specificTime);

		// Duration example
		Duration thirtyDay = Duration.ofDays(30);
		System.out.println(thirtyDay.toDays());
	}
}
