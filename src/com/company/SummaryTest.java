package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SummaryTest {

    @Test
    void getSummary() {
        try{
            Summary.getSummary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
