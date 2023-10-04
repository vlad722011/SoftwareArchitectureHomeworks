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
         Положим на счёт пользователю некоторое количество средств:
         */
        user.setThisUserFunds(15000);

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
         Данные у пользователя будут запрашиваться до тех пор, пока пользователь не введет корректные данные
         и успешно авторизуется в сервисе. Иначе продолжать дальнейшие действия не имеет смысла. Без авторизации
         пользователь не сможет забронировать и купить билет.
        */

        do {
            System.out.print("Введите ваше имя: ");
            String inputUsername = scanner.nextLine();
            System.out.print("Введите ваш пароль: ");
            String inputPassword = scanner.nextLine();
            isUserAutorize = user.authorize(inputUsername, inputPassword);
        } while (isUserAutorize == false);

        /*
         После успешной авторизации, пользователю будет предложено выбрать маршрут.
         Данные маршрута также будут запрашиваться до тех пор, пока не будут введены корректные данные.
         (пока пользователь не введет город отправления и город прибытия). Будем считать, что любые не пустые
         данные - корректны. В качестве даты следования - выберем текущую дату.
        */

        /*
          Создадим переменную флаг (isRouteSelected = false), показывающую выбрал ли пользователь маршрут.
          До тех пор, пока пользователь не выберет маршрут, дальнейшие действия будут не возможны.
          Также введем переменные route, и date. В эти переменную будет сохранен маршрут, и желаемая
           дату поездки.
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

        // Получим количество средств у пользователя в настоящий момент:
        double userFunds = user.getThisUserFunds();

        // Получим стоимость билета на данное направление:
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


        /*
         После успешного бронирования, выполняем постусловия:
         */

        /*
         Подтверждение покупки:
         */
        System.out.println("Вы подтверждаете покупку билета?");
        String userSelected = scanner.nextLine();
        boolean isConfirmPurshaze = user.confirmPurchase(userSelected);
        if(isConfirmPurshaze){
            System.out.println("Покупка подтверждена. Сейчас с вашего счета произойдет списание средств");
            System.out.println
                    (String.format("Денег на счету пользователя до бронирования билета: %.2f рублей"
                            , user.getThisUserFunds()));

            /*
             Списание средств со счета пользователя, после подтверждения покупки:
             */
            user.deductFunds();
            System.out.println
                    (String.format("Денег на счету пользователя после оплаты билета: %.2f рублей"
                            , user.getThisUserFunds()));

            /*
            Обновление информации о наличии билетов на выбранное направление, после покупки билетов пользователем:
             */

            user.updateTicketAvailability(1);
            System.out.println("Обновлена информация о количестве доступных билетов на выбранное направление");
            System.out.println
                    (String.format("Обновленное количество доступных билетов на выбранное направление: %d."
                            , BusTicket.getCountTickets()));
        }
        else if (!(isConfirmPurshaze)){
            System.out.println("Покупка не подтверждена. Сейчас произойдет отмена брони.");

            /*
             Отмена брони:
             */
            boolean  isCancelReservation = user.cancelReservation(isConfirmPurshaze);
            if(isCancelReservation){
                System.out.println("Бронь отменена.");
                System.out.println
                        (String.format("Билетов в наличии на выбранное направление и дату, после отмены брони: %d."
                                , BusTicket.getCountTickets()));
            }
            System.out.println
                    (String.format("Денег на счету пользователя до бронирования билета: %.2f рублей"
                            , user.getThisUserFunds()));
            System.out.println
                    (String.format("Денег на счету пользователя после отмены брони: %.2f рублей"
                            , user.getThisUserFunds()));
        }
    }
}
