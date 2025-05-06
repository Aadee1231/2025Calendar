/**
 * Represents a calendar for a given year, containing months and their events
 * 
 * @author Group7
 */
public class Calendar {
    private int year;
    private Month[] months;
    private String[] monthNames = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    private int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Constructs a Calendar for a specific year and initializes its months
     *
     * @param year the year for the calendar
     */
    public Calendar(int year) {
        this.year = year;
        if (isLeapYear(year)) {
            monthDays[1] = 29;
        }
        this.months = new Month[12];
        for (int i = 0; i < 12; i++) {
            months[i] = new Month(monthNames[i], monthDays[i]);
        }
    }

    /**
     * Gets the Month object for a given name
     *
     * @param name the name of the month
     * @return the Month object, or null if not found
     */
    public Month getMonth(String name) {
        for (Month m : months) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Checks if a given month name is valid
     *
     * @param name the name of the month
     * @return true if the month is valid, false otherwise
     */
    public boolean isValidMonth(String name) {
        return getMonth(name) != null;
    }

    /**
     * Returns an array of all month names
     *
     * @return array of month names
     */
    public String[] getMonthNames() {
        return monthNames;
    }

    /**
     * Prints all events across all months in the calendar
     */
    public void printAllEvents() {
        for (Month m : months) {
            m.printAllEvents();
        }
    }

    /**
     * Determines whether a year is a leap year
     *
     * @param y the year to check
     * @return true if it's a leap year, false otherwise
     */
    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}

