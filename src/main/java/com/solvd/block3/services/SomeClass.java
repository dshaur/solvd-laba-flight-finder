package com.solvd.block3.services;

import com.solvd.block3.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class SomeClass {
	private static final Logger LOGGER = LogManager.getLogger(SomeClass.class);
	public static void main(String[] args) {
		CountryServiceMyBatis cs = new CountryServiceMyBatis();
		ArrayList<Country> c = cs.getCountries();
		LOGGER.info(c);

		CityServiceMyBatis ci = new CityServiceMyBatis();
		City city = ci.getCity(4);
		LOGGER.info(city);

		AirportServiceMyBatis as = new AirportServiceMyBatis();
		Airport airport = as.getAirport(4);
		LOGGER.info(airport);

		AirlineServiceMyBatis asl = new AirlineServiceMyBatis();
		Airline airline = asl.getAirline(2);
		LOGGER.info(airline);

		FlightServiceMyBatis fs = new FlightServiceMyBatis();
		Flight flights = fs.getFlight(1);
		LOGGER.info(flights);
	}
}
