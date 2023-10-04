package onlineTicket;

/**
 * Компонент: class BusTicket
 * Версия: 1.0.0
 *
 * Описание: Этот компонент определяет контракты для билетов на автобус
 *
 * Изменения:
 * - 1.0.0: Первая версия.
 */

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
