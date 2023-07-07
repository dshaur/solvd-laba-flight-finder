package com.solvd.block3.ui;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.block3.json.JsonMaker;
import com.solvd.block3.models.Airport;
import com.solvd.block3.models.City;
import com.solvd.block3.models.Flight;
import com.solvd.block3.services.AirportServiceMyBatis;
import com.solvd.block3.services.CityServiceMyBatis;
import com.solvd.block3.services.FlightServiceMyBatis;
import com.solvd.block3.xml.XmlMaker;

public class UiUtils 
{    
    private static final String XML_PATH = "src/main/resources/Flights.xml";
    private static final String JSON_PATH = "src/main/resources/Flights.json";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(UiUtils.class);
    private static final CityServiceMyBatis CITY_SERVICE = new CityServiceMyBatis();
    private static final AirportServiceMyBatis AIRPORT_SERVICE = new AirportServiceMyBatis();
    private static final FlightServiceMyBatis FLIGHT_SERVICE = new FlightServiceMyBatis();

    public static String getMode()
    {
        LOGGER.info("Enter 'c' for cheapest route, 's' for shortest route.");
        String mode = SCANNER.nextLine();

        while (true)
        {
            if (mode.equalsIgnoreCase("c") || mode.equalsIgnoreCase("s"))
            {
                return mode;
            }

            else
            {
                LOGGER.error("Invalid input.");
                LOGGER.info("Enter 'c' for cheapest route, 's' for shortest route.");
                mode = SCANNER.nextLine();
            }
        }
    }

    public static City makeCity()
    {
        String name = SCANNER.nextLine();
        City ret = CITY_SERVICE.getCityByName(name);

        while (ret == null)
        {
            LOGGER.error("City doesn't exist in database. Please try again.");
            name = SCANNER.nextLine();
            ret = CITY_SERVICE.getCityByName(name);
        }

        return ret;
    }

    public static void makeShortestRoute(City source, City dest)
    {
        LOGGER.info("Getting data...");
        Airport sourceAirport = AIRPORT_SERVICE.getAirportByCity(source);
        Airport destAirport = AIRPORT_SERVICE.getAirportByCity(dest);
        ArrayList<Flight> sourceFlights = FLIGHT_SERVICE.getFlightBySourceAirport(sourceAirport.getAirportId());
        ArrayList<Flight> commonFlights = new ArrayList<Flight>();

        sourceFlights.forEach(flight -> 
        {   
            if (flight.getDestinationAirport().equals(destAirport))
            {
                commonFlights.add(flight);
            }
        });

        LOGGER.info("The shortest route between " + source.getName() + " and " + dest.getName() + " is a direct route.");
        LOGGER.info("Here is a list of directions.");
        commonFlights.forEach(flight -> 
        {   
            LOGGER.info("Start at " + 
            flight.getSourceAirport().getName() + 
            " and use " + 
            flight.getAirline().getName() +
            " to get to " +
            flight.getDestinationAirport().getName());
            
            XmlMaker.makeXml(XML_PATH, flight);
            JsonMaker.makeJson(JSON_PATH, flight);
        });
    }
}
