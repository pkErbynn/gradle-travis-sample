package io.turntabl;

public class Client {
    private String name;
    private String ID;
    private ServiceLevel serviceLevel;

    public Client(String name, String ID, ServiceLevel serviceLevel) {
        this.name = name;
        this.ID = ID;
        this.serviceLevel = serviceLevel;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", serviceLevel=" + serviceLevel +
                '}';
    }
}
