import Guests.Guest;
import Rooms.ConferenceRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest;

    @Before
    public void before() {
        ArrayList<Guest> guests = new ArrayList<>();
        conferenceRoom = new ConferenceRoom(1, 500, guests, 10, "McArthur");
        guest = new Guest("Verity", 100);
    }


    @Test
    public void hasRoomNumber() {
        assertEquals(1, conferenceRoom.getRoomNumber());
    }

    @Test
    public void hasCapacity() {
        assertEquals(500, conferenceRoom.getCapacity());
    }

    @Test
    public void hasGuests() {
        assertEquals(0, conferenceRoom.getGuests().size());
    }

    @Test
    public void hasDailyRate() {
        assertEquals(10, conferenceRoom.getDailyRate());
    }

    @Test
    public void canCheckCapacityWhenNotReached() {
        conferenceRoom.addGuestToRoom(guest);
        assertEquals(false, conferenceRoom.isCapacityReached());
    }

    @Test
    public void canCheckCapacityWhenIsReached() {
        for( int i=0; i < conferenceRoom.getCapacity(); i++) {
            conferenceRoom.addGuestToRoom(guest);
        }
        assertEquals(true, conferenceRoom.isCapacityReached());
    }

    @Test
    public void canAddGuestToRoom() {
        conferenceRoom.addGuestToRoom(guest);
        assertEquals(1, conferenceRoom.getGuests().size());
    }

    @Test
    public void hasName() {
        assertEquals("McArthur", conferenceRoom.getRoomName());
    }

    @Test
    public void canRemoveGuestFromRoom() {
        conferenceRoom.addGuestToRoom(guest);
        conferenceRoom.addGuestToRoom(guest);
        assertEquals(2, conferenceRoom.getGuests().size());
        conferenceRoom.removeGuestFromRoom(guest);
        assertEquals(1, conferenceRoom.getGuests().size());
    }
}
