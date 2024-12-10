// importing google gson
import com.google.gson.Gson;

// importing google gson builder
import com.google.gson.GsonBuilder;

// import java file reader
import java.io.FileReader;

// importing java file writer
import java.io.FileWriter;

// importing java exception handling
import java.io.IOException;


// creating the class file
public class Configuration {
    private int totalTicketCount;
    private int ticketReleaseRate;
    private int customerRetrieveRate;
    private int maxTicketCapacity;

    public Configuration (int totalTicketCount, int ticketReleaseRate, int customerRetrieveRate, int maxTicketCapacity) {
        this.totalTicketCount = totalTicketCount;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrieveRate = customerRetrieveRate;
        this.maxTicketCapacity = maxTicketCapacity;

    }

    // creating teh getters
    public int getTotalTicketCount() {
        return totalTicketCount;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrieveRate() {
        return customerRetrieveRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    // ticket validation process configuration
    public boolean Validate () {
        return totalTicketCount >0 && ticketReleaseRate >0 && customerRetrieveRate >0&& maxTicketCapacity >0;
    }
}
