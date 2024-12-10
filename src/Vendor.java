public class Vendor implements Runnable {
    private int vendorID;
    private int ticketReleaseRate;
    private final TicketPool ticketPool;

    public Vendor (int vendorID, int ticketReleaseRate, TicketPool ticketPool) {
        this.vendorID = vendorID;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run () {
        try {
            while (ticketReleaseRate > 0) {
                releaseTickets();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void releaseTickets () {
        if (ticketPool.getAvailableTickets() + ticketReleaseRate <= ticketPool.getMaxTicketCapacity()) {
            ticketPool.addTicket(ticketReleaseRate);
            Logger.system (" [ vendor " + vendorID + " ] added " + ticketReleaseRate + " tickets.");
        }
    }

    public void decreaseRate () {
        if (ticketReleaseRate > 0) {
            ticketReleaseRate --;
        }
    }

    public int getTicketReleaseRate () {
        return ticketReleaseRate;
    }

}
