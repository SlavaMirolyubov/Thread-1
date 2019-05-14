package com.Entity;

public class Request {
    private String hotelName;
    private String customerName;

    public Request(String hotelName, String customerName) {
        this.hotelName = hotelName;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return hotelName + ": " + customerName;
    }
}
