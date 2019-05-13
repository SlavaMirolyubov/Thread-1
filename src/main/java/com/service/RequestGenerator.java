package com.service;

import com.Entity.Request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RequestGenerator {

    private static List<String> hotels = new ArrayList<>(Arrays.asList("Hilton", "Marriott", "Hyatt", "Park Inn",
            "Accor", "Raddyson"));
    private static List<String> customers = new ArrayList<>(
            Arrays.asList("John Deere", "Alex Pirelli", "Hideo Kojima", "Slava Mirolyubov", "Sophia Black",
                    "Andrew Yolo", "Todd Howard", "Bob Kotik", "Mads Mikkelsen", "Alexander Evdakimov",
                    "Konstantin Vlasov", "Tatsuro Yamashita"));

    public Request generateRandomRequest() {
        return new Request(getRandomHotel(), getRandomCustomer(), getRandomDate(), getRandomNumberOfBeds());
    }

    private String getRandomHotel() {
        Random random = new Random();
        return hotels.get(random.nextInt(hotels.size()));
    }

    private String getRandomCustomer() {
        Random random = new Random();
        return customers.get(random.nextInt(customers.size()));
    }

    private LocalDate getRandomDate() {
        long minDay = LocalDate.of(2019, 3, 15).toEpochDay();
        long maxDay = LocalDate.of(2019, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    private int getRandomNumberOfBeds() {
        Random random = new Random();
        return random.ints(1, 6).findFirst().getAsInt();
    }

}
