package com.solvd.block3.ui;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.block3.models.City;
import com.solvd.block3.services.CityServiceMyBatis;

public class UiUtils 
{    
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(UiUtils.class);
    private static final CityServiceMyBatis CITY_SERVICE = new CityServiceMyBatis();

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
}
