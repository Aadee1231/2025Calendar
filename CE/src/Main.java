import java.util.Scanner;

/**
 * Entry point of the calendar application
 * Allows users to view, add, and remove events for the year 2025
 * 
 * @author Group7
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calendar app = new Calendar(2025);

        System.out.println("Welcome to the 2025 Calendar!");
        System.out.println("Please select a month, add or remove events, and then view calendar.");

        while (true) {
            System.out.println("\nEnter a command (month name, 'add', 'remove', or 'quit'):");
            String input = scan.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("\nThanks for using the 2025 Calendar! Goodbye!");
                break;
            } else if (input.equalsIgnoreCase("add")) {
                System.out.println("Enter the month, day, and description (e.g., 'January 15 Meeting'):");
                String eventInput = scan.nextLine().trim();
                String[] parts = eventInput.split(" ", 3);
                if (parts.length < 3) {
                    System.out.println("Invalid input. Please enter in 'Month Day Description' format.");
                    continue;
                }
                String monthName = parts[0];
                int day;
                try {
                    day = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid day.");
                    continue;
                }
                String desc = parts[2];
                Month m = app.getMonth(monthName);
                if (m == null || !m.addEvent(day, desc)) {
                    System.out.println("Could not add event. Check month/day.");
                } else {
                    System.out.println("Event added!");
                }
            } else if (input.equalsIgnoreCase("remove")) {
                System.out.println("Enter the month, day, and exact description to remove:");
                String eventInput = scan.nextLine().trim();
                String[] parts = eventInput.split(" ", 3);
                if (parts.length < 3) {
                    System.out.println("Invalid input. Please enter in 'Month Day Description' format.");
                    continue;
                }
                String monthName = parts[0];
                int day;
                try {
                    day = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid day.");
                    continue;
                }
                String desc = parts[2];
                Month m = app.getMonth(monthName);
                if (m == null || !m.removeEvent(day, desc)) {
                    System.out.println("Could not remove event.");
                } else {
                    System.out.println("Event removed!");
                }
            } else {
                Month m = app.getMonth(input);
                if (m == null) {
                    System.out.println("Invalid month. Please try again.");
                } else {
                    System.out.println("\n" + m.displayMonth());
                }
            }
        }

        scan.close();
    }
}
