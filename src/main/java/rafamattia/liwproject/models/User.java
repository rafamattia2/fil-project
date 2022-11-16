package rafamattia.liwproject.models;

public abstract class User extends Person{
    private String password;
    private String username;
    private boolean enabled;

    public User(String firstName, String lastName, String contact, String email, String username, String password) {
        super(firstName, lastName, contact, email);
        this.password=password;
        this.username=username;
        this.enabled=true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
