package SOLID.users;

public abstract class UsersSkills {
    private User user;

    protected UsersSkills(User user) {
        this.user = user;
    }

    abstract void add();
}
