/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 1/28/2024
 * Rev: 1.0

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoutingTable {
    private String osType;

    public RoutingTable(String osCommand) {
        osType = osCommand;
    }

    public String getOsCommand() {
        return osType;
    }

    public void setOsCommand(String osCommand) {
        osType = osCommand;
    }

    public void printRoutingTable() {
        try {
            Process process = Runtime.getRuntime().exec(osType);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
