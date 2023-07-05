package com.solvd.block3.business_logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.block3.json.JsonMaker;
import com.solvd.block3.ui.UiUtils;
import com.solvd.block3.xml.XmlMaker;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String XML_PATH = "src/main/resources/Flights.xml";
    private static final String JSON_PATH = "src/main/resources/Flights.json";
    
    public static void main(String[] args) 
    {
        LOGGER.info("Welcome to the flight finder. Please input an origin city.");
        String origin = UiUtils.makeCity();

        LOGGER.info("Now input a destination.");
        String destination = UiUtils.makeCity();

        //For testing
        LOGGER.info(origin + " " + destination);
    }
}
