package com.company;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ServiceList {
    Set<Service> list;

    ServiceList() {
        list = new HashSet<Service>();
        Scanner serviceScan = null;

        try {
            serviceScan = new Scanner(new File("src/services.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (serviceScan.hasNext()) {
            String number = serviceScan.next();
            String name = serviceScan.next();
            String price = serviceScan.next();

            Service temp = new Service(number, name, price);
            list.add(temp);
        }

        serviceScan.close();
    }

    public void dispAll(){

        Iterator<Service> out = list.iterator();
        while (out.hasNext()){
            out.next().dispAll();
        }
    }

    public String getServiceName(String number){
        if(number.length() == 6) {
            Iterator<Service> out = list.iterator();
            while (out.hasNext()){
                Service temp = out.next();
                if(temp.getNumber().equals(number)){
                    return temp.getName();
                }
            }
        }
        return "no such service exists";
    }

    public String getServicePrice(String number){
        if(number.length() == 6) {
            Iterator<Service> out = list.iterator();
            while (out.hasNext()){
                Service temp = out.next();
                if(temp.getNumber().equals(number)){
                    return temp.getPrice();
                }
            }
        }
        return "no such service exists";
    }

    public Set getList(){
        return list;
    }
/*
    public void addService(String number, String name){
        Service temp = new Service(number, name);
        list.add(temp);
    }
*/
}
