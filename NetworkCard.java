/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 1/28/2024
 * Rev: 1.0

 */

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkCard {

    private String nDescription;

    public NetworkCard(String description) {
        nDescription = description;
    }

    public String getDescription() {
        return nDescription;
    }

    public void setDescription(String description) {
        nDescription = description;
    }

    public void displayNetworkInfo() {
        System.out.println("Network Description: " + nDescription);

        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Local Hostname: " + localhost.getHostName());
            System.out.println("Local IP Address: " + localhost.getHostAddress());

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Interface Name: " + networkInterface.getDisplayName());
                if (networkInterface.getHardwareAddress() != null){
                    System.out.println("Interface Hardware Address: " + formatMACAddress(networkInterface.getHardwareAddress()));
                }
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("IP Address: " + inetAddress.getHostAddress());
                }
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String formatMACAddress(byte[] mac) {
        StringBuilder formattedMAC = new StringBuilder();
        for (byte b : mac) {
            formattedMAC.append(String.format("%02X:", b));
        }
        if (formattedMAC.length() > 0) {
            formattedMAC.deleteCharAt(formattedMAC.length() - 1);
        }
        return formattedMAC.toString();
    }
}