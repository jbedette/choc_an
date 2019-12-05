package com.company;

import groovy.json.internal.IO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProviderListTest {
    ProviderList newList = new ProviderList();
    //Transaction t_record = new Transaction("12:12", "123456789", "987654321", "123456");

    @Test
    void increaseConsult() {
        newList.increaseConsult("123456789");
    }

    @Test
    void increaseFees() {
        newList.increaseFees("123456789", "999.99");
    }

    //Looking for user input. IDK how to test.
    /*@Test
    void providerMenu() {
        newList.providerMenu();
    }*/

    @Test
    void logIn() {
        newList.logIn("123456789");
    }

    @Test
    void display() {
        newList.display();
    }

    @Test
    void getName() {
        newList.getName("123456789");
    }

    //Can't figure out how to test this. Looking for user input...
    /*@Test
    void providerReport()throws IOException {
        newList.providerReport("Fred Shaprio","123456789", t_record, "999.99", "Mickey");;
    }*/
}
