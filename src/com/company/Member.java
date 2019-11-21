package com.company;

public class Member {
    String name, address, city, state;
    int zip, number;

    //set will be initialized later
    //Set<Services> serviceList;

    //initialize
    Member(
            String name,
            String address,
            String city,
            String state,
            int zip,
            int number
            ) {
       this.name = name;
       this.address = address;
       this.city = city;
       this.state = state;
       this.zip = zip;
       this.number = number;
    }

    //format and display
    public void dispAll(){
        System.out.println(
                name + "\n" + address + ", " + city + ", " + state + ", " + zip + '\n'
        );
    }
}
