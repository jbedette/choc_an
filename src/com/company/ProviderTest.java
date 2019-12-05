package com.company;

import static org.junit.jupiter.api.Assertions.*;

class ProviderTest {

    String [] nameAddress = new String[]{"Fred Shaprio", "12345 Melody Lane"};
    Provider newProvider = new Provider(nameAddress, "123456789", "Portland", "OR", "97035", 0, 0.0);

    @org.junit.jupiter.api.Test
    void display() {
        newProvider.display();
    }

    @org.junit.jupiter.api.Test
    void getNumber() {
       newProvider.getNumber();
    }

    @org.junit.jupiter.api.Test
    void getName() {
        newProvider.getName();
    }
}