public class Vendor implements Runnable {
    private int vendorID;
    private int ticketReleaseRate;
    private final TicketPool ticketPool;

    public Vendor (int vendorID, int ticketReleaseRate, TicketPool ticketPool) {
        this.vendorID = vendorID;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }


}
