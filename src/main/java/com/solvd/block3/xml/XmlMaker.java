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
    private String path;
    private Object toParse;
    private JAXBContext context;

    public XmlMaker(String path, Object toParse) 
    {
        try
        {
            this.path = path;
            this.toParse = toParse;
            context = JAXBContext.newInstance(toParse.getClass());
        }

        catch (JAXBException e)
        {
            LOGGER.error(e.getMessage());
        }
    }

    public void makeXml()
    {
        try
        {
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(toParse, new File(path));
        }

        catch (JAXBException e)
        {
            LOGGER.error(e.getMessage());
        }
    }
}
