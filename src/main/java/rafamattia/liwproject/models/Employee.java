package rafamattia.liwproject.models;

public class Employee extends Person{
    protected String login;
    protected String password;

    public Employee(){
        super();
    }


    public Employee(String firstName, String lastName, String contact, String email, String login, String password) {
        super(firstName, lastName, contact, email);
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
