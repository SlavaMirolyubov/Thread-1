package com.Entity;

import java.time.LocalDate;

public class Request {
    private String hotelName;
    private String customerName;
    private LocalDate date;
    private int bedsInRoom;

    public Request(String hotelName, String customerName, LocalDate date, int bedsInRoom) {
        this.hotelName = hotelName;
        this.customerName = customerName;
        this.date = date;
        this.bedsInRoom = bedsInRoom;
    }

    @Override
    public String toString() {
        return hotelName + ": " + customerName;
    }
}
