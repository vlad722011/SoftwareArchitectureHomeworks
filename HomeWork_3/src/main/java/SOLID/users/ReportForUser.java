package SOLID.users;

import java.util.ArrayList;
import java.util.List;

public class ReportForUser implements SaveReportForUser {
    private User user;
    List<UsersSkills> userSkills = new ArrayList();

    public ReportForUser(User user) {
        this.user = user;
    }

    public void save(User user, List<UsersSkills> userSkills) {
        System.out.println("Пользователь: " + user.getName());
        System.out.print("Характеристика пользователя: ");
        System.out.println(user.getName() + " - > " + userSkills.toString());
    }
}
