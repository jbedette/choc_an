package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void display() {
        Transaction test = new Transaction("10-11-12","1","2","3");
        test.display();
    }

    @Test
    void transactionReport() {
        Transaction test = new Transaction("10-11-12","1","2","3");
        try {
            test.transactionReport();
        } catch (FileNotFoundException e){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
