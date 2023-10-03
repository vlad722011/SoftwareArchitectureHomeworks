package onlineTicket;


import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         Создаем экземпляр пользователя
        */
        User user = new User("Vlad", "1");

        /*
         Положим на счте пользователю энное количество средств:
         */
        user.setThisUserFunds(20000);

        /*
        Создание объекта Scanner для чтения пользовательского ввода
        */
        Scanner scanner = new Scanner(System.in);

        /*
          Создадим переменную флаг (isUserAutorize = false), показывающую авторизован ли пользователь в системе.
          До тех пор, пока пользователь не авторизуется в системе, он не сможет выбирать маршрут.
        */

        boolean isUserAutorize = false;
        /*
         Введем данные пользователя для авторизации:
        */
        do {
            System.out.print("Введите ваше имя: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Введите ваш пароль: ");
            String inputPassword = scanner.nextLine();
            isUserAutorize = user.authorize(inputUsername, inputPassword);
        } while (isUserAutorize == false);

        /*
         Введем данные маршрута и выберем дату следования.
        */
        boolean isRouteSelected = false;
        String route = "";
        Date date = new Date();
        do {
            System.out.print("Введите город отправления: ");
            String departureCity = scanner.nextLine();
            System.out.print("Введите город прибытия: ");
            String arrivalCity = scanner.nextLine();
            arrivalCity = arrivalCity + " " + ".";
            route = departureCity + " - " + arrivalCity;
            isRouteSelected = user.selectRoute(route, date);
        } while (isRouteSelected == false);


        /*
         Предположим, что данные введенные пользователем (если пользователь введет хоть какие-то данные)
         будут считаться корректными, и будут соответствовать данным, содержавшимся в базе доступных городов
         следования автотранспорта предприятия.
         Если пользователь при вводе оставит пустым любое из полей (город отправления или город прибытия),
         то будем считать, что маршрут не выбран.
        */

        user.selectRoute(route, date);
        if (user.selectRoute(route, date)) {
            System.out.println("Маршрут выбран успешно");
            System.out.println("Вы собираетесь следовать по маршруту: " + route);
            System.out.println("Время отправления: " + date);
        } else if (!(user.selectRoute(route, date))) {
            System.out.println("Маршрут не выбран");
        }

        /*
         Проверим наличие билетов по данному направлению.
         */
        user.checkTicketAvailability(route, date);

        /*
         Проверка наличия достаточных средств у пользователя для приобретения билета на данное направление.
        */

        // Проверим наличие средств у пользователя в настоящий момент:
        double userFunds = user.getThisUserFunds();

        // Узнаем стоимость билета на данное направление:
        double ticketPrice = BusTicket.getTicketPrice();

        // Проверяем достаточно ли у пользователя средств для приобретения билета:
        user.checkFunds(ticketPrice, userFunds);

        // Пытаемся забронировать билет
        boolean isBookingSuccessful = user.reserveTicket();

        // Проверяем результат
        if (isBookingSuccessful) {
            System.out.println("Билет успешно забронирован.");
        } else {
            System.out.println("Не удалось забронировать билет.");
        }
    }
}
