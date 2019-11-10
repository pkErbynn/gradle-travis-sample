package io.turntabl;

public class CorporateClient extends Client {
    private String accountManagerName;

    public CorporateClient(String name, String ID, ServiceLevel serviceLevel, String accountManagerName) {
        super(name, ID, serviceLevel);
        this.accountManagerName = accountManagerName;
    }

    @Override
    public String toString() {
        return "CorporateClient{}";
    }

    @Override
    public String getName() {
        return this.accountManagerName;
    }
}
