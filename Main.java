/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 1/28/2024
 * Rev: 1.0

 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nUser Menu for System Network Analyzer:");
            System.out.println("1: Perform a network ping");
            System.out.println("2: Show the NIC (Network Interface Card) details");
            System.out.println("3: Perform a port scan on your local computer");
            System.out.println("4: Show the routing table");
            System.out.println("5: Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter hostname to ping: ");
                String hostname = scanner.nextLine();
                Ping p = new Ping(hostname);
                p.checkHostReachability();
            } else if (choice == 2) {
                System.out.print("Enter description of Network Interface: ");
                String description = scanner.nextLine();
                NetworkCard n = new NetworkCard(description);
                n.displayNetworkInfo();
            } else if (choice == 3) {
                System.out.print("Enter the target host: ");
                String target = scanner.nextLine();
                PortScan p = new PortScan(target);
                p.scanPorts();
            } else if (choice == 4) {
                String command;
                if (System.getProperty("os.name").startsWith("Windows")) {
                    command = "route print";
                } else {
                    command = "netstat -rn";
                }
                RoutingTable r = new RoutingTable(command);
                r.printRoutingTable();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }
}