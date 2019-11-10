package io.turntabl;

public class CorporateClient extends Client implements ContactName{
    private String accountManagerName;

    public CorporateClient(String name, String ID, ServiceLevel serviceLevel) {
        super(name, ID, serviceLevel);
    }

    @Override
    public String toString() {
        return "CorporateClient{}";
    }

    @Override
    public String getContactName() {
        return null;
    }
}
