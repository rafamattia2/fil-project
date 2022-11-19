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

    public void createService(int type, String name, String desc) {
        Service newService = new Service(type, name, desc, this);
    }

    public void deleteService(Service service) {
        service.setEnabled(Status.toEnum(0));
    }

    public void openService(Service service) {
        service.setEnabled(Status.toEnum(1));
    }

    public void closeService(Service service) {
        service.setEnabled(Status.toEnum(1));
    }

//    public Service searchService(String name) {
//
//    }

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
