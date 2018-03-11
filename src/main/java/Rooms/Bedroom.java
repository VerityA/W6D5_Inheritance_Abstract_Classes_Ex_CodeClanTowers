package Rooms;

import Guests.Guest;
import Hotel.Room;

import java.util.ArrayList;

public class Bedroom extends Room {

        private BedroomType type;
        private int nightlyRate;

        public Bedroom(int number, int capacity, ArrayList<Guest> guests, BedroomType type, int nightlyRate) {
            super(number, capacity, guests);
            this.type = type;
            this.nightlyRate = nightlyRate;
        }

    public int getNightlyRate() {
        return nightlyRate;
    }
}
