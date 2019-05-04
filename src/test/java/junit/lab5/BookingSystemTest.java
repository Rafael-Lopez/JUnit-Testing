package junit.lab5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// 4.10.3 Booking System

public class BookingSystemTest {

    private final Integer[] VALID_HOURS = new Integer[]{10, 12, 15};
    private final Integer[] INVALID_HOURS = new Integer[]{-2, 12, 15};
    private BookingSystem bookingSystem;

    @Before
    public void setUp(){
        bookingSystem = new BookingSystem(VALID_HOURS);
    }

    @Test
    public void shouldReturnListOfBookedHours() {
        Integer[] result = bookingSystem.getBookedHours();

        assertEquals(3, result.length);
        assertNotNull(result);
        assertSame(VALID_HOURS, result);
    }

    @Test
    public void shouldNotAllowHourToBeDoubleBooked() {
        assertTrue(bookingSystem.checkAvailability(11));
        assertFalse(bookingSystem.checkAvailability(10));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidHours() {
        new BookingSystem(INVALID_HOURS);
    }
}
