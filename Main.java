/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 2/2/2024
 * Rev: 1.1
 */

/**
 * Imports Scanner class from java.util library for user input.
 */
import java.util.Scanner;

public class Main {

    /**
     * Main method as the entry point for the System Network Analyzer application.
     * It displays a menu for users to select from various network diagnostic functions.
     */
    public static void main(String[] args) {
        /**
         * Creates a new scanner object for reading user input.
         */
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menu display
            System.out.println("\nUser Menu for System Network Analyzer:");
            System.out.println("1: Perform a network ping");
            System.out.println("2: Show the NIC (Network Interface Card) details");
            System.out.println("3: Perform a port scan on your local computer");
            System.out.println("4: Show the routing table");
            System.out.println("5: Exit");
            System.out.print("Enter your choice (1-5): ");

            /**
             * @param choice The choice of which network operation to perform.
             */
            int choice = scanner.nextInt(); // Captures user's choice.
            scanner.nextLine(); // Clears the buffer after reading an integer.

            if (choice == 1) {
                /**
                 * Ping operation.
                 * @param hostname Hostname or IP address to ping. User is prompted for this input.
                 * Creates a Ping object and calls its method to check host reachability.
                 */
                System.out.print("Enter hostname to ping: ");
                String hostname = scanner.nextLine();
                Ping p = new Ping(hostname);
                p.checkHostReachability();
            } else if (choice == 2) {
                /**
                 * NIC details display.
                 * @param description Description or identifier for the NIC. User is prompted for this input.
                 * Creates a NetworkCard object and calls its method to display network information.
                 */
                System.out.print("Enter personal description for Network Interface: ");
                String description = scanner.nextLine();
                NetworkCard n = new NetworkCard(description);
                n.displayNetworkInfo();
            } else if (choice == 3) {
                /**
                 * Port scanning operation.
                 * @param target Target host for port scanning. User is prompted for this input.
                 * Creates a PortScan object and calls its method to scan ports.
                 */
                System.out.print("Enter the target host: ");
                String target = scanner.nextLine();
                PortScan p = new PortScan(target);
                p.scanPorts();
            } else if (choice == 4) {
                /**
                 * Routing table display.
                 * Determines the command to use based on the operating system.
                 * @param command Command to display the routing table. Determined by checking the OS.
                 * Creates a RoutingTable object and calls its method to print the routing table.
                 */
                String command;
                if (System.getProperty("os.name").startsWith("Windows")) {
                    command = "route print";
                } else {
                    command = "netstat -rn";
                }
                RoutingTable r = new RoutingTable(command);
                r.printRoutingTable();
            } else if (choice == 5) {
                // Exit the program
                System.out.println("Exiting...");
                break;
            } else {
                // Handles invalid input
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        scanner.close(); // Closes the scanner to prevent resource leaks.
    }
}
