package com.company;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ServicesProvidedList {
    Set<ServiceProvided> list;

    ServicesProvidedList() {
        list = new HashSet<ServiceProvided>();
        Scanner serviceScan = null;

        try {
            serviceScan = new Scanner(new File("src/servicesProvided.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (serviceScan.hasNext()) {
            String cur_date_time = serviceScan.next();
            String date_time = serviceScan.next();
            String prov_num = serviceScan.next();
            String mem_num = serviceScan.next();
            String service_code = serviceScan.next();
            String comments = serviceScan.next();
            String service_name = serviceScan.next();// why again? we already have the number. (from design Record Classes)
            String priv_name = serviceScan.next();// why again?? we already have the number. (from design Record Classes)
            String service_fee = serviceScan.next();

            ServiceProvided temp =
                    new ServiceProvided(cur_date_time, date_time, prov_num, mem_num, service_code, comments, service_name, priv_name, service_fee);
            list.add(temp);
        }

        serviceScan.close();
    }

    public void dispAll(){

        Iterator<ServiceProvided> out = list.iterator();
        while (out.hasNext()){
            out.next().dispAll();
        }
    }

    public void dispByProviderNumber(String number){
        if(number.length() == 9) {
            Iterator<ServiceProvided> out = list.iterator();
            while (out.hasNext()){
                ServiceProvided temp = out.next();
                if(temp.getProv_num().equals(number)){
                    temp.dispAll();
                }
            }
        }
    }

    public String getServicePrice(String number){
        double total = 0;
        if(number.length() == 9) {
            Iterator<ServiceProvided> out = list.iterator();
            while (out.hasNext()){
                ServiceProvided temp = out.next();
                if(temp.getProv_num().equals(number)){
                    total += Double.valueOf(temp.getService_fee());
                }
            }
        }
        return Double.toString(total);
    }
/*
    public void addService(String number, String name){
        Service temp = new Service(number, name);
        list.add(temp);
    }
*/
}