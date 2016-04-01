package com.twair;

import java.util.Date;
import java.util.List;

public class Flight {
    private String source;
    private String destination;

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    private Plane plane;
    private String number;
    private Date travelDate;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    private List<Category> categoryList;

    public Flight(String number, String source, String destination, Plane plane) throws Exception {
        this.source = source;
        this.destination = destination;
        this.plane = plane;
        this.number = number;
    }

    public String getSource() {
        return source;
    }
    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }
    public String getDestination() {
        return destination;
    }

    public String getNumber() {
        return number;
    }

    public Date getTravelDate() {return travelDate;}


}
