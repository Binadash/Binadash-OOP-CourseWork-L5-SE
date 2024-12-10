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
}