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
            int numOfSev = memScan.nextInt();
            double totalFees = memScan.nextDouble();

            String [] toClean = new String[]{name, address};

            Provider temp = new Provider(Utility.sanitizeReadWrite(true, toClean), num, city, state, zip, numOfSev, totalFees);
            list.add(temp);
        }

        memScan.close();
    }

    public void increaseConsult(String p_num){
        Iterator<Provider> out = list.iterator();
        while (out.hasNext()){
            Provider temp = out.next();
            if(p_num.equals(temp.getNumber())){
                temp.numOfServ = temp.numOfServ + 1;
            }
        }
    }

    public void increaseFees(String p_num, String fee){
        Iterator<Provider> out = list.iterator();
        while (out.hasNext()){
            Provider temp = out.next();
            if(p_num.equals(temp.getNumber())){
                temp.totalFees = temp.totalFees + Double.parseDouble(fee);
            }
        }
    }

    public String providerMenu() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Welcome to the provider portal,\nplease enter your provider number:\n");
        String in = scanner.nextLine();
        if (logIn(in)) {
            return in;
        } else {
            System.out.println("Sorry, your Provider number was invalid");
        }
        return in;
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

    public String getName(String p_num){
        Iterator<Provider> provider = list.iterator();
        while(provider.hasNext()){
            Provider temp = provider.next();
            if(temp.number.equals(p_num)){
                return temp.name;
            }
        }

        return null;
    }

    public void providerReport(String pName, String proNum, Transaction t_record, String fee, String memberName)throws IOException{
        Iterator<Provider> out = list.iterator();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + pName + "ProviderReport.txt", true));
        while(out.hasNext()){
            Provider temp = out.next();
            if(proNum.equals(temp.getNumber())){
                System.out.println("Writing to file...");
                writer.write(temp.name + ' ' + temp.number + ' ' + temp.streetAddress + ' ' + temp.city + ' ' + temp.state + ' ' + temp.zip);
                writer.write("\n");
                writer.write(t_record.curDateTime + ' ' + t_record.dateOfServ + ' ' + memberName + ' ' + t_record.m_num + ' ' + t_record.s_num + ' ' + fee);
                writer.write("\n");
                writer.write(temp.numOfServ +  " " +  temp.totalFees);
            }
        }

        writer.close();
    }
}
