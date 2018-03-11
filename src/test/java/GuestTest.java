import Guests.Guest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before() {
        guest = new Guest("Verity", 500);
    }

    @Test
    public void hasName() {
        assertEquals("Verity", guest.getName());
    }

    @Test
    public void hasWalletValue() {
        assertEquals(500, guest.getWalletValue());
    }

    @Test
    public void canReduceWalletValue() {
        guest.reduceWalletValue(100);
        assertEquals(400, guest.getWalletValue());
    }

    @Test
    public void canCheckHasEnoughMoney() {
        assertEquals(true, guest.hasSufficientFunds(250));
    }

    @Test
    public void canCheckDoesNotHaveEnoughMoney() {
        assertEquals(false, guest.hasSufficientFunds(550));
    }
}
