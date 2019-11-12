package io.turntabl;

import org.junit.Test;

import static org.junit.Assert.*;

public class CorporateClientTest {

    @Test
    public void getNameFromAccountManager() {
        CorporateClient corporateClient = new CorporateClient("John Erbynn", "TT34", ServiceLevel.PREMIUM, "Manager Fredrick Prah");
        assertEquals("Manager Fredrick Prah", corporateClient.getName());
    }
}