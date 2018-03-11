package Rooms;

import Guests.Guest;
import Hotel.Room;

import java.util.ArrayList;

public class ConferenceRoom extends Room {

    private int dailyRate;
    private String name;

    public ConferenceRoom(int roomNumber, int capacity, ArrayList<Guest> guests, int dailyRate, String name) {
        super(roomNumber, capacity, guests);
        this.dailyRate = dailyRate;
        this.name = name;
    }


    public String getRoomName() {
        return name;
    }

    public int getDailyRate() {
        return dailyRate;
    }


}
