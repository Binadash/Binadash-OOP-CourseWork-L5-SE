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

            TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

            Vendor vendor1 = new Vendor (1 , config.getTicketReleaseRate (), ticketPool);
            Vendor vendor2 = new Vendor (2 , config.getTicketReleaseRate () , ticketPool );
            Customer customer1 = new Customer(1, config.getCustomerRetrievalRate(), ticketPool);
            Customer customer2 = new Customer(2, config.getCustomerRetrievalRate(), ticketPool);

            ExecutorService executor = Executors.newFixedThreadPool(4);
            executor.execute (vendor1);
            executor.execute (vendor2);
            executor.execute (customer1);
            executor.execute (customer2);

            for (int i = 0; i <20; i++) {
                Logger.system ("Round " + (i + 1) + " :");
                Logger.system ("Total Tickets : " + config.getTotalTicketCount ());
                Logger.system ("Vendor Release Rate : " + vendor1.getTicketReleaseRate () + "Tickets / Second");
                Logger.system ("Customer Retrieval Rate : " + customer1.getCustomerRetrievalRate () + "Tickets / Seconds");
                Logger.system ("Maximum Ticket Capacity : " + config.getMaxTicketCapacity () + "Tickets");

                vendor1.releaseTickets();
                vendor2.releaseTickets();

                customer1.retrieveTickets();
                customer2.retrieveTickets();

                vendor1.decreaseRate();
                vendor2.decreaseRate();
                customer1.decreaseRate();
                customer2.decreaseRate();

                Thread.sleep (1000);
            }

            executor.shutdown ();
            Logger.system ("All Tickets Have Been Sold, System Executed");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Logger.system ("Main Thread Has interrupted : " + e.getMessage());
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
                Logger.system ("Invalid Integer. Please Enter A Positive Number : ");
            }
        }
        return value;
    }
}