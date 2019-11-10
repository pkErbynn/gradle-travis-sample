package io.turntabl;

public class PrivateClient extends Client implements ContactName{

    public PrivateClient(String name, String ID, ServiceLevel serviceLevel, String accountManagerName) {
        super(name, ID, serviceLevel);
    }

    @Override
    public String toString() {
        return "PrivateClient{}";
    }


    @Override
    public String getContactName() {
        return null;
    }
}
