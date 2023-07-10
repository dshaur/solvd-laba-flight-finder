package com.solvd.block3.services;

import com.solvd.block3.graphs.Graph;
import com.solvd.block3.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

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

//		FlightServiceMyBatis fs = new FlightServiceMyBatis();
//		Flight flights = fs.getFlight(1);
//		LOGGER.info(flights);




//		Graph graph = new Graph();
//
//		graph.addEdge(1, 2, 5.0);
//		graph.addEdge(1, 3, 2.0);
//		graph.addEdge(2, 3, 1.0);
//		graph.addEdge(2, 4, 6.0);
//		graph.addEdge(3, 4, 3.0);
//		graph.addEdge(3, 5, 8.0);
//		graph.addEdge(4, 5, 4.0);
//
//
//
//		List<Integer> shortestPath = graph.shortestPath(1, 5);
//
//		if (shortestPath.isEmpty()) {
//			LOGGER.info("There is no path from source to destination.");
//		} else {
//			LOGGER.info(shortestPath);
//		}

		FlightServiceMyBatis fs = new FlightServiceMyBatis();
		List<Integer> flights = fs.findShortestPath(2, 6);
		LOGGER.info(flights);
	}
}
