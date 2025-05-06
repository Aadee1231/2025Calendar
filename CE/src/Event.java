/**
 * Represents a calendar event with a simple text description
 * 
 * @author Group7
 */
public class Event {
    private String description;

    /**
     * Constructs an Event with the given description
     *
     * @param description the event's description
     */
    public Event(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the event
     *
     * @return the event description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representation of the event, formatted with a bullet
     *
     * @return formatted event string
     */
    public String toString() {
        return "- " + description;
    }
}


