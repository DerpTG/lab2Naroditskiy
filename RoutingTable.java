/** Project: Lab2 Network Analyzer
 * Purpose Details: To perform network functions via Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 1/28/2024
 * Last Date Changed: 2/2/2024
 * Rev: 1.1
 */

/**
 * Import BufferedReader for reading text from input streams.
 */
import java.io.BufferedReader;
/**
 * Import IOException to handle input-output exceptions.
 */
import java.io.IOException;
/**
 * Import InputStreamReader to read bytes and decode them into characters.
 */
import java.io.InputStreamReader;

/**
 * Handles the display of the system's routing table based on the specified OS command.
 */
public class RoutingTable {
    /**
     * Command to execute for displaying the routing table, varies by operating system.
     */
    private String osType;

    /**
     * Constructs a RoutingTable instance with a specific command for the operating system.
     * @param osCommand The command to display the routing table.
     */
    public RoutingTable(String osCommand) {
        osType = osCommand;
    }

    /**
     * Retrieves the command used to display the routing table.
     * @return The command for the current operating system.
     */
    public String getOsCommand() {
        return osType;
    }

    /**
     * Sets a new command for displaying the routing table.
     * @param osCommand The new command to be set.
     */
    public void setOsCommand(String osCommand) {
        osType = osCommand;
    }

    /**
     * Executes the system command to display the routing table, printing the output to the console.
     * Utilizes a BufferedReader to read the output stream of the process.
     */
    public void printRoutingTable() {
        try {
            /**
             * Executes the command to display the routing table.
             */
            Process process = Runtime.getRuntime().exec(osType);
            /**
             * BufferedReader to read the command output.
             */
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            /**
             * Reads and prints each line of the command's output.
             */
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            /**
             * Closes the BufferedReader.
             */
            reader.close();
            /**
             * Waits for the process to complete.
             */
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            /**
             * Handles and prints any exceptions that occur during execution.
             */
            e.printStackTrace();
        }
    }
}

