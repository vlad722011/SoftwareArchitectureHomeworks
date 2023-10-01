package SOLID.users;

import java.util.ArrayList;
import java.util.List;

public class Persister extends UsersSkills {
    private User user;
    List<UsersSkills> userSkills = new ArrayList();

    public Persister(User user) {
        super(user);
    }

    void add() {
        UsersSkills skills = new Persister(this.user);
        this.userSkills.add(skills);
    }

    public String toString() {
        return String.format("упорный");
    }
}
