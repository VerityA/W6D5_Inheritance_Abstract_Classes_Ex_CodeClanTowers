package Hotel;

import Guests.Guest;

import java.util.ArrayList;

public abstract class Room {

    private int roomNumber;
    private int capacity;
    private ArrayList<Guest> guests;

    public Room(int roomNumber, int capacity, ArrayList<Guest> guests) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.guests = guests;
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }


    public void addGuestToRoom(Guest guest) {
        this.guests.add(guest);
    }

    public void removeGuestFromRoom(Guest guest) {
        this.guests.remove(guest);
    }

    public boolean isCapacityReached() {
        return this.capacity <= this.guests.size();
    }

}
