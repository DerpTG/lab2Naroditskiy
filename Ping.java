/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 1/28/2024
 * Rev: 1.0

 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ping {
    private String hostName;

    public Ping(String newHostName) {
        hostName = newHostName;
    }

    public void setHostName(String newHostName) {
        hostName = newHostName;
    }

    public String getHostName() {
        return hostName;
    }

    public void checkHostReachability() {
        try {
            InetAddress inetAddress = InetAddress.getByName(hostName);
            if (inetAddress.isReachable(5000)) {
                System.out.println(hostName + " is reachable");
            } else {
                System.out.println(hostName + " is not reachable");
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + hostName);
        } catch (Exception e) {
            System.err.println("Error while checking reachability of " + hostName + ": " + e.getMessage());
        }
    }
}
