package com.solvd.block3.ui;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UiUtils 
{    
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(UiUtils.class);

    public static String makeCity()
    {
        String ret = SCANNER.nextLine();
        while (!validateCity(ret))
        {
            LOGGER.error("City doesn't exist in database. Please try again.");
            ret = SCANNER.nextLine();
        }

        return ret;
    }

    public static boolean validateCity(String city)
    {
        boolean ret = true;
        //Use mybatis to return a city object with the name parameter
        //If null, return false;

        return ret;
    }
}
