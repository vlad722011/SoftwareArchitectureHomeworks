package onlineTicket;

import java.util.Date;

// Класс, представляющий пользователя системы.
class User implements UserActions {
    // Класс содержит следующие поля:
    private static String thisUserName; // имя этого пользователя
    private static String thisUserPassword; // пароль этого пользователя
    static boolean isUserAutorize; // переменная-статус пользователя (авторизован, не авторизован)
    static boolean isRouteSelected; // переменнуая-статус маршрута (выбран, не выбран)
    private double thisUserFunds; // денежные средства этого пользователя
    static boolean isConfirmPurshaze; // переменная-статус подтверждение покупки (подтвердил, не подтвердил)

    // конструктор класса
    public User(String thisUserName, String thisUserPassword) {
        this.thisUserName = thisUserName;
        this.thisUserPassword = thisUserPassword;
    }

    public static void setThisUserPassword(String thisUserPassword) {
        User.thisUserPassword = thisUserPassword;
    }

    // геттеры и сеттеры:
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


   /*
    Реализация методов имплементируемого классом интерфейса:
   */

    /**
     * <p>
     * Этот метод отвечает за авторизацию пользователя в системе. Метод немедленного возвращает true,
     * если пользователь успешно авторизуется, false в противном случае.
     * <p>
     *
     * @param username имя пользователя для его авторизации в сервисе
     * @param password пароль пользователя для авторизации в сервисе
     * @return метод возвращает true, или false.
     */
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

    /**
     * <p>
     * Этот метод отвечает за выбор маршрута пользователем. Метод немедленного возвращает true,
     * если пользователь выбрал маршрут, false в противном случае.
     * <p>
     *
     * @param routeId выбранный маршрут: - "город отбытия - город прибытия"
     * @param date    дата поездки
     * @return метод возвращает true, или false.
     * @pre User должен быть авторизован.
     */
    @Override
    public boolean selectRoute(String routeId, Date date) {
        // Изначально маршрут пользователем еще не выбран, поэтому значение переменной: - isRouteSelected = false;
        isRouteSelected = false;
        // Считаем, что если на вход в качестве параметров метода поступили данные, то эти данные считаем корректными
        // и считаем что пользователь успешно выбрал маршрут.
        String[] parts = routeId.split(" ");
        if (parts[0] == null || parts[0] == "") {
            System.out.println("Не выбран город отбытия. Маршрут не выбран.");
        }
        if (parts[2] == null || parts[2] == "") {
            System.out.println("Не выбран город прибытия. Маршрут не выбран.");
        }
        if ((parts[0] != null && parts[0] != "") && (parts[2] != null && parts[2] != "")) {
            isRouteSelected = true;
        }
        return isRouteSelected;
    }

    /**
     * <p>
     * Этот метод отвечает за проверку доступности билетов на выбранное направление:
     * если билеты на данное направление есть метод вернет true, false в противном случае.
     * <p>
     *
     * @param route выбранный маршрут: - "город отбытия - город прибытия"
     * @param date  дата поездки
     * @return метод возвращает true, или false.
     * @pre User должен быть авторизован.
     * @pre Маршрут должен быть выбран.
     */
    @Override
    public boolean checkTicketAvailability(String route, Date date) {
        int countTickets = BusTicket.getCountTickets();
        if (countTickets > 0) {
            System.out.println(String.format("Билетов в наличии: %d.", countTickets));
            boolean isTicketAvailable = true;
        }
        return false;
    }

    /**
     * <p>
     * Этот метод отвечает за проверку достаточности количества средств у пользователя для приобретения билета
     * если средств достаточно метод вернет true, false в противном случае.
     * <p>
     *
     * @param ticketPrice стоимость билета на выбранное направление
     * @param userFunds   количество средств на счету у пользователя
     * @return метод возвращает true, или false.
     * @pre User должен быть авторизован.
     * @pre Маршрут должен быть выбран.
     * @pre Билеты на выбранный маршрут и время должны быть доступны.
     * @post Билет забронирован.
     */
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

