package com.twair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightSearch {

    private List<Flight> flightList;

    public FlightSearch(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public FlightSearch byLocation(String source, String destination) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }
        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {
            if (flight.getSource().equals(source) && flight.getDestination().equals(destination)) {
                matchingFlights.add(flight);
            }
        }
        return new FlightSearch(matchingFlights);
    }


    public FlightSearch byLocation(String source, String destination, String travelDate) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }

        List<Flight> matchingFlights = new ArrayList<Flight>();
        Date journeyDate = null;
        if (travelDate != null && travelDate != "") {
            journeyDate = new Date(travelDate);
        }
        for (Flight flight : flightList) {

            if ((flight.getSource().equals(source) && flight.getDestination().equals(destination))) {
                if (journeyDate != null){
                    if (flight.getTravelDate().equals(journeyDate)){
                        matchingFlights.add(flight);
                    }
                }else{
                    matchingFlights.add(flight);
                }
            }
        }

        return new FlightSearch(matchingFlights);
    }

    public FlightSearch byLocationSeatsAndCategory(String source, String destination, int requiredSeats, String classCategory) {
        if(source == null || source.isEmpty() || destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("source cannot be null");
        }

        List<Flight> matchingFlights = new ArrayList<Flight>();
        for (Flight flight : flightList) {

            if (flight.getSource().equals(source)
                    && flight.getDestination().equals(destination)
                    && flight.getCategoryList() != null) {
                //TODO: conditions for checking category and seat capacity
                for (Category category: flight.getCategoryList()) {
                    if(category.getCode().equals(classCategory) && category.getCapacity() >= requiredSeats){
                        matchingFlights.add(flight);
                    }
                }
            }
        }
        return new FlightSearch(matchingFlights);
    }
}
