package com.company;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Provider {

    String name, streetAddress, city, state, zip;
    long number;

    Provider(String name, long number, String streetAddress, String city, String state, String zip) {
        this.name = name;
        this.number = number;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public void display(){
        System.out.println("Name: " + this.name);
        System.out.println("Number: " + this.number);
        System.out.println("Street Address: " + this.streetAddress);
        System.out.println("City: " + this.city);
        System.out.println("State: " + this.state);
        System.out.println("Zip: " + this.zip);
    }

    public long getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }
}
