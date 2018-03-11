import Guests.Guest;
import Rooms.DiningRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;
    Guest guest;


    @Before
    public void before() {
        ArrayList<Guest> guests = new ArrayList<>();
        diningRoom = new DiningRoom(1, 100, guests, "McDonald");
        guest = new Guest("Verity", 100);
    }

    @Test
    public void hasRoomNumber() {
        assertEquals(1, diningRoom.getRoomNumber());
    }

    @Test
    public void hasCapacity() {
        assertEquals(100, diningRoom.getCapacity());
    }

    @Test
    public void hasGuests() {
        assertEquals(0, diningRoom.getGuests().size());
    }

    @Test
    public void canCheckCapacityWhenNotReached() {
        diningRoom.addGuestToRoom(guest);
        assertEquals(false, diningRoom.isCapacityReached());
    }

    @Test
    public void canCheckCapacityWhenIsReached() {
        for( int i=0; i < diningRoom.getCapacity(); i++) {
            diningRoom.addGuestToRoom(guest);
        }
        assertEquals(true, diningRoom.isCapacityReached());
    }

    @Test
    public void canAddGuestToRoom() {
        diningRoom.addGuestToRoom(guest);
        assertEquals(1, diningRoom.getGuests().size());
    }

    @Test
    public void hasName() {
        assertEquals("McDonald", diningRoom.getRoomName());
    }

    @Test
    public void canRemoveGuestFromRoom() {
        diningRoom.addGuestToRoom(guest);
        diningRoom.addGuestToRoom(guest);
        assertEquals(2, diningRoom.getGuests().size());
        diningRoom.removeGuestFromRoom(guest);
        assertEquals(1, diningRoom.getGuests().size());
    }
}
