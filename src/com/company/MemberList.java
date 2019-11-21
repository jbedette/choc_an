package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MemberList {
    Set list;
    MemberList() {
        // scanner is file read, try/catch on finding file
        list = new HashSet<Member>();
        Scanner memScan = null;
        try {
            memScan = new Scanner(new File("src/members.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //right now we're just reading and printing
        while (memScan.hasNext()) {
            String name = memScan.next();
            String address = memScan.next();
            String city = memScan.next();
            String state = memScan.next();

            int zip = Integer.parseInt(memScan.next());
            int num = Integer.parseInt(memScan.next());
            Member temp = new Member(name,address,city,state,zip,num);
            list.add(temp);
        }


        //close up the file system
        memScan.close();
    }
    public void dispAll(){
        Iterator<Member> out = list.iterator();
        while (out.hasNext()){
            out.next().dispAll();
        }
    }

    public void addMember(String name, String address, String city, String state, int zip){
        //create mem number
        //I think i'm gonna need to keep these Integers.to string, I want the concat
        int num = Integer.parseInt(
                Integer.toString((int)name.charAt(0)) +
                Integer.toString((int)address.charAt(0)) +
                Integer.toString((int)city.charAt(0)) +

                Integer.toString((int)state.charAt(1)) +
                Integer.toString((int)state.charAt(0)) +
                Integer.toString((int)name.charAt(1)) +

                Integer.toString((int)address.charAt(2)) +
                Integer.toString((int)name.charAt(name.length()-1)) +
                Integer.toString((int)city.charAt(city.length()-1))
        );
        //check to see if mem num exists
        //because of how the names are generated
        Set existingMemNums = getExistingMemNums();
        if(!existingMemNums.contains(num)) {
            Member temp = new Member(name, address, city, state, zip, num);
        }
        list.add(temp);
    }
    private Set<Integer> getExistingMemNums(){
        Set out = new HashSet<Integer>();
        Iterator<Member> nums = list.iterator();
        while (nums.hasNext()){
            out.add(nums.next().getMemNum());
        }
        return out;
    }
}
