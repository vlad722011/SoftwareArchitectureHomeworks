package onlineTicket;

class BusTicket extends Ticket {
    static int count = 49;

    public static double getTicketPrice() {
        return 9000;
    }

    public static int getCountTickets() {
        return count;
    }

    @Override
    public boolean reserveTicket() {
        // Реализация метода
        return false;
    }

    @Override
    public boolean deductFunds() {
        // Реализация метода
        return false;
    }

    @Override
    public boolean confirmPurchase() {
        // Реализация метода
        return false;
    }

    @Override
    public void updateTicketAvailability() {
        // Реализация метода
    }

    @Override
    public boolean cancelReservation() {
        // Реализация метода
        return false;
    }
}
