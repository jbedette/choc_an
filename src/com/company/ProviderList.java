package com.company;

    /*
    todo:
        login
        access member
        verify
        add service to member
     */

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ProviderList {
    Set list;
    String name, id;
    ProviderList(){
        Scanner memScan = null;
        try {
            memScan = new Scanner(new File("src/providers.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //read file, delim=' ', clean
        while (memScan.hasNext()) {
            //switch to storing data somewhere
            System.out.println(memScan.next() + memScan.next());
        }
        memScan.close();
        providerMenu();
    }

    public void providerMenu() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Welcome to the provider portal,\nplease enter your provider number:\n");
        String in = scanner.nextLine();
        //compare against list
    }
}
