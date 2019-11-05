package io.turntabl;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RegisterTest {
    List<Client> clients = Arrays.asList(new Corporate("MTN", 335, ServiceLabel.GOLD, "Daniel James"),
            new Corporate("Hans Bakery", 325, ServiceLabel.PREMIUM, "Mary Siaw"),
            new Corporate("Jennifer Catering", 135, ServiceLabel.GOLD, "Jessica Davids"),
            new Corporate("Ecobank Bank", 835, ServiceLabel.PLATINUM, "Robert Gordon"),
            new Corporate("Ama's Saloon", 224, ServiceLabel.PREMIUM, "Mabel Simons"),
            new Private("Nathaniel Wood", 56778, ServiceLabel.GOLD),
            new Private("Samuel Kwakye", 5578, ServiceLabel.GOLD),
            new Private("Christiana Asare", 3316, ServiceLabel.PREMIUM),
            new Private("David Green", 778, ServiceLabel.PLATINUM));

    Private client1 = new Private("David Green", 778, ServiceLabel.PLATINUM);

    Register register1 = new Register(clients);

    @Test
    public void clientsGold() {
        List<String> clientNames = register1.clientsGold();
        List<String> expectedNames = Arrays.asList("Daniel James", "Jessica Davids", "Nathaniel Wood", "Samuel Kwakye");
        assertEquals(expectedNames, clientNames);
    }

    @Test
    public void countGold(){
        Integer gold = 4;
        Map<String, Integer> actual = register1.count();
        Integer goldCount = actual.get("Gold Clients");
        assertEquals(gold, goldCount);


    }
    @Test
    public void countPlatinum(){
        Integer platinum = 2;
        Map<String, Integer> actual = register1.count();
        Integer platinumCount = actual.get("Platinum Clients");
        assertEquals(platinum, platinumCount);

    }
    @Test
    public void countPremium(){
        Integer premium = 3;
        Map<String, Integer> actual = register1.count();
        Integer premiumCount = actual.get("Premium Clients");
        assertEquals(premium, premiumCount);

    }
    @Test
    public void getClientById(){
        String clientName = "David Green";
        String actualClientName = register1.clientByName(client1);
        assertEquals(clientName, actualClientName);


    }

}