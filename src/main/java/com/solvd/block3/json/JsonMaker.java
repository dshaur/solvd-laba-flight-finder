package com.solvd.block3.json;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMaker 
{
    private static final Logger LOGGER = LogManager.getLogger(JsonMaker.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void makeJson(String pathOfFile, Object toParse)
    {
        try
        {
            MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File(pathOfFile), toParse);   
        }

        catch (IOException e)
        {
            LOGGER.error(e.getMessage());
        }
    }
}
