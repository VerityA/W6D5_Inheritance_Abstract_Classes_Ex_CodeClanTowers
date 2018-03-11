import Guests.Guest;
import Hotel.Hotel;
import Rooms.Bedroom;
import Rooms.BedroomType;
import Rooms.ConferenceRoom;
import Rooms.DiningRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    Bedroom bedroom4;
    DiningRoom diningRoom1;
    ConferenceRoom conferenceRoom1;


    @Before
    public void before() {
        hotel = new Hotel();
        ArrayList<Guest> guests1 = new ArrayList<>();
        ArrayList<Guest> guests2 = new ArrayList<>();
        ArrayList<Guest> guests3 = new ArrayList<>();
        ArrayList<Guest> guests4 = new ArrayList<>();
        ArrayList<Guest> guests5 = new ArrayList<>();
        ArrayList<Guest> guests6 = new ArrayList<>();
        bedroom1 = new Bedroom(1, BedroomType.DOUBLE.getCapacity(),guests1, BedroomType.DOUBLE, 200);
        bedroom2 = new Bedroom(2, BedroomType.DOUBLE.getCapacity(),guests4, BedroomType.SINGLE, 150);
        bedroom3 = new Bedroom(3, BedroomType.DOUBLE.getCapacity(),guests5, BedroomType.DOUBLE, 250);
        bedroom4 = new Bedroom(4, BedroomType.DOUBLE.getCapacity(),guests6, BedroomType.SINGLE, 125);
        conferenceRoom1 = new ConferenceRoom(1, 500, guests2, 10, "Appin");
        diningRoom1 = new DiningRoom(1, 100, guests3, "Skye");
    }

    @Test
    public void canGetBedrooms() {
        assertEquals(0, hotel.getBedrooms().size());
    }

    @Test
    public void canGetDiningRooms() {
        assertEquals(0, hotel.getDiningRooms().size());
    }

    @Test
    public void canGetConferenceRooms() {
        assertEquals(0, hotel.getConferenceRooms().size());
    }

    @Test
    public void  canGetTakings() {
        assertEquals(1000, hotel.getTakings());
    }

    @Test
    public void canIncreaseTakings() {
        hotel.increaseTakings(500);
        assertEquals(1500, hotel.getTakings());
    }

    @Test
    public void canAddBedroomToHotel() {
        hotel.addBedroom(bedroom1);
        assertEquals(1, hotel.getBedrooms().size());
    }

    @Test
    public void canAddConferenceRoomToHotel() {
        hotel.addConferenceRoom(conferenceRoom1);
        assertEquals(1, hotel.getConferenceRooms().size());
    }

    @Test
    public void canAddDiningRoomToHotel() {
        hotel.addDiningRoom(diningRoom1);
        assertEquals(1, hotel.getDiningRooms().size());
    }

    @Test
    public void canCheckInGuestToBedroom() {
        hotel.addBedroom(bedroom1);
        Guest guest = new Guest("Verity", 500);
        hotel.checkInGuestToBedroom(bedroom1, guest, 2);
        assertEquals(1, bedroom1.getGuests().size());
        assertEquals(100, guest.getWalletValue());
        assertEquals(1400, hotel.getTakings());
    }

    @Test
    public void canCheckInGuestToConferenceRoom() {
        hotel.addConferenceRoom(conferenceRoom1);
        Guest guest = new Guest("Verity", 500);
        hotel.checkInGuestToConferenceRoom(conferenceRoom1, guest);
        assertEquals(1, conferenceRoom1.getGuests().size());
        assertEquals(490, guest.getWalletValue());
        assertEquals(1010, hotel.getTakings());
    }

    @Test
    public void canCheckInGuestToDiningRoom() {
        hotel.addDiningRoom(diningRoom1);
        Guest guest = new Guest("Verity", 500);
        hotel.checkInGuestToDiningRoom(diningRoom1, guest);
        assertEquals(1, diningRoom1.getGuests().size());
    }

    @Test
    public void canReturnGuestsFromADiningRoom() {
        hotel.addDiningRoom(diningRoom1);
        Guest guest = new Guest("Verity", 500);
        hotel.checkInGuestToDiningRoom(diningRoom1, guest);
        hotel.checkInGuestToDiningRoom(diningRoom1, guest);
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest);
        guests.add(guest);
        assertEquals(guests, hotel.showGuestsCheckedIntoDiningRoom(diningRoom1));
    }

    @Test
    public void canReturnGuestsFromAConferenceRoom() {
        hotel.addConferenceRoom(conferenceRoom1);
        Guest guest = new Guest("Verity", 500);
        hotel.checkInGuestToConferenceRoom(conferenceRoom1, guest);
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest);
        assertEquals(guests, hotel.showGuestsCheckedIntConferenceRoom(conferenceRoom1));
    }

    @Test
    public void canReturnGuestsFromABedroom() {
        hotel.addBedroom(bedroom1);
        Guest guest = new Guest("Verity", 500);
        hotel.checkInGuestToBedroom(bedroom1, guest,1);
        hotel.checkInGuestToBedroom(bedroom1, guest,1);
        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(guest);
        guests.add(guest);
        assertEquals(guests, hotel.showGuestsCheckedIntoBedroom(bedroom1));
    }

    @Test
    public void canShowListOfVacantBedrooms() {
        hotel.addBedroom(bedroom1);
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.addBedroom(bedroom4);
        Guest guest1 = new Guest("Verity", 500);
        Guest guest2 = new Guest("David", 300);
        Guest guest3 = new Guest("George", 400);
        Guest guest4 = new Guest("Ruby", 500);
        hotel.checkInGuestToBedroom(bedroom1, guest1,1);
        hotel.checkInGuestToBedroom(bedroom1, guest2,1);
        hotel.checkInGuestToBedroom(bedroom3, guest3,1);
        hotel.checkInGuestToBedroom(bedroom3, guest4,1);
        ArrayList<Bedroom> vacantRooms = new ArrayList<>();
        vacantRooms.add(bedroom2);
        vacantRooms.add(bedroom4);
        assertEquals(vacantRooms, hotel.showListOfVacantRooms());



    }


}
