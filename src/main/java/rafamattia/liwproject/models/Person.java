package rafamattia.liwproject.models;

public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Person() {
    }

    public Person(String firstName, String lastName, String contact, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = contact;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
