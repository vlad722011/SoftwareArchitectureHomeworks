package SOLID.users;

import java.util.ArrayList;
import java.util.List;

public class Loafer extends UsersSkills {
    private User user;
    List<UsersSkills> userSkills = new ArrayList();

    public Loafer(User user) {
        super(user);
    }

    void add() {
        UsersSkills skills = new Loafer(this.user);
        this.userSkills.add(skills);
    }

    public String toString() {
        return String.format("раздолбай последний");
    }
}
