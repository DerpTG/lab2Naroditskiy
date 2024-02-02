/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 2/2/2024
 * Rev: 1.1
 */

/**
 * Import InetAddress class for IP address handling.
 */
import java.net.InetAddress;
/**
 * Import UnknownHostException to handle cases where host is not identified.
 */
import java.net.UnknownHostException;

/**
 * The Ping class is responsible for checking if a specified host is reachable.
 */
public class Ping {
    /**
     * Hostname or IP address of the target host.
     */
    private String hostName;

    /**
     * Constructs a Ping object with a specified hostname.
     * @param newHostName The hostname or IP address to be checked for reachability.
     */
    public Ping(String newHostName) {
        hostName = newHostName;
    }

    /**
     * Sets the hostname of the target host.
     * @param newHostName The new hostname or IP address to set.
     */
    public void setHostName(String newHostName) {
        hostName = newHostName;
    }

    /**
     * Gets the hostname of the target host.
     * @return The current hostname or IP address.
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * Checks if the host is reachable by attempting a network connection.
     * The reachability test uses a default timeout of 5000 milliseconds.
     */
    public void checkHostReachability() {
        try {
            InetAddress inetAddress = InetAddress.getByName(hostName);
            if (inetAddress.isReachable(5000)) {
                System.out.println(hostName + " is reachable.");
            } else {
                System.out.println(hostName + " is not reachable. Try again later.");
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostName);
        } catch (Exception e) {
            System.err.println("Error while checking reachability of " + hostName + ": " + e.getMessage());
        }
    }
}
