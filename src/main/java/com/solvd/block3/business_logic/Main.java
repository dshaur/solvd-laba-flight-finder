package com.solvd.block3.business_logic;

import com.solvd.block3.ui.UiUtils;
import com.solvd.block3.xml.XmlMaker;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.block3.json.JsonMaker;
import com.solvd.block3.models.*;

public class Main {
    private static final String XML_PATH = "src/main/resources/Flights.xml";
    private static final String JSON_PATH = "src/main/resources/Flights.json";
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Welcome to the flight finder. Please input an origin city.");

        City origin = UiUtils.selectCity();
        LOGGER.info("Selected origin city: " + origin.getName());

        LOGGER.info("Now input a destination.");
        City destination = UiUtils.selectCity();
        LOGGER.info("Selected destination city: " + destination.getName());

        String mode = UiUtils.getMode();

        if (mode.equalsIgnoreCase("s"))
        {
            LOGGER.info("The shortest path is a direct one. Getting info...");
            Flight shortest = UiUtils.findShortestFlight(origin, destination);

            LOGGER.info("Information about the flight:");
            LOGGER.info(shortest);
            XmlMaker.makeXml(XML_PATH, shortest);
            JsonMaker.makeJson(JSON_PATH, shortest);
        }

        else if (mode.equalsIgnoreCase("c"))
        {
            LOGGER.info("Finding cheapest path...");
            List<Flight> flightsOfCheapest = UiUtils.findCheapestPathFlights(origin, destination);

            LOGGER.info("Flights to get to " + destination.getName() + " from " + origin.getName());
            flightsOfCheapest.forEach(flight ->
            {
                LOGGER.info(flight);
                XmlMaker.makeXml(XML_PATH, flight);
                JsonMaker.makeJson(JSON_PATH, flight);
            });
        }
    }
}
