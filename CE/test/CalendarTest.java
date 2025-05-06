import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalendarTest {

    private Calendar calendar;

    @BeforeEach
    public void setUp() {
        calendar = new Calendar(2025); 
    }

    @Test
    public void testGetValidMonth() {
        Month m = calendar.getMonth("March");
        assertNotNull(m, "March should be a valid month");
        assertEquals("March", m.getName());
    }

    @Test
    public void testGetInvalidMonth() {
        Month m = calendar.getMonth("NotAMonth");
        assertNull(m, "Invalid month name should return null");
    }

    @Test
    public void testIsValidMonth() {
        assertTrue(calendar.isValidMonth("April"));
        assertFalse(calendar.isValidMonth("FakeMonth"));
    }

    @Test
    public void testLeapYearFebruary() {
        Calendar leapYearCalendar = new Calendar(2024);
        Month feb = leapYearCalendar.getMonth("February");
        assertEquals(29, feb.getDays(), "February in a leap year should have 29 days");
    }

    @Test
    public void testNonLeapYearFebruary() {
        Calendar nonLeap = new Calendar(2025);
        Month feb = nonLeap.getMonth("February");
        assertEquals(28, feb.getDays(), "February in a non-leap year should have 28 days");
    }

    @Test
    public void testGetMonthNames() {
        String[] names = calendar.getMonthNames();
        assertEquals(12, names.length);
        assertEquals("January", names[0]);
        assertEquals("December", names[11]);
    }
}
