package Rooms;

import Guests.Guest;
import Hotel.Room;

import java.util.ArrayList;

public class DiningRoom extends Room {

    private String name;

    public DiningRoom(int roomNumber, int capacity, ArrayList<Guest> guests, String name) {
        super(roomNumber, capacity, guests);
        this.name = name;
    }

    public String getRoomName() {
        return name;
    }
}
