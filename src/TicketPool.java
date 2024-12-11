// creating the class
public class TicketPool {

    // Number of tickets currently available in the pool
    private int availableTickets;

    // Maximum number of tickets the pool can hold
    private int maxTicketCapacity;

    // Constructor to initialize the ticket pool with a maximum capacity
    public TicketPool (int maxTicketCapacity) {
        // Set the maximum ticket capacity
        this.maxTicketCapacity = maxTicketCapacity;
        // Initialize available tickets to 0
        this.availableTickets = 0;
    }

    // Getter method to retrieve the number of available tickets
    public int getAvailableTickets() {
        return availableTickets;
    }

    // Getter method to retrieve the maximum ticket capacity of the pool
    public int getMaxTicketCapacity () {
        return maxTicketCapacity;
    }

    /**
     * Adds tickets to the pool in a thread-safe manner.
     * Ensures that the total number of tickets does not exceed the maximum capacity.
     *
     * ticketReleaseRate The number of tickets to add
     **/
    public synchronized void addTickets (int ticketReleaseRate) {

        // Check if adding the tickets exceeds the maximum capacity
        if (availableTickets + ticketReleaseRate <= maxTicketCapacity) {
            // Add tickets if within capacity
            availableTickets += ticketReleaseRate;
            Logger.system ("Added " + ticketReleaseRate + " tickets. Total tickets: " + availableTickets);
        } else {
            // Calculate how many tickets can be added to reach maximum capacity
            int ticketsToAdd = maxTicketCapacity - availableTickets;
            // Set available tickets to maximum capacity
            availableTickets = maxTicketCapacity;
            Logger.system ("Added " + ticketsToAdd + " tickets. Reached max capacity" + availableTickets);
        }
    }

    /**
     * Removes tickets from the pool in a thread-safe manner.
     * Ensures that the pool does not have negative tickets.
     *
     * retrievalRate The number of tickets to remove
     **/
    public synchronized void removeTicket(int retrievalRate) {
        // Check if there are enough tickets to remove the requested amount
        if (availableTickets >= retrievalRate) {
            // Remove the requested number of tickets
            availableTickets -= retrievalRate;
            Logger.system("Removed " + retrievalRate + " tickets. Remaining tickets: " + availableTickets);
        } else {
            // If not enough tickets are available, remove all remaining tickets
            availableTickets = 0;
            Logger.system("Removed all available tickets. Remaining tickets: " + availableTickets);
        }
    }
}