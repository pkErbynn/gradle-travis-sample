package io.turntabl;

import java.util.List;

public class Register {
    private List<? extends Client> clients;

    public Register(List<Client> clients) {
        this.clients = clients;
    }

    public List<? extends Client> getClients() {
        return clients;
    }

    public List<String> getNamesOfGoldClients(){
        return clients.stream()
                .filter(c -> c.getServiceLevel().equals(ServiceLevel.GOLD))
                .map(m -> m.)
    }
}

