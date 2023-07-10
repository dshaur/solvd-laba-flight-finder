package com.solvd.block3.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="flightList")
public class FlightList
{
    List<Flight> flights;

    public FlightList(List<Flight> flights) 
    {
        this.flights = flights;
    }

    public FlightList() 
    {
    }

    public List<Flight> getFlights() 
    {
        return flights;
    }

    @XmlElementWrapper (name="flights")
    @XmlElement (name="flight")
    public void setFlights(List<Flight> flights) 
    {
        this.flights = flights;
    }


}
