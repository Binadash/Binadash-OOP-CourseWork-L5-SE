public class Customer implements Runnable {
    private int CustomerID;
    private int retrievalRate;
    private int ticketPool;

    public Customer (int customerID, int retrievalRate, int ticketPool) {
        this.CustomerID = customerID;
        this.retrievalRate = retrievalRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run () {
        try {
            while (retrievalRate > 0){
                retrieveTickets();
                Thread.sleep(1000);

            }
        }
    }

    public void retrieveTickets () {
        if (ticketPool.getAvailableTickets () >= retrievalRate) {
            ticketPool.removeTicket(retrievalRate);
            Logger.system ("[ Customer " + customerID + " ] retrieved " + retrievalRate + " tickets.");
        }
    }
    pubic void decreaseRate () {
        if (retrievalRate > 0) {
            retrievalRate --;
        }
    }

    public int getCustomerRetrievalRate () {
        return retrievalRate;
    }
}