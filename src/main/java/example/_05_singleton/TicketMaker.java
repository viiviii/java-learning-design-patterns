package example._05_singleton;

final class TicketMaker {
    private static final TicketMaker INSTANCE = new TicketMaker();

    private int ticket = 1000;

    private TicketMaker() {
    }

    public static TicketMaker getInstance() {
        return INSTANCE;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
