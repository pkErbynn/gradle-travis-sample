package io.turntabl;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RegisterTest {

    @Test
    public void getNamesOfGoldClients_whenMany() {
        Register register = new Register(Arrays.asList(
                new CorporateClient("Erbynn", "123", ServiceLevel.GOLD, "Manager Sally"),
                new PrivateClient("Pkay", "124", ServiceLevel.PLATINUM),
                new CorporateClient("John", "12", ServiceLevel.PLATINUM, "Manager Sam"),
                new CorporateClient("Bin", "14", ServiceLevel.GOLD, "John Boyd"),
                new CorporateClient("Sam", "125", ServiceLevel.PREMIUM, "Sam Moorhouse"),
                new PrivateClient("Magie", "15", ServiceLevel.GOLD),
                new PrivateClient("Grace", "15", ServiceLevel.GOLD),
                new PrivateClient("Dennis", "16", ServiceLevel.PLATINUM),
                new CorporateClient("Anthony", "18", ServiceLevel.PREMIUM, "John Erbynn")
        ));
        List<String> expected = Arrays.asList("Manager Sally", "John Boyd","Magie", "Grace");
        List<String> actual = register.getNamesOfGoldClients();
        assertEquals(expected, actual);
    }

    @Test
    public void getNamesOfGoldClients_whenSingle() {
        Register register = new Register(Arrays.asList(
                new PrivateClient("Pkay", "124", ServiceLevel.PLATINUM),
                new CorporateClient("John", "12", ServiceLevel.PLATINUM, "Manager Sam"),
                new CorporateClient("Sam", "125", ServiceLevel.PREMIUM, "Sam Moorhouse"),
                new PrivateClient("Grace", "15", ServiceLevel.GOLD),
                new PrivateClient("Dennis", "16", ServiceLevel.PLATINUM),
                new CorporateClient("Anthony", "18", ServiceLevel.PREMIUM, "John Erbynn")
        ));
        List<String> expected = Arrays.asList("Grace");
        List<String> actual = register.getNamesOfGoldClients();
        assertEquals(expected, actual);
    }

@Test
    public void getNamesOfGoldClients_whenEmpty() {
        Register register = new Register(Arrays.asList(
                new PrivateClient("Pkay", "124", ServiceLevel.PLATINUM),
                new CorporateClient("John", "12", ServiceLevel.PLATINUM, "Manager Sam"),
                new CorporateClient("Sam", "125", ServiceLevel.PREMIUM, "Sam Moorhouse"),
                new PrivateClient("Dennis", "16", ServiceLevel.PLATINUM),
                new CorporateClient("Anthony", "18", ServiceLevel.PREMIUM, "John Erbynn")
        ));
        List<String> expected = Arrays.asList();
        List<String> actual = register.getNamesOfGoldClients();
        assertEquals(expected, actual);
    }

    @Test
    public void getClients_withSize() {
        Register register = new Register(Arrays.asList(
                new CorporateClient("erbynn", "123", ServiceLevel.GOLD, "Milen Milatov"),
                new Client("pkay", "124", ServiceLevel.PLATINUM),
                new Client("john", "12", ServiceLevel.PLATINUM),
                new Client("bin", "14", ServiceLevel.GOLD),
                new CorporateClient("sam", "125", ServiceLevel.PREMIUM, "Frank Abhoki"),
                new Client("magie", "15", ServiceLevel.GOLD),
                new CorporateClient("dennis", "16", ServiceLevel.PLATINUM, "Chen Joy Wang"),
                new Client("bill", "18", ServiceLevel.PREMIUM),
                new CorporateClient("raph", "15", ServiceLevel.GOLD, "John Erbynn")
        ));
        assertEquals(9, register.getClients().size());
    }


    @Test
    public void countClientAtEveryLevel_whenMany() {
        Register register = new Register(Arrays.asList(
                new CorporateClient("erbynn", "123", ServiceLevel.GOLD, "Cool Manager"),
                new PrivateClient("pkay", "124", ServiceLevel.PLATINUM),
                new CorporateClient("john", "12", ServiceLevel.PLATINUM, "Goodtime manager"),
                new PrivateClient("bin", "14", ServiceLevel.GOLD),
                new CorporateClient("sam", "125", ServiceLevel.PREMIUM, "Foo Manger"),
                new PrivateClient("magie", "15", ServiceLevel.GOLD),
                new CorporateClient("dennis", "16", ServiceLevel.PLATINUM, "James Torway"),
                new PrivateClient("bill", "18", ServiceLevel.PREMIUM),
                new PrivateClient("raph", "15", ServiceLevel.GOLD)
        ));
        Map<Integer, String> expected = new HashMap<Integer, String>(){{
            put(2, "Premium clients");
            put(3, "Platinum clients");
            put(4, "Gold clients");
        }};
        assertEquals(expected,register.countClientAtEveryLevel());
    }

    @Test
    public void countClientAtEveryLevel_whenSingles() {
        Register register = new Register(Arrays.asList(
                new PrivateClient("erbynn", "123", ServiceLevel.GOLD),
                new PrivateClient("john", "12", ServiceLevel.PLATINUM),
                new CorporateClient("sam", "125", ServiceLevel.PREMIUM, "Super-dupa cool Managger")
        ));
        Map<Integer, String> expected = new HashMap<Integer, String>(){{
            put(1, "Gold clients");
            put(1, "Platinum clients");
            put(1, "Premium clients");
        }};

        System.out.println(expected);
        assertEquals(expected,register.countClientAtEveryLevel());
    }

/*
    @Test
    public void countClientAtEveryLevel_whenEmpty() {
        Register register = new Register(Arrays.asList( ));
        Map<Integer, String> expected = new HashMap<>();
        assertEquals(expected, register.countClientAtEveryLevel());
    }*/
}