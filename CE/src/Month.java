/**
 * Represents a single month in a calendar year with support
 * for storing multiple events per day
 * 
 * @author Group7
 */
public class Month {
    /** Name of the month */
    private String name;
    /** Number of days in the month */
    private int days;
    /** Array of events for each day, allowing multiple events per day */
    private Event[][] eventsPerDay;

    /**
     * Constructs a Month with a name and number of days
     *
     * @param name name of the month
     * @param days number of days in the month
     */
    public Month(String name, int days) {
        this.name = name;
        this.days = days;
        this.eventsPerDay = new Event[days][5]; // 5 events per day for now...can change
    }

    /**
     * Returns the name of the month
     *
     * @return the month name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of days in the month
     *
     * @return number of days
     */
    public int getDays() {
        return days;
    }

    /**
     * Adds an event to the specified day
     *
     * @param day the day of the event
     * @param description the description of the event
     * @return true if the event was added, false if the day is invalid or full
     */
    public boolean addEvent(int day, String description) {
        if (day < 1 || day > days) {
            return false;
        }
        int idx = day - 1;
        for (int i = 0; i < eventsPerDay[idx].length; i++) {
            if (eventsPerDay[idx][i] == null) {
                eventsPerDay[idx][i] = new Event(description);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a specific event from a given day
     *
     * @param day the day to remove the event from
     * @param description the exact description of the event to remove
     * @return true if the event was removed, false otherwise
     */
    public boolean removeEvent(int day, String description) {
        if (day < 1 || day > days) {
            return false;
        }
        int idx = day - 1;
        for (int i = 0; i < eventsPerDay[idx].length; i++) {
            if (eventsPerDay[idx][i] != null &&
                    eventsPerDay[idx][i].getDescription().equals(description)) {
                eventsPerDay[idx][i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a formatted string showing the month's calendar and its events
     *
     * @return the formatted month and event display
     */
    public String displayMonth() {
        String output = "";

        String title = name + " 2025";
        int lineWidth = 28;
        int padding = (lineWidth - title.length()) / 2;
        for (int i = 0; i < padding; i++) {
            output += " ";
        }
        output += title + "\n";

        output += "Sun Mon Tue Wed Thu Fri Sat\n";

        int startDay = getStartDayOfMonth2025(name);
        for (int i = 0; i < startDay; i++) {
            output += "    ";
        }

        for (int i = 1; i <= days; i++) {
            if (i < 10) {
                output += "  " + i + " ";
            } else {
                output += " " + i + " ";
            }

            if ((i + startDay) % 7 == 0) {
                output += "\n";
            }
        }

        output += "\n\n";

        for (int i = 0; i < days; i++) {
            int eventCount = 0;
            for (int j = 0; j < eventsPerDay[i].length; j++) {
                if (eventsPerDay[i][j] != null) {
                    eventCount++;
                }
            }

            if (eventCount == 1) {
                for (int j = 0; j < eventsPerDay[i].length; j++) {
                    if (eventsPerDay[i][j] != null) {
                        output += name + " " + (i + 1) + ": " + eventsPerDay[i][j].getDescription() + "\n";
                    }
                }
            } else if (eventCount > 1) {
                output += name + " " + (i + 1) + ":\n";
                for (int j = 0; j < eventsPerDay[i].length; j++) {
                    if (eventsPerDay[i][j] != null) {
                        output += " - " + eventsPerDay[i][j].getDescription() + "\n";
                    }
                }
            }
        }

        return output;
    }

    /**
     * Prints all events for the month to standard output
     */
    public void printAllEvents() {
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < eventsPerDay[i].length; j++) {
                if (eventsPerDay[i][j] != null) {
                    System.out.println(name + " " + (i + 1) + ": " + eventsPerDay[i][j]);
                }
            }
        }
    }

    /**
     * Returns the starting day of the week for a given month in 2025
     *
     * @param monthName name of the month
     * @return index of starting day (0 = Sunday, 6 = Saturday)
     */
    private int getStartDayOfMonth2025(String monthName) {
        switch (monthName) {
            case "January": return 3;
            case "February": return 6;
            case "March": return 6;
            case "April": return 2;
            case "May": return 4;
            case "June": return 0;
            case "July": return 2;
            case "August": return 5;
            case "September": return 1;
            case "October": return 3;
            case "November": return 6;
            case "December": return 1;
            default: return 0;
        }
    }
}


