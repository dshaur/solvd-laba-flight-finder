package com.solvd.block3.business_logic;

import com.solvd.block3.ui.UiUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.block3.models.*;
import com.solvd.block3.ui.UiUtils;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String XML_PATH = "src/main/resources/Flights.xml";
    private static final String JSON_PATH = "src/main/resources/Flights.json";

    public static void main(String[] args) {
        LOGGER.info("Welcome to the flight finder. Please input an origin city.");

        String origin = UiUtils.selectCity();
        LOGGER.info("Selected origin city: " + origin);

        LOGGER.info("Now input a destination.");
        String destination = UiUtils.selectCity();
        LOGGER.info("Selected destination city: " + destination);
    }
}
