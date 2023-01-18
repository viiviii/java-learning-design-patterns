package example._05_singleton;

class TicketMaker {
    private static final TicketMaker instance = new TicketMaker();
    
    private int ticket = 1000;

    private TicketMaker() {
    }

    public static TicketMaker getInstance() {
        return instance;
    }

    public int getNextTicketNumber() {
        return ticket++;
    }
}
