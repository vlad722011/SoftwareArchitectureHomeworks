package SOLID.users;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){
        User user1 = new User("Боб");
        List<UsersSkills> userBobSkills = new ArrayList<>();
        userBobSkills.add(new Persister(user1));
        userBobSkills.add(new Hardworking(user1));
        ReportForUser reportForBob = new ReportForUser(user1);
        reportForBob.save(user1,userBobSkills);

        User user2 = new User("Санчо");
        List<UsersSkills> userAlexSkills = new ArrayList<>();
        userAlexSkills.add(new Persister(user2));
        ReportForUser reportForAlex = new ReportForUser(user2);
        reportForAlex.save(user2,userAlexSkills);

        User user3 = new User("АлександЕр");
        List<UsersSkills> userAlexsanderSkills = new ArrayList<>();
        userAlexsanderSkills.add(new Loafer(user3));
        ReportForUser reportForAlexsander = new ReportForUser(user3);
        reportForAlexsander.save(user3,userAlexsanderSkills);

    }
}
