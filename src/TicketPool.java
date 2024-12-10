public class TicketPool {
    private int availableTickets;
    private int maxTicketCapacity;

    public TicketPool (int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
        this.availableTickets = 0;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public int getMaxTicketCapacity () {
        return maxTicketCapacity;
    }

    public synchronized void addTicket (int ticketReleaseRate) {
        // making sure that system will not exceed the max ticket capacity
        if (availableTickets + ticketReleaseRate <= maxTicketCapacity) {
            availableTickets += ticketReleaseRate;
            Logger.system ("Added " + ticketReleaseRate + " tickets. Total tickets: " + availableTickets);
        } else {
            int ticketsToAdd = maxTicketCapacity - availableTickets;
            availableTickets = maxTicketCapacity;
            Logger.system ("Added " + ticketsToAdd + " tickets. Reached max capacity" + availableTickets);
        }
    }
    // creating the method to remove tickets from the pool
    public synchronized void removeTicket(int retrievalRate) {
        if (availableTickets >= retrievalRate) {
            availableTickets -= retrievalRate;
            Logger.system("Removed " + retrievalRate + " tickets. Remaining tickets: " + availableTickets);
        } else {
            // If there are not enough tickets, take all available tickets
            availableTickets = 0;
            Logger.system("Removed all available tickets. Remaining tickets: " + availableTickets);
        }
    }
}