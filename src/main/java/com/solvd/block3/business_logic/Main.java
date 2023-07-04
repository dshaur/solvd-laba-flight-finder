package com.solvd.block3.business_logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.block3.utilities.Utils;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger("Main");
    public static void main(String[] args)
    {
        LOGGER.info("Welcome to the flight finder. Please input an origin city.");
        String origin = Utils.makeCity();

        LOGGER.info("Now input a destination.");
        String destination = Utils.makeCity();

        //For testing
        LOGGER.info(origin + " " + destination);
    }
}
