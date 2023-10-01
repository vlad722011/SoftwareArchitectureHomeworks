package SOLID.users;

import java.util.ArrayList;
import java.util.List;

public class Hardworking extends UsersSkills {
    private User user;
    List<UsersSkills> userSkills = new ArrayList();

    public Hardworking(User user) {
        super(user);
    }

    void add() {
        Hardworking skills = new Hardworking(this.user);
        this.userSkills.add(skills);
    }

    public String toString() {
        return String.format("трудолюбивый");
    }
}
