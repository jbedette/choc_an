package com.company;

import java.util.Scanner;

public class Menu {

    public static int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome, would you like to:");
        System.out.println("1. Log into Manager Menu");
        System.out.println("2. Log into Provider Menu");
        System.out.println("3. Exit");

        return input.nextInt();

    }
    public static int managerMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Manager menu, would you like to:");
        System.out.println("1. Validate a member");
        System.out.println("2. Add a member");
        System.out.println("3. Remove a member");
        //todo: elaborate
        System.out.println("4. Do stuff with reports");
        System.out.println("5. Exit");
        return input.nextInt();
    }

    public static int providerMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Provider menu, would you like to:");
        System.out.println("1: Log in with provider number");
        System.out.println("2: Validate member"); // validated, not validated, suspended
        System.out.println("3: Bill member"); // use service # to bill member
        System.out.println("4: Provider directory");
        System.out.println("5: Exit");
        return input.nextInt()+5;
    }

}
