package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ServiceProvided {
    String cur_date_time, date_time, prov_num, mem_num, service_code, comments, service_name, prov_name, service_fee;

    ServiceProvided(String cur_date_time,
                    String date_time,
                    String prov_num,
                    String mem_num,
                    String service_code,
                    String comments,
                    String service_name,
                    String prov_name,
                    String service_fee) {
        this.cur_date_time = cur_date_time;
        this.date_time = date_time;
        this.prov_num = prov_num;
        this.mem_num = mem_num;
        this.service_code = service_code;
        this.comments = comments;
        this.service_name = service_name;
        this.prov_name = prov_name;
        this.service_fee = service_fee;
    }

    public String getCur_date_time() {
        return cur_date_time;
    }



    public String getDate_time() {
        return date_time;
    }



    public String getProv_num() {
        return prov_num;
    }



    public String getMem_num() {
        return mem_num;
    }



    public String getService_code() {
        return service_code;
    }



    public String getComments() {
        return comments;
    }



    public String getService_name() {
        return service_name;
    }



    public String getprov_name() {
        return prov_name;
    }



    public String getService_fee() {
        return service_fee;
    }



    public void dispAll(){
        System.out.println("Current date and time: " + cur_date_time +
                "\nDate and time: " + date_time +
                "\nProvider number: " + prov_num +
                "\nMember number: " + mem_num +
                "\nService code: " + service_code +
                "\nComments: " + comments +
                "\nService name: " + service_name +
                "\nProvider name: " + prov_name +
                "\nService fee: " + service_fee + '\n');
    }

    public void appendToFile() throws IOException {
        //https://howtodoinjava.com/java/io/java-append-to-file/#FileOutputStream
        String textToAppend = "\r"+ cur_date_time +' '+
                date_time +' '+
                prov_num +' '+
                mem_num +' '+
                service_code +' '+
                comments +' '+
                service_name +' '+
                prov_name +' '+
                service_fee;
        Path path = Paths.get("src/servicesProvided.txt");
        Files.write(path, textToAppend.getBytes(), StandardOpenOption.APPEND);
    }
}