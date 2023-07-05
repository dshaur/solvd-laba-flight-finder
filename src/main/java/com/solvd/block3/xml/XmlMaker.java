package com.solvd.block3.xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XmlMaker
{
    private static final Logger LOGGER = LogManager.getLogger(XmlMaker.class);

    public static void makeXml(String path, Object toParse)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(toParse.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(toParse, new File(path));
        }

        catch (JAXBException e)
        {
            LOGGER.error(e.getMessage());
        }
    }
}
