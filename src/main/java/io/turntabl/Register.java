package io.turntabl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Register {
    private List<? extends Client> clients;

    public Register(List<Client> clients) {
        this.clients = clients;
    }

    public List<? extends Client> getClients() {
        return clients;
    }

    public List<String> getNamesOfGoldClients() {
        return clients.stream()
                .filter(c -> c.getServiceLevel().equals(ServiceLevel.GOLD))
                .map(Client::getName)
                .collect(Collectors.toList());
    }

    public Map<Integer, String> countClientAtEveryLevel() {
        Map<Integer, String> countServiceLevelPair = new HashMap<>();

        int goldCount = ((int) clients.stream()
                .filter(c -> c.getServiceLevel() == ServiceLevel.GOLD)
                .count());
        int platinumCount = ((int) clients.stream()
                .filter(c -> c.getServiceLevel() == ServiceLevel.PLATINUM)
                .count());
        int premiumCount = ((int) clients.stream()
                .filter(c -> c.getServiceLevel() == ServiceLevel.PREMIUM)
                .count());

        countServiceLevelPair.put(goldCount, "Gold clients");
        countServiceLevelPair.put(platinumCount, "Platinum clients");
        countServiceLevelPair.put(premiumCount, "Premium clients");

        return countServiceLevelPair;
    }




}

