package com.solvd.block3.json;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMaker 
{
    private static final Logger LOGGER = LogManager.getLogger(JsonMaker.class);
    private String pathOfFile;
    private ObjectMapper mapper = new ObjectMapper();
    private Object toParse;

    public JsonMaker(String path, Object toParse) 
    {
        this.pathOfFile = path;
        this.toParse = toParse;
    }

    public void makeJson()
    {
        try
        {
            mapper.writeValue(new File(pathOfFile), toParse);   
        }

        catch (IOException e)
        {
            LOGGER.error(e.getMessage());
        }
    }
}
