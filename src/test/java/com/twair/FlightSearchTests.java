package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FlightSearchTests {
    private String source;
    private String destination;
    private FlightSearch allFlights;

    Flight flight1;
    Flight flight2;
    Flight flight3;

    Plane plane1;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        destination = "TestDestination";
        plane1 = new Plane("type1", 10);


        flight1 = mock(Flight.class);flight2 = mock(Flight.class);flight3 = mock(Flight.class);
//        Flight flight1 = new Flight("F001", source, destination, plane1);
//        flight1.setTravelDate(new Date("01-Apr-2016"));
//        flight1.setCategoryList(getClassCategoryList(10, 20, 40));

//        Flight flight2 = new Flight("F002", "TestSource1", destination, plane1);
//        flight2.setTravelDate(new Date("04-Apr-2016"));
//        flight2.setCategoryList(getClassCategoryList(10, 20, 40));
//
//        Flight flight3 = new Flight("F003", source, destination, plane1);
//        flight3.setTravelDate(new Date("02-Apr-2016"));
//        flight3.setCategoryList(getClassCategoryList(4, 20, 40));

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        allFlights = new FlightSearch(flightList);
    }

    private List<Category> getClassCategoryList(int firstClassSeats, int businessClassSeats, int economyClassSeats) {
        List<Category> categoryList = new ArrayList<Category>();
        categoryList.add(new Category("First Class", "FC", firstClassSeats));
        categoryList.add(new Category("Business Class", "BC", businessClassSeats));
        categoryList.add(new Category("Economy Class", "EC", economyClassSeats));
        return categoryList;
    }

    @Test
    public void shouldReturnListOfFlightsForMatchingSourceDestination() throws Exception {
        List<Flight> flights = allFlights.byLocation(source, destination).getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(2, flights.size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateSource() throws Exception {
        allFlights.byLocation(null, destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void sourceCannotBeEmpty() throws Exception {
        allFlights.byLocation("", destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateDestination() throws Exception {
        allFlights.byLocation(source, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void destinationCannotBeEmpty() throws Exception {
        allFlights.byLocation(source, "");
    }

    @Test
    public void shouldSearchFlightsByFromToAndDate() throws Exception {
        List<Flight> flights = allFlights.byLocation(source, destination, "01-Apr-2016").getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(1, flights.size());
    }


    @Test
    public void shouldSearchFlightsByFromWitoutDate() throws Exception {
        List<Flight> flights = allFlights.byLocation(source, destination, "").getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(2, flights.size());
    }

    @Test
    public void shouldSearchFlightsByClassAndSeats() throws  Exception {

            when(flight1.getNumber()).thenReturn("F001");
            when(flight1.getSource()).thenReturn(source);
            when(flight1.getDestination()).thenReturn(destination);
            when(flight1.getPlane()).thenReturn(plane1);
            when(flight1.getCategoryList()).thenReturn(getClassCategoryList(10, 20, 40));

            when(flight2.getNumber()).thenReturn("F002");
            when(flight2.getSource()).thenReturn("Test Source2");
            when(flight2.getDestination()).thenReturn(destination);
            when(flight2.getPlane()).thenReturn(plane1);
            when(flight2.getCategoryList()).thenReturn(getClassCategoryList(12, 20, 40));

            when(flight3.getNumber()).thenReturn("F003");
            when(flight3.getSource()).thenReturn(source);
            when(flight3.getDestination()).thenReturn(destination);
            when(flight3.getPlane()).thenReturn(plane1);
            when(flight3.getCategoryList()).thenReturn(getClassCategoryList(4, 20, 40));

//        Flight flight1 = new Flight("F001", source, destination, plane1);
//        flight1.setTravelDate(new Date("01-Apr-2016"));
//        flight1.setCategoryList(getClassCategoryList(10, 20, 40));

        List<Flight> flights = allFlights.byLocationSeatsAndCategory(source, destination, 5, "FC").getFlightList();
        Assert.assertEquals(1, flights.size());
    }
}
