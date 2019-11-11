package io.turntabl;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
    public void getNamesOfGoldClients_withSize() {
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
        List<String> actual = register.getNamesOfGoldClients();
        assertEquals(4, register.);
    }


    @Test
    public void countClientAtEveryLevel() {
    }
}