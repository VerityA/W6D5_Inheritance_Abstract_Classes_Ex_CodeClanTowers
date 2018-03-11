package Hotel;

import Guests.Guest;
import Rooms.Bedroom;
import Rooms.ConferenceRoom;
import Rooms.DiningRoom;

import java.util.ArrayList;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;
    private int takings;

    public Hotel() {
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRooms =  new ArrayList<>();
        this.takings = 1000;
    }


    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public ArrayList<DiningRoom> getDiningRooms() {
        return diningRooms;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return bedrooms;
    }

    public int getTakings() {
        return takings;
    }


    public void increaseTakings(int charge) {
        this.takings += charge;
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRooms.add(conferenceRoom);
    }

    public void addDiningRoom(DiningRoom diningRoom) {
        this.diningRooms.add(diningRoom);
    }

    public void checkInGuestToBedroom(Bedroom bedroom, Guest guest, int nights) {
        int charge = bedroom.getNightlyRate() * nights;
        if (guest.hasSufficientFunds(charge)) {
            bedroom.addGuestToRoom(guest);
            guest.reduceWalletValue(charge);
            this.increaseTakings(charge);
        }
    }

    public void checkInGuestToConferenceRoom(ConferenceRoom conferenceRoom, Guest guest) {
        int charge = conferenceRoom.getDailyRate();
        if (guest.hasSufficientFunds(charge)) {
            conferenceRoom.addGuestToRoom(guest);
            guest.reduceWalletValue(charge);
            this.increaseTakings(charge);
        }
    }

    public void checkInGuestToDiningRoom(DiningRoom diningRoom, Guest guest) {
        diningRoom.addGuestToRoom(guest);
    }

    public void checkOutGuestFromBedroom(Bedroom bedroom, Guest guest) {
        bedroom.removeGuestFromRoom(guest);
    }

    public void checkOutGuestFromDiningRoom(DiningRoom diningRoom, Guest guest) {
        diningRoom.removeGuestFromRoom(guest);
    }

    public void checkOutGuestFromConferenceRoom(ConferenceRoom conferenceRoom, Guest guest) {
        conferenceRoom.removeGuestFromRoom(guest);
    }

    public ArrayList<Guest> showGuestsCheckedIntoBedroom(Bedroom bedroom) {
        return bedroom.getGuests();
    }

    public ArrayList<Guest> showGuestsCheckedIntoDiningRoom(DiningRoom diningRoom) {
        return diningRoom.getGuests();
    }

    public ArrayList<Guest> showGuestsCheckedIntConferenceRoom(ConferenceRoom conferenceRoom) {
        return conferenceRoom.getGuests();
    }

    public ArrayList<Bedroom> showListOfVacantRooms() {
        ArrayList<Bedroom> vacantRooms = new ArrayList<>();
        for (Bedroom bedroom: this.bedrooms) {
            if (bedroom.getGuests().size() ==0 ) {
                vacantRooms.add(bedroom);
            }
        }
        return vacantRooms;
    }
}
