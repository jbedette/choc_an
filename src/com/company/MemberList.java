package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*  General gameplan:
        1. on initialization/program start this manager class reads the member data from file into a set of members
            1.1 sanitize on the way in, i'm using _ for spaces because I don't want to mess with delims
        2.

 */
/*
    todo:
        write to file
        get char limits correct
        sanitize read/write
 */


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
            sanitizeReadWrite(name,address,city,state);
            //Member temp = new Member(name,address,city,state,zip,num);
            Member temp = new Member(sanitizeReadWrite(name,address,city,state),zip,num);
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

    /*
    public void addMember(String name, String address, String city, String state, int zip){
        //todo: make better
        //create mem number
        //I think i'm gonna need to keep these Integers.to string, I want the concat

        //essentially this is just getting ascii values from string values
        //in members concatenating them into a string and then chopping off things larger
        //than 9 digits and parsing an int from from there
        int num = Integer.parseInt((
                Integer.toString((int)name.charAt(0)) +
                Integer.toString((int)address.charAt(0)) +
                Integer.toString((int)city.charAt(0)) +

                Integer.toString((int)state.charAt(1)) +
                Integer.toString((int)state.charAt(0)) +
                Integer.toString((int)name.charAt(1)) +

                Integer.toString((int)address.charAt(2)) +
                Integer.toString((int)name.charAt(name.length()-1)) +
                Integer.toString((int)city.charAt(city.length()-1))).substring(0,9)
        );

        //check to see if mem num exists
        //because of how the names are generated it should make the same one,
        //todo: make way better
        Set existingMemNums = getExistingMemNums();
        if(!existingMemNums.contains(num)) {
            Member temp = new Member(name, address, city, state, zip, num);
            list.add(temp);
        }
    }
    */

    //could probably get rid of this somehow,
    //right now it's iterating through the set of members and
    //returning a set of existing member numbers
    private Set<Integer> getExistingMemNums(){
        Set out = new HashSet<Integer>();
        Iterator<Member> nums = list.iterator();
        while (nums.hasNext()){
            out.add(nums.next().getMemNum());
        }
        return out;
    }

    //remove mem takes in member number
    //finds the member == the member num
    //removes it from the set
    public void removeMem(int targMemNum){
        Iterator<Member> toRemove = list.iterator();
            while (toRemove.hasNext()){
                if (toRemove.next().getMemNum() == targMemNum){
                    toRemove.remove();
                }
            }
    }
    private String[] sanitizeReadWrite(
            String name,
            String address,
            String city,
            String state
    ){
        String [] out = new String[]{name,address,city,state};
        for (String s: out){
            s = s.replace('_',' ');
            System.out.println(s);
        }
        return out;
    }
}
