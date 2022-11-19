package rafamattia.liwproject.models;

import rafamattia.liwproject.models.enuns.Status;

public class Client extends Person{
    private int activeServices;
    private int totalServices;

    public Client(){
        super();
    }


    public Client(String firstName, String lastName, String contact, String email) {
        super(firstName, lastName, contact, email);
    }


    public int getActiveServices() {
        return activeServices;
    }

    public void setActiveServices(int activeServices) {
        this.activeServices = activeServices;
    }

    public int getTotalServices() {
        return totalServices;
    }

    public void setTotalServices(int totalServices) {
        this.totalServices = totalServices;
    }
}
