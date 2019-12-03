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
            long num = memScan.nextInt();

            Provider temp = new Provider(name, num, address, city, state, zip);
            list.add(temp);
        }

        memScan.close();
    }

    public int providerMenu() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        System.out.println("What would you like to do?");
        System.out.println("1: Validate member"); // validated, not validated, suspended
        System.out.println("2: Bill member"); // use service # to bill member
        System.out.println("3: Provider directory");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();
        return choice;

    }

    public boolean logIn(long memNumber){

        Iterator<Provider> out = list.iterator();
        while (out.hasNext()){
            Provider temp = out.next();
            if(memNumber == temp.getNumber()){
                System.out.println("Welcome " + temp.getName());
                return true;
            }
        }

        System.out.println("Sorry, that Provider Number was not valid.");
        return false;
    }

    public void display(){
          Iterator<Provider> out = list.iterator();
        while (out.hasNext()){
            out.next().display();
        }
    }
}
