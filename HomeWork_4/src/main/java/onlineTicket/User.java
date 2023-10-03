package onlineTicket;

import java.util.Date;

// Класс, представляющий пользователя системы.
class User implements UserActions {
    private static String thisUserName;
    private static String thisUserPassword;
    static boolean isUserAutorize;
    static boolean isRouteSelected;
    private double thisUserFunds;


    public User(String thisUserName, String thisUserPassword) {
        this.thisUserName = thisUserName;
        this.thisUserPassword = thisUserPassword;
    }

    public static void setThisUserPassword(String thisUserPassword) {
        User.thisUserPassword = thisUserPassword;
    }


    public void setThisUserFunds(double thisUserFunds) {
        this.thisUserFunds = thisUserFunds;
    }

    public double getThisUserFunds() {
        return thisUserFunds;
    }

    public String getThisUserName() {
        return thisUserName;
    }

    public String getThisUserPassword() {
        return thisUserPassword;
    }

    public void setThisUserName(String thisUserName) {
        this.thisUserName = thisUserName;
    }

    public void setPasswordThisUser(String passwordThisUser) {
        this.thisUserPassword = thisUserPassword;
    }


    @Override
    public boolean authorize(String username, String password) {
        thisUserName = getThisUserName();
        thisUserPassword = getThisUserPassword();
         /*
          Проверка соответствия введенных данных сохраненным значениям
          Предположим, что данные введенные пользователем в консоли совпадают с данными
          полученными из базы данных пользователей сервиса.
         */
        if (username.equalsIgnoreCase(thisUserName) && password.equalsIgnoreCase(thisUserPassword)) {
            System.out.println("Вы успешно авторизовались в системе!");
            isUserAutorize = true;
        } else {
            System.out.println("Неверное имя пользователя или пароль.");
            isUserAutorize = false;
        }
        return isUserAutorize;
    }

    @Override
    public boolean selectRoute(String routeId, Date time) {
        // Изначально маршрут пользователем еще не выбран, поэтому значение переменной: - isRouteSelected = false;
        isRouteSelected = false;
        // Считаем, что если на вход в качестве параметров метода поступили данные, то эти данные считаем корректными
        // и считаем что пользователь успешно выбрал маршрут.
        String[] parts = routeId.split(" ");
        if(parts[0] == null || parts[0] == ""){
            System.out.println("Не выбран город отбытия. Маршрут не выбран.");
        }
        if(parts[2] == null || parts[2] == ""){
            System.out.println("Не выбран город прибытия. Маршрут не выбран.");
        }
        if ((parts[0] != null && parts[0]!= "") && (parts[2] != null && parts[2]!= "")) {
            isRouteSelected = true;
        }
        return isRouteSelected;
    }

    @Override
    public boolean checkTicketAvailability(String route, Date date) {
        int countTickets = BusTicket.getCountTickets();
        if (countTickets > 0) {
            System.out.println(String.format("Билетов в наличии: %d.", countTickets));
            boolean isTicketAvailable = true;
        }
        return false;
    }

    @Override
    public boolean checkFunds(double ticketPrice, double userFunds) {
        boolean isCheckFunds = false;
        if (userFunds >= ticketPrice) {
            System.out.println("У вас достаточно средств, вы можете приобрести билет.");
            isCheckFunds = true;
            return isCheckFunds;
        } else {
            System.out.println("У вас недостаточно средств для приобретения билета");
        }
        return isCheckFunds;
    }

    private boolean checkFunds() {
        double funds = getThisUserFunds();
        double price = BusTicket.getTicketPrice();
        boolean isCheckFunds = false;
        if(funds >= price){
            isCheckFunds = true;
        }
        return isCheckFunds;
    }

    private boolean checkTicketAvailability() {
        boolean isCheckTicketAvailable = false;
        int count = BusTicket.getCountTickets();
        if ( count > 0){
            isCheckTicketAvailable = true;
        }
        return isCheckTicketAvailable;
    }

    private boolean isRouteSelected() {
        return isRouteSelected;
    }

    private boolean isAuthorized() {
        return isUserAutorize;
    }

    /**
     * Попытка забронировать билет.
     *
     * @return true, если бронирование успешно, false в противном случае.
     * @pre User должен быть авторизован и выбран маршрут.
     * @pre Билеты на выбранный маршрут и время должны быть доступны.
     * @pre У пользователя должно быть достаточно средств для бронирования.
     * @post Билет забронирован.
     * <p>
     * Этот метод позволяет пользователю попытаться забронировать билет на выбранный маршрут и время.
     * Для успешной бронировки необходимо выполнение следующих условий:
     * - Пользователь должен быть предварительно авторизован в системе (authorize).
     * - Пользователь должен выбрать конкретный маршрут и время (selectRoute).
     * - Должны быть доступны билеты на выбранный маршрут и время (checkTicketAvailability).
     * - У пользователя должно быть достаточно средств для бронирования (checkFunds).
     * <p>
     * Если все предусловия выполняются, билет будет успешно забронирован, и метод вернет true.
     * В противном случае, если хотя бы одно из предусловий не выполняется, бронирование не будет произведено, и метод вернет false.
     */

    private boolean performReservation() {
        // Проверка всех предусловий для возможности совершить бронирование билета
        boolean isPerformReservation = false;
        // Проверка предусловий
        if (!isAuthorized()) {
            System.out.println("Пользователь не авторизован");
            return false;
        }
        if (!isRouteSelected()) {
            System.out.println("Маршрут не выбран");
            return false;
        }
        if (!checkTicketAvailability()) {
            System.out.println("Билеты не доступны");
            return false;
        }
        if (!checkFunds()) {
            System.out.println("Недостаточно средств");
            return false;
        }
        if(isAuthorized() && isRouteSelected() && checkTicketAvailability() && checkFunds()){
            isPerformReservation = true;
            return true;
        }
        return isPerformReservation;
    }

    /*
     Если все предусловия соблюдены, пытаемся забронировать билет:
    */
    public boolean reserveTicket() {
        // Реализация бронирования билета
        if (performReservation()) {
            // Постусловие: Билет успешно забронирован
            return true;
        } else {
            return false; // Ошибка при бронировании
        }
    }




    /*
      Если пользователю удалось забронировать билет, то далее необходимо выполнить все постусловия.
    */





    public boolean deductFunds() {
        // Реализация метода
        return false;
    }


    public boolean confirmPurchase() {
        // Реализация метода
        return false;
    }


    public void updateTicketAvailability() {
        // Реализация метода
    }

    public boolean cancelReservation() {
        // Реализация метода
        return false;
    }


}



