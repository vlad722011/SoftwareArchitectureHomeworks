package onlineTicket;

import java.util.Date;

/**
 * Компонент: абстрактный class Ticket
 * Версия: 1.0.0
 *
 * Описание: Этот компонент определяет контракты абстрактного класса Ticket
 *
 * Изменения:
 * - 1.0.0: Первая версия.
 */

// Абстрактный класс и наследование
abstract class Ticket implements TicketActions {
    String routeId;
    Date departureTime;
    double price;
}
