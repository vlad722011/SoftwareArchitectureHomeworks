package SOLID.users;

import java.util.ArrayList;
import java.util.List;

public interface SaveReportForUser {
    User user = null;
    List<UsersSkills> userSkills = new ArrayList();

    void save(User var1, List<UsersSkills> var2);
}
