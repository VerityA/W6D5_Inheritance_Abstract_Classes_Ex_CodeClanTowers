import Guests.Guest;
import Rooms.Bedroom;
import Rooms.BedroomType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest;


    @Before
    public void before() {
        ArrayList<Guest> guests = new ArrayList<>();
        bedroom = new Bedroom(1, BedroomType.DOUBLE.getCapacity(), guests, BedroomType.DOUBLE, 200);
        guest = new Guest("Verity", 100);
    }

    @Test
    public void hasRoomNumber() {
        assertEquals(1, bedroom.getRoomNumber());
    }

    @Test
    public void hasCapacity() {
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void hasGuests() {
        assertEquals(0, bedroom.getGuests().size());
    }

    @Test
    public void hasNightlyRate() {
        assertEquals(200, bedroom.getNightlyRate());
    }


    @Test
    public void canCheckCapacityWhenNotReached() {
        bedroom.addGuestToRoom(guest);
        assertEquals(false, bedroom.isCapacityReached());
    }

    @Test
    public void canCheckCapacityWhenIsReached() {
        for( int i=0; i < bedroom.getCapacity(); i++) {
            bedroom.addGuestToRoom(guest);
        }
        assertEquals(true, bedroom.isCapacityReached());
    }

    @Test
    public void canAddGuestToRoom() {
        bedroom.addGuestToRoom(guest);
        assertEquals(1, bedroom.getGuests().size());
    }

    @Test
    public void canRemoveGuestFromRoom() {
        bedroom.addGuestToRoom(guest);
        bedroom.addGuestToRoom(guest);
        assertEquals(2, bedroom.getGuests().size());
        bedroom.removeGuestFromRoom(guest);
        assertEquals(1, bedroom.getGuests().size());
    }


}
