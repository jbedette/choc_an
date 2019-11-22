package com.company;

public class Member {
    String name, address, city, state;
    int zip, number;

    //set will be initialized later
    //Set<Services> serviceList;

    //initialize
    /*
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
    */


    Member(String [] nameAddrCityState,
            int zip,
            int number
    ) {
        this.name = nameAddrCityState[0];
        this.address = nameAddrCityState[1];
        this.city = nameAddrCityState[2];
        this.state = nameAddrCityState[3];
        this.zip = zip;
        this.number = number;
    }
    public int getMemNum(){
        return number;
    }

    //format and display
    public void dispAll(){
        System.out.println(
                name + "\n" + address + ", " + city + ", " + state + ", " + zip + '\n'
        );
    }
    //testing stuff
    //todo: remove
    public void dispMemNum(){
        System.out.print(number + ' ');
    }
}
