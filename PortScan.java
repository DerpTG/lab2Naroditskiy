/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 2/2/2024
 * Rev: 1.1
 */

/**
 * Import Socket class for network communication.
 */
import java.net.Socket;
/**
 * Import IOException to handle input-output exceptions during network operations.
 */
import java.io.IOException;

/**
 * Provides functionality to scan ports on a specified target host to determine open ports.
 */
public class PortScan {
    /**
     * The hostname or IP address of the target host for port scanning.
     */
    private String targetHost;

    /**
     * Initializes a PortScan object for a specific target.
     * @param target The hostname or IP address of the target host.
     */
    public PortScan(String target) {
        targetHost = target;
    }

    /**
     * Returns the target host's hostname or IP address.
     * @return The target host.
     */
    public String getTargetHost() {
        return targetHost;
    }

    /**
     * Sets a new target host for the port scan.
     * @param target The hostname or IP address of the new target host.
     */
    public void setTargetHost(String target) {
        targetHost = target;
    }

    /**
     * Performs a scan of all ports in the range 1-65535 on the target host,
     * reporting which ports are open. Open ports have a listening service.
     */
    public void scanPorts() {
        System.out.println("Scan starting for " + targetHost);
        for (int port = 1; port <= 65535; port++) {
            try (Socket socket = new Socket(targetHost, port)) {
                System.out.println("Port " + port + " is open.");
            } catch (IOException e) {
                continue;
            }
        }
        System.out.println("Port scanning on " + targetHost + " completed.");
    }
}
