package com.company;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Provider {

    String name, number, streetAddress, city, state, zip;
    int numOfServ;
    double totalFees;

    Provider(String [] nameAddress, String number, String city, String state, String zip, int numofServ, double totalFees) {
        this.name = nameAddress[0];
        this.number = number;
        this.streetAddress = nameAddress[1];
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.numOfServ = numofServ;
        this.totalFees = totalFees;
    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Number: " + this.number);
        System.out.println("Street Address: " + this.streetAddress);
        System.out.println("City: " + this.city);
        System.out.println("State: " + this.state);
        System.out.println("Zip: " + this.zip);
    }

    public String getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    public int getNumOfServ(){
        return numOfServ;
    }
    public double getTotalFees(){
        return totalFees;
    }
}
