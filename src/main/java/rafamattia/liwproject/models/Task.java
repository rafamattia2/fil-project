package rafamattia.liwproject.models;

import rafamattia.liwproject.models.enuns.Status;


public class Task {
    private int taskId;
    private int type;
    private String name;
    private String description;
    private Status enabled;
    private Client host;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getEnabled() {
        return enabled;
    }

    public Task(int type, String name, String description, Client host) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.enabled = Status.toEnum(0);
        this.host = host;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status isEnabled() {
        return enabled;
    }

    public void setEnabled(Status enabled) {
        this.enabled = enabled;
    }

    public Client getHost() {
        return host;
    }

    public void setHost(Client host) {
        this.host = host;
    }
}

