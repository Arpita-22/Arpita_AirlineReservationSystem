package org.arpita.airlinereservationsystem.data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Class to generate flight data randomly
 */
public class GenerateFlightsData {

	static String insert = "INSERT INTO `flights` (`id`, `arrivalDate`, `departureDate`, `destination`, `flightNumber`, `source`, `arrivalTime`, `departureTime`, `price`, `departureCityName`, `arrivalCityName`) "
			+ "VALUES";
	static String query = "(%d, '%s', '%s', '%s', %d, '%s', '%s', '%s', %.2f, '%s', '%s'),";
	static String[] air = new String[] { "ATL", "LAX", "ORD", "DFW", "DEN", "JFK", "SFO", "SEA", "LAS", "MCO", "EWR",
			"CLT", "PHX", "IAH", "MIA", "BOS", "MSP", "FLL", "DTW", "PHL", "LGA", "BWI", "SLC", "SAN", "IAD", "DCA",
			"MDW", "TPA", "PDX", "HNL" };

	static String[] airPlace = new String[] { "Atlanta", "Los Angeles", "Chicago", "Dallas", "Denver", "New York",
			"San Francisco", "Seattle", "Las Vegas", "Orlando", "Newark", "Charlotte", "Phoenix", "Houston", "Miami",
			"Boston", "Minneapolis", "Florida", "Detroit", "Philadelphia", "LaGuardia", "Baltimore", "Salt Lake City",
			"San Diego", "Virginia", "Arlington", "Chicago Illinois", "Tampa Florida", "Portland", "Hawaii" };

	public static void main(String[] args) {

		System.out.println(insert);
		for (int i = 1; i <= 10000;) {
			LocalDate startInclusive = LocalDate.of(2021, 8, 30);
			LocalDate endExclusive = LocalDate.of(2021, 9, 10);
			long startEpochDay = startInclusive.toEpochDay();
			long endEpochDay = endExclusive.toEpochDay();

			long randomStartDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

			int originIn = (int) (Math.random() * (air.length));
			int destIn = (int) (Math.random() * (air.length));

			if (originIn != destIn) {

				System.out
						.println(String.format(query, i, LocalDate.ofEpochDay(randomStartDay).plus(1, ChronoUnit.DAYS),
								LocalDate.ofEpochDay(randomStartDay), air[originIn],
								(int) Math.floor(Math.random() * (1000 - 100 + 1) + 100), air[destIn],
								time(23) + ":" + time(60), time(23) + ":" + time(60),
								(float) (Math.floor((Math.random() * (1000 - 50 + 1)) + 50)), airPlace[destIn],
								airPlace[originIn]));
				i++;
			}
		}
	}

	static String time(int k) {
		int h = (int) Math.floor(Math.random() * k);
		if (h < 10) {
			return "0" + h;
		}
		return "" + h;
	}

}