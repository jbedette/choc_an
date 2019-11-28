package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Service {
    String number, name, price;

    Service(String number, String name, String price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void dispAll(){
        System.out.println("Number: " + number + "\nName: " + name + "\nPrice: " + price + '\n');
    }

    public void appendToFile() throws IOException {
        //https://howtodoinjava.com/java/io/java-append-to-file/#FileOutputStream
        String textToAppend = "\r"+ number +' '+ name +' '+ price;
        Path path = Paths.get("src/services.txt");
        Files.write(path, textToAppend.getBytes(), StandardOpenOption.APPEND);
    }
}