package com.solvd.block3.business_logic;

import com.solvd.block3.json.JsonMaker;
import com.solvd.block3.models.City;
import com.solvd.block3.models.Flight;
import com.solvd.block3.models.FlightList;
import com.solvd.block3.ui.UiUtils;
import com.solvd.block3.xml.XmlMaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

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

        while (origin.getName().equals(destination.getName())) {
            LOGGER.info("Cities are the same. Please use a city that is not " + origin.getName());
            destination = UiUtils.selectCity();
        }

        String mode = UiUtils.getMode();
        List<Flight> path;

        if (mode.equalsIgnoreCase("s")) {
            LOGGER.info("Finding shortest flight route...");
            path = UiUtils.findBestFlights(origin, destination, true);

        } 
        else {
            LOGGER.info("Finding cheapest flight route...");
            path = UiUtils.findBestFlights(origin, destination, false);
        }

        UiUtils.printFlightDirections(path);

        FlightList list = new FlightList(path);
        XmlMaker.makeXml(XML_PATH, list);
        JsonMaker.makeJson(JSON_PATH, list);
    }
}
