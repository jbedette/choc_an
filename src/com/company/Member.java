package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Member {
    String name, address, city, state, zip, number, valid;

    //set will be set up later
    //Set<Services> serviceList;

    //initialize
    Member(String [] nameAddrCityState,
            String zip,
            String number,
            String valid
    ) {
        this.name = nameAddrCityState[0];
        this.address = nameAddrCityState[1];
        this.city = nameAddrCityState[2];
        this.state = nameAddrCityState[3];
        this.zip = zip;
        this.number = number;
        this.valid = valid;
    }

    Member(String name, String address, String city, String state, String zip, String number, String valid){
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.number = number;
        this.valid = valid;
    }

    public String getMemNum(){
        return number;
    }

    public String getMemValid() { return valid; }


    //format and display
    public void dispAll(){
        System.out.println(
                name + "\n" + address + ", " + city + ", " + state + ", " + zip + '\n' + number + " " + valid +'\n'
        );
    }

    public void appendToFile() throws IOException {
        String [] in = new String[]{name,address,city,state};
        String [] out = Utility.sanitizeReadWrite(false,in);

        //https://howtodoinjava.com/java/io/java-append-to-file/#FileOutputStream
        String textToAppend = "\r"+out[0]+' '+out[1]+' '+out[2]+' '+out[3]+' '+zip+' '+number;
        Path path = Paths.get("src/members.txt");
        Files.write(path, textToAppend.getBytes(), StandardOpenOption.APPEND);
    }

}
