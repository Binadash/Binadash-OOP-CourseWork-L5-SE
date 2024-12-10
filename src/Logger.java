import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;

public class Logger {
    private static final String LOG_FILE = "Ticketing_System.log";
    private static final String LOG_FILE1 = "Ticketing_Inputs.log";

    public static synchronized void system (String message) {
        System.out.println(message);
        try (PrintWriter writer = new PrintWriter (new FileWriter(LOG_FILE, true))) {
            writer.println(message);
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}
