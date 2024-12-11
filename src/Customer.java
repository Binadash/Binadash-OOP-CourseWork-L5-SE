public class Customer implements Runnable {
    private int customerID;
    private int retrievalRate;
    private TicketPool ticketpool;

    public Customer (int customerID, int retrievalRate, TicketPool ticketPool) {
        this.customerID = customerID;
        this.retrievalRate = retrievalRate;
        this.ticketpool = ticketPool;
    }

    @Override
    public void run () {
        try {
            while (retrievalRate > 0){
                retrieveTickets();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void retrieveTickets() {
        if (ticketpool.getAvailableTickets() >= retrievalRate) {
            ticketpool.removeTicket(retrievalRate);
            Logger.system("[Customer " + customerID + "] retrieved " + retrievalRate + " tickets.");
        }
    }
    public void decreaseRate () {
        if (retrievalRate > 0) {
            retrievalRate --;
        }
    }

    public int getCustomerRetrievalRate () {
        return retrievalRate;
    }
}