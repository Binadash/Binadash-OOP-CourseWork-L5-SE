import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main{
    public  static void main (String[]args) {
        Scanner scanner = new Scanner (System.in);

        try {
            Logger.system("Welcome to the Ticketing System !");

            int totalTickets = getPositiveInt (scanner, "Enter The Total Number Of Tickets : " , "Total Tickets : ");
            int ticketReleaseRate = getPositiveInt (scanner, "Enter Ticket Release Rate : " , "Ticket Release Rate : ");
            int customerRetrievalRate = getPositiveInt (scanner, "Enter Customer Ticket Retrieval Rate : " , "Customer Ticket Retrieval Rate : ");
            int maxTicketCapacity = getPositiveInt (scanner, "Enter Maximum Ticket Capacity : " , "Maximum Ticket Capacity : ");

            Configuration config = new Configuration (totalTickets , ticketReleaseRate , customerRetrievalRate , maxTicketCapacity);
            if (!config.Validate ()) {
                Logger.system ("Invalid Configuration... Exiting The System...");
                return;
            }

            TicketPool ticketPool = new TicketPool( (config.getMaxTicketCapacity()));





        }
    }
    private static int getPositiveInt (Scanner scanner, String prompt, String label) {
        int value;
        while (true) {
            Logger.system(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                Logger.userInput(label + value);
                if (value > 0) {
                    break;
                } else {
                    Logger.system ("Please Enter a Positive Number : ");
                }
            } catch (NumberFormatException e) {
                Logger.system ("Invalid Integer. Please Enter A Positive Number : ")
            }
        }
        return value;
    }
}