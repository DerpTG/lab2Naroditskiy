/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 2/2/2024
 * Rev: 1.1
 */

/**
 * Import InetAddress class for handling IP addresses.
 */
import java.net.InetAddress;
/**
 * Import NetworkInterface class for accessing network interface information.
 */
import java.net.NetworkInterface;
/**
 * Import SocketException to handle exceptions related to accessing network interfaces.
 */
import java.net.SocketException;
/**
 * Import Enumeration to iterate through collections such as lists of network interfaces or addresses.
 */
import java.util.Enumeration;

/**
 * Represents a network interface card (NIC) and facilitates the display of its and other network information.
 */
public class NetworkCard {

    /**
     * The description for this network card.
     */
    private String nDescription;

    /**
     * Constructs a NetworkCard object with a specific description.
     * @param description The description of the network card.
     */
    public NetworkCard(String description) {
        nDescription = description;
    }

    /**
     * Retrieves the description of this network card.
     * @return The current description of the network card.
     */
    public String getDescription() {
        return nDescription;
    }

    /**
     * Sets or updates the description of this network card.
     * @param description The new description for the network card.
     */
    public void setDescription(String description) {
        nDescription = description;
    }

    /**
     * Displays detailed information about the network card, local host, and available network interfaces.
     * It includes local hostname, IP address, and iterates over all network interfaces to print their details.
     */
    public void displayNetworkInfo() {
        System.out.println("Network Description: " + nDescription);

        try {
            /**
             * Attempt to obtain and display local host information.
             */
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Local Hostname: " + localhost.getHostName());
            System.out.println("Local IP Address: " + localhost.getHostAddress());

            /**
             * Enumerates through all network interfaces on the device, displaying their names,
             * MAC addresses (if available), and associated IP addresses.
             */
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Interface Name: " + networkInterface.getDisplayName());

                if (networkInterface.getHardwareAddress() != null) {
                    System.out.println("Interface Hardware Address: " + formatMACAddress(networkInterface.getHardwareAddress()));
                }

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("IP Address: " + inetAddress.getHostAddress());
                }
                System.out.println(); // Adds a blank line for better readability between interface details
            }
        } catch (SocketException e) {
            /**
             * Handles exceptions related to accessing network interface information.
             */
            e.printStackTrace();
        } catch (Exception e) {
            /**
             * Catches and handles any other unforeseen exceptions that occur during information retrieval.
             */
            e.printStackTrace();
        }
    }

    /**
     * Formats and returns a human-readable string of a MAC address from its byte array representation.
     * @param mac The MAC address as a byte array.
     * @return The formatted MAC address as a string.
     */
    private static String formatMACAddress(byte[] mac) {
        StringBuilder formattedMAC = new StringBuilder();
        for (byte b : mac) {
            formattedMAC.append(String.format("%02X:", b));
        }
        if (formattedMAC.length() > 0) {
            formattedMAC.deleteCharAt(formattedMAC.length() - 1); // Remove the trailing colon
        }
        return formattedMAC.toString();
    }
}
