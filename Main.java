import java.util.Scanner;

public class NetworkAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nUser Menu for System Network Analyzer:");
            System.out.println("1. Perform a network ping");
            System.out.println("2. Show the NIC (Network Interface Card) details");
            System.out.println("3. Perform a port scan on your local computer");
            System.out.println("4. Show the routing table");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter hostname to ping: ");
                String hostname = scanner.next();
                Ping p = new Ping(hostname);
                p.checkHostReachability();
            } else if (choice == 2) {
                //
                //
                NetworkCard n = new NetworkCard(/* parameters */);
                n.displayNICDetails();
            } else if (choice == 3) {
                //
                PortScan p = new PortScan(/* parameters */);
                p.scanPorts();
            } else if (choice == 4) {
                //
                RoutingTable r = new RoutingTable(/* parameters */);
                r.showRouting();
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