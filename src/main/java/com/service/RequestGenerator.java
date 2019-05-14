package com.service;

import com.Entity.Request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RequestGenerator {

    private static List<String> hotels = new ArrayList<>(Arrays.asList("Hilton", "Marriott", "Hyatt", "Park Inn",
            "Accor", "Raddyson"));
    private static List<String> customers = new ArrayList<>(
            Arrays.asList("John Deere", "Alex Pirelli", "Hideo Kojima", "Slava Mirolyubov", "Sophia Black",
                    "Andrew Yolo", "Todd Howard", "Bob Kotik", "Mads Mikkelsen", "Alexander Evdakimov",
                    "Konstantin Vlasov", "Tatsuro Yamashita"));

    public Request generateRandomRequest() {
        return new Request(getRandomHotel(), getRandomCustomer());
    }

    private String getRandomHotel() {
        Random random = new Random();
        return hotels.get(random.nextInt(hotels.size()));
    }

    private String getRandomCustomer() {
        Random random = new Random();
        return customers.get(random.nextInt(customers.size()));
    }
}
