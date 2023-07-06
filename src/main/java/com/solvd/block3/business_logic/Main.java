package com.solvd.block3.business_logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.block3.models.*;
import com.solvd.block3.ui.UiUtils;

public class Main 
{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    
    public static void main(String[] args) 
    {
        LOGGER.info("Welcome to the flight finder. Please input an origin city.");
        City origin = UiUtils.makeCity();

        LOGGER.info("Now input a destination.");
        City destination = UiUtils.makeCity();

        String mode = UiUtils.getMode();

        if (mode.equalsIgnoreCase("s"))
        {
            UiUtils.makeShortestRoute(origin, destination);
        }
    }
}