    /*
    Реализация методов класса (переопределение):
   */

    /**
     * <p>
     * Этот метод отвечает за авторизацию пользователя в системе. Метод немедленного возвращает true,
     * если пользователь успешно авторизуется, false в противном случае.
     * <p>
     *
     * @return метод возвращает true, или false.
     */
    private boolean isAuthorized() {
        return isUserAutorize;
    }

    /**
     * <p>
     * Этот метод отвечает за выбор маршрута пользователем. Метод немедленного возвращает true,
     * если пользователь выбрал маршрут, false в противном случае.
     * <p>
     *
     * @return метод возвращает true, или false.
     * @pre User должен быть авторизован.
     */
    private boolean isRouteSelected() {
        return isRouteSelected;
    }

    /**
     * <p>
     * Этот метод отвечает за проверку доступности билетов на выбранное направление:
     * если билеты на данное направление есть метод вернет true, false в противном случае.
     * <p>
     *
     * @return метод возвращает true, или false.
     * @pre User должен быть авторизован.
     * @pre Маршрут должен быть выбран.
     */
    private boolean checkTicketAvailability() {
        boolean isCheckTicketAvailable = false;
        int count = BusTicket.getCountTickets();
        if (count > 0) {
            isCheckTicketAvailable = true;
        }
        return isCheckTicketAvailable;
    }

    /**
     * <p>
     * Этот метод отвечает за проверку достаточности количества средств у пользователя для приобретения билета
     * если средств достаточно метод вернет true, false в противном случае.
     * <p>
     *
     * @return метод возвращает true, или false.
     * @pre User должен быть авторизован.
     * @pre Маршрут должен быть выбран.
     * @pre Билеты на выбранный маршрут и время должны быть доступны.
     * @post Билет забронирован.
     */
    private boolean checkFunds() {
        double funds = getThisUserFunds();
        double price = BusTicket.getTicketPrice();
        boolean isCheckFunds = false;
        if (funds >= price) {
            isCheckFunds = true;
        }
        return isCheckFunds;
    }

    /**
     * Попытка забронировать билет.
     * <p>
     * Этот метод позволяет пользователю попытаться забронировать билет на выбранный маршрут и время.
     * Для успешной бронировки необходимо выполнение следующих условий:
     * - Пользователь должен быть предварительно авторизован в системе (authorize).
     * - Пользователь должен выбрать конкретный маршрут и время (selectRoute).
     * - Должны быть доступны билеты на выбранный маршрут и время (checkTicketAvailability).
     * - У пользователя должно быть достаточно средств для бронирования (checkFunds)
     * Если все предусловия выполняются, билет будет успешно забронирован, и метод вернет true.
     * В противном случае, если хотя бы одно из предусловий не выполняется, бронирование не будет произведено,
     * и метод вернет false.
     * <p>
     *
     * @return true, если бронирование успешно, false в противном случае.
     * @pre User должен быть авторизован и выбран маршрут.
     * @pre Билеты на выбранный маршрут и время должны быть доступны.
     * @pre У пользователя должно быть достаточно средств для бронирования.
     * @post Билет забронирован.
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
        if (isAuthorized() && isRouteSelected() && checkTicketAvailability() && checkFunds()) {
            isPerformReservation = true;
            return true;
        }
        return isPerformReservation;
    }

    /**
     * <p>
     * Этот метод отвечает за бронирование билетов, если все предусловия выполнены
     * В случае выполнения всех условий, билеты будут забронированы, и метод вернет true,
     * в противном случае, если не выполнится хоть одно из предусловий, метод вернет false.
     * <p>
     *
     * @return метод возвращает true, или false.
     * @pre User должен быть авторизован.
     * @pre Маршрут должен быть выбран.
     * @pre Билеты на выбранный маршрут и время должны быть доступны.
     * @post Билет забронирован.
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
    Постусловия:
     */

