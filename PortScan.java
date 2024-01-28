/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 1/28/2024
 * Rev: 1.0

 */

import java.net.Socket;
import java.io.IOException;

public class PortScan {
    private String targetHost;

    public PortScan(String target) {
        targetHost = target;
    }

    public String getTargetHost() {
        return targetHost;
    }

    public void setTargetHost(String target) {
        targetHost = targetHost;
    }

    public void scanPorts() {
        int minPort = 1;
        int maxPort = 65535;

        System.out.println("Scanning ports on " + targetHost + "...");

        for (int port = minPort; port <= maxPort; port++) {
            try {
                Socket socket = new Socket(targetHost, port);
                System.out.println("Port " + port + " is open");
                socket.close();
            } catch (IOException e) {
                continue;
            }
        }

        System.out.println("Port scanning finished.");
    }
}
