package onlineTicket;

class BusTicket extends Ticket {
    int number;

    public static double getTicketPrice() {
        return 29000;
    }

    public static int getCountTickets() {
        int count = 49;
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
