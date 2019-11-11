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
                new Client("erbynn", "123", ServiceLevel.GOLD),
                new Client("pkay", "124", ServiceLevel.PLATINUM),
                new Client("john", "12", ServiceLevel.PLATINUM),
                new Client("bin", "14", ServiceLevel.GOLD),
                new Client("sam", "125", ServiceLevel.PREMIUM),
                new Client("yaa", "15", ServiceLevel.GOLD),
                new Client("dennis", "16", ServiceLevel.PLATINUM),
                new Client("bill", "18", ServiceLevel.PREMIUM)
        ));
        List<String> expected = Arrays.asList("erbynn", "bin", "yaa");
        List<String> actual = register.getNamesOfGoldClients();
        assertEquals(expected, actual);
    }

    @Test
    public void getNamesOfGoldClients_whenSingle() {
        Register register = new Register(Arrays.asList(
                new Client("pkay", "124", ServiceLevel.PLATINUM),
                new Client("john", "12", ServiceLevel.PLATINUM),
                new Client("sam", "125", ServiceLevel.PREMIUM),
                new Client("yaa", "15", ServiceLevel.GOLD),
                new Client("dennis", "16", ServiceLevel.PLATINUM),
                new Client("bill", "18", ServiceLevel.PREMIUM)
        ));
        List<String> expected = Arrays.asList("yaa");
        List<String> actual = register.getNamesOfGoldClients();
        assertEquals(expected, actual);
    }

@Test
    public void getNamesOfGoldClients_whenEmpty() {
        Register register = new Register(Arrays.asList(
                new Client("pkay", "124", ServiceLevel.PLATINUM),
                new Client("sam", "125", ServiceLevel.PREMIUM),
                new Client("dennis", "16", ServiceLevel.PLATINUM),
                new Client("bill", "18", ServiceLevel.PREMIUM)
        ));
        List<String> expected = Arrays.asList();
        List<String> actual = register.getNamesOfGoldClients();
        assertEquals(expected, actual);
    }

    @Test
    public void getClients_withSize() {
        Register register = new Register(Arrays.asList(
                new Client("erbynn", "123", ServiceLevel.GOLD),
                new Client("pkay", "124", ServiceLevel.PLATINUM),
                new Client("john", "12", ServiceLevel.PLATINUM),
                new Client("bin", "14", ServiceLevel.GOLD),
                new Client("sam", "125", ServiceLevel.PREMIUM),
                new Client("magie", "15", ServiceLevel.GOLD),
                new Client("dennis", "16", ServiceLevel.PLATINUM),
                new Client("bill", "18", ServiceLevel.PREMIUM),
                new Client("raph", "15", ServiceLevel.GOLD)
        ));
        assertEquals(9, register.getClients().size());
    }


    @Test
    public void countClientAtEveryLevel_whenMany() {
        Register register = new Register(Arrays.asList(
                new Client("erbynn", "123", ServiceLevel.GOLD),
                new Client("pkay", "124", ServiceLevel.PLATINUM),
                new Client("john", "12", ServiceLevel.PLATINUM),
                new Client("bin", "14", ServiceLevel.GOLD),
                new Client("sam", "125", ServiceLevel.PREMIUM),
                new Client("magie", "15", ServiceLevel.GOLD),
                new Client("dennis", "16", ServiceLevel.PLATINUM),
                new Client("bill", "18", ServiceLevel.PREMIUM),
                new Client("raph", "15", ServiceLevel.GOLD)
        ));
        Map<Integer, String> expected = new HashMap<Integer, String>(){{
            put(2, "Premium clients");
            put(3, "Platinum clients");
            put(4, "Gold clients");
        }};
        assertEquals(expected,register.countClientAtEveryLevel());
    }

    @Test
    public void countClientAtEveryLevel_whenSingle() {
        Register register = new Register(Arrays.asList(
                new Client("erbynn", "123", ServiceLevel.GOLD),
                new Client("john", "12", ServiceLevel.PLATINUM),
                new Client("sam", "125", ServiceLevel.PREMIUM)
        ));
        Map<Integer, String> expected = new HashMap<Integer, String>(){{
            put(1, "Gold clients");
            put(1, "Platinum clients");
            put(1, "Premium clients");
        }};

        System.out.println(expected);
        assertEquals(expected,register.countClientAtEveryLevel());
    }

    @Test
    public void countClientAtEveryLevel_whenEmpty() {
        Register register = new Register(Arrays.asList( ));
        Map<Integer, String> expected = new HashMap<>();
        assertEquals(expected, register.countClientAtEveryLevel());
    }
}