    /**
     * <p>
     * Этот метод отвечает за подтверждение пользователем покупки билета.
     * Метод вернет true, если пользователь подтверждает покупку билета.
     * В противном случае, если пользователь покупку не подтверждает, метод вернет false.
     * <p>
     * @return метод возвращает true, или false.
     * @pre User должен быть авторизован.
     * @pre Маршрут должен быть выбран.
     * @pre Билеты на выбранный маршрут и время должны быть доступны.
     * @post Билет забронирован.
     */
    public boolean confirmPurchase(String userSelection) {
        boolean isConfirmPurchase = false;
        switch (userSelection) {
            case "Yes":
            case "YEs":
            case "YES":
            case "yes":
            case "yES":
            case "yeS":
            {
                isConfirmPurchase = true;
                break;
            }
            case "No":
            case "NO":
            case "no":
            case "nO":
            {
                break;
            }
            default:
                break;
        }
        return isConfirmPurchase;
    }

    /**
     * <p>
     * Этот метод отвечает за списание средств со счета пользователя после покупки билета.
     * Метод вернет true, если со счета пользователя успешно списаны средства в размере стоимости билета.
     * В противном случае, если средства не списаны, метод вернет false.
     * <p>
     * @return метод возвращает true, или false.
     * @pre User должен быть авторизован.
     * @pre Маршрут должен быть выбран.
     * @pre Билеты на выбранный маршрут и время должны быть доступны.
     * @post Билет забронирован.
     * @post Средства со счета списаны.
     */
    public boolean deductFunds() {
        boolean isDeductFunds = false;
        if (this.reserveTicket()) {
            double funds = getThisUserFunds() - BusTicket.getTicketPrice();
            setThisUserFunds(funds);
            isDeductFunds = true;
        }
        return isDeductFunds;
    }

    /**
     * <p>
     * Этот метод отвечает за обновление информации о наличии билетов на выбранное направление и дату
     * после покупки пользователем билета.
     * Метод обновит в базе данных количество билетов на выбранное направление и дату.
     * <p>
     * @return  count, метод возвращает в базу данных обновленное количество доступных билетов на выбранный маршрут.
     * @param countOfPurshasedTickets количество билетов купленных пользователем.
     * @pre User должен быть авторизован.
     * @pre Маршрут должен быть выбран.
     * @pre Билеты на выбранный маршрут и время должны быть доступны.
     * @post Билет забронирован.
     * @post Покупка билетов подтверждена.
     * @post Средства со счета списаны.
     */
    public int updateTicketAvailability(int countOfPurshasedTickets) {
        int count = BusTicket.getCountTickets() - countOfPurshasedTickets;
        BusTicket.count = count;
        return BusTicket.count;
    }

    /**
     * <p>
     * Этот метод отвечает за обновление информации о наличии билетов на выбранное направление и дату
     * после покупки пользователем билета.
     * Метод обновит в базе данных количество билетов на выбранное направление и дату.
     * <p>
     * @return  count, метод возвращает в базу данных обновленное количество доступных билетов на выбранный маршрут.
     * @param isConfirmPurshaze Если isConfirmPurshaze = true, значит пользователь подтвердил покупку билетов,
     *                          и отмены бронирования не произойдет. Если isConfirmPurshaze = false, значит пользователь
     *                          решил отменить бронь.
     * @pre User должен быть авторизован.
     * @pre Маршрут должен быть выбран.
     * @pre Билеты на выбранный маршрут и время должны быть доступны.
     * @post Билет забронирован.
     * @post Покупка билетов не подтверждена.
     * @post Средства со счета не списаны.
     */
    public boolean cancelReservation(boolean isConfirmPurshaze) {
        boolean isCancelReservation = false;
        if (!(isConfirmPurshaze)) {
            isCancelReservation = true;
        }
        return isCancelReservation;
    }
}



