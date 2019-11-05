package io.turntabl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Register {


    private List<Client> clients;


    public Register(List<Client> clients) {
        this.clients = clients;
    }

    public List<String> clientsGold() {
        List<String> names = clients.stream().filter(s -> s.getLabel() == ServiceLabel.GOLD).map(Client::getClientName).collect(Collectors.toList());

        return names;
    }

    public String clientByName(Client client) {
        Integer clientID = client.getClientID();
        List<String> clientNameById = clients.stream().filter(c -> c.getClientID().equals(clientID)).map(Client::getClientName).collect(Collectors.toList());
        if (clientNameById.size() != 0) {
            return clientNameById.get(0);
        }
        return null;


    }

    public Map<String, Integer> count() {
        Map<String, Integer> mapOfClients = new HashMap<>();
        Integer gold = Math.toIntExact(clients.stream().filter(c -> c.getLabel() == ServiceLabel.GOLD).count());
        Integer premium = Math.toIntExact(clients.stream().filter(c -> c.getLabel() == ServiceLabel.PREMIUM).count());
        Integer platinum = Math.toIntExact(clients.stream().filter(c -> c.getLabel() == ServiceLabel.PLATINUM).count());

        mapOfClients.put("Gold Clients", gold);
        mapOfClients.put("Premium Clients", premium);
        mapOfClients.put("Platinum Clients", platinum);

        return mapOfClients;
    }


}
