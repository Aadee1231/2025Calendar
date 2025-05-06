import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonthTest {

    private Month march;
    private Month june;

    @BeforeEach
    public void setUp() {
        march = new Month("March", 31);
        june = new Month("June", 30);
    }

    @Test
    public void testAddNullEvent() {
        boolean result = march.addEvent(15, "");
        assertTrue(result, "Even blank notes are stored as events based on current logic");
    }

    @Test
    public void testAddEvent() {
        boolean result = march.addEvent(15, "Doctor Visit");
        assertTrue(result, "Should allow adding a valid event");
    }

    @Test
    public void testAddEventToInvalidDate() {
        boolean result = june.addEvent(31, "Invalid date");
        assertFalse(result, "Should not allow adding events on June 31");
    }

    @Test
    public void testAddEventToFirstDay() {
        boolean result = march.addEvent(1, "New Month Start");
        assertTrue(result, "Should allow adding event on March 1");
    }

    @Test
    public void testAddEventToLastDay() {
        boolean result = march.addEvent(31, "End of Month");
        assertTrue(result, "Should allow adding event on March 31");
    }

    @Test
    public void testAddMoreThanFiveEvents() {
        boolean filled = true;
        for (int i = 1; i <= 5; i++) {
            filled &= march.addEvent(10, "Event " + i);
        }
        assertTrue(filled, "First 5 events should be added");
        assertFalse(march.addEvent(10, "Overflow Event"), "6th event should not be added to the same day");
    }

    @Test
    public void testRemoveExistingEvent() {
        march.addEvent(20, "Meeting");
        boolean removed = march.removeEvent(20, "Meeting");
        assertTrue(removed, "Event should be removable");
    }

    @Test
    public void testRemoveNonExistentEvent() {
        boolean removed = march.removeEvent(20, "Nothing here");
        assertFalse(removed, "Should return false for nonexistent event");
    }

    @Test
    public void testRemoveFromInvalidDay() {
        boolean removed = march.removeEvent(32, "Invalid");
        assertFalse(removed, "Should not allow removal from invalid day");
    }
}

