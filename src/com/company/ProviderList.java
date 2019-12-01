package com.company;

    /*
    todo:
        login
        access member
        verify
        add service to member
     */

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ProviderList {
    Set list;

    ProviderList(){
        Scanner memScan = null;
        try {
            memScan = new Scanner(new File("src/providers.txt"));
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        //switch to storing data somewhere
        list = new HashSet<Provider>();
        //read file, delim=' ', clean
        while (memScan.hasNext()) {
            String name = memScan.next();
            String address = memScan.next();
            String city = memScan.next();
            String state = memScan.next();

            String zip = memScan.next();
            String num = memScan.next();

            Provider temp = new Provider(name, num, address, city, state, zip);
            list.add(temp);
        }

        memScan.close();
    }

    public void providerMenu() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Welcome to the provider portal,\nplease enter your provider number:\n");
        String in = scanner.nextLine();
        if (logIn(in)) {
            System.out.println("What would you like to do?");
        } else {
            System.out.println("Sorry, your Provider number was invalid");
        }
    }

    public boolean logIn(String memNumber){

        Iterator<Provider> out = list.iterator();
        while (out.hasNext()){
            Provider temp = out.next();
            if(memNumber.equals(temp.getNumber())){
                System.out.println("Welcome " + temp.getName());
                return true;
            }
        }

        return false;
    }

    public void display(){
          Iterator<Provider> out = list.iterator();
        while (out.hasNext()){
            out.next().display();
        }
    }
}
