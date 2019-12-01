package com.company;

import java.io.*;
import java.util.*;

/*  General gameplan:
        1. on initialization/program start this manager class reads the member data from file into a set of members
            1.1 sanitize on the way in, i'm using _ for spaces because I don't want to mess with delims
        2. use iterators and sets to manage duplicates and work with data
        3. at end overwrite text file with current list of members

        design decisions:
            1. all data fields are strings. we're not doing much mathematically, we are limiting string size a bunch
            2. reading all data at the begging and overwriting the file on command , idk, that's how I
 */
/*
    todo:
        major:
            integrate services and purchased services
            sort alphabetically
        medium:
            get char limits correct
            sanitize inputs
        minor:
            improve mem number assignment
            unify read/write methods, i'm all over the place with scanner,filereader, etc
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
        //read file, delim=' ', clean
        while (memScan.hasNext()) {
            String name = memScan.next();
            String address = memScan.next();
            String city = memScan.next();
            String state = memScan.next();

            String zip = memScan.next();
            String num = memScan.next();
            String valid = memScan.next();

            String [] toClean = new String[]{name,address,city,state};

            Member temp = new Member(Utility.sanitizeReadWrite(true,toClean),zip,num,valid);
            list.add(temp);
        }


        //close up the file system
        memScan.close();

        //
        //demo();
        //
    }

    //demo of things working
    private void demo() {
    /*
        original members file
            Richard_Morin 36_Waverly_Ave. Springfield OR 12345 999999999
            Monty_Flavio 69_Party_Ln. Portland Or 97201 123456789
    */

    /*
        dispAll();
        System.out.println("=========");
        addMember("aaaa", "aaaa", "aaaa", "aaaa", "00000");
        dispAll();
        System.out.println("=========");
        removeMem("999999999");
        dispAll();
        writeOutList();
        */
    }


    public void dispAll(){

        Iterator<Member> out = list.iterator();
        while (out.hasNext()){
            out.next().dispAll();
        }
    }

    /* Yuriy */
    // Verify if a member is in the system and is valid.
    public String verifyMem(long other){
        Iterator<Member> nums = list.iterator();
        String verify = "Invalid Member"; // member # not found
        String comp = Long.toString(other);

        while(nums.hasNext()){
            Member temp = nums.next();
            // member # exists and member is valid
            if(comp.equals(temp.getMemNum())
                    && temp.getMemValid().equals("True")) {
                verify = "Validated";
                return verify;
            }
            // member exists but is not valid
            if(comp.equals(temp.getMemNum())
                    && temp.getMemValid().equals("False")) {
                verify = "Member Suspended";
                return verify;
            }
        }
        return verify;
    }

    /*
    //sort list alphabetically
    private void alphaSort(){
    Collections.sort(list, new Comparator() {

            public int compare(Member o1, Member o2) {
                // put Comparesion according to your requirement
                return Member;
            }
        });
    }
    */

    public void addMember(String name, String address, String city, String state, String zip, String valid){
        //todo: make better
        //create mem number
        //I think i'm gonna need to keep these Integers.to string, I want the concat

        //essentially this is just getting ascii values from string values
        //in members concatenating them into a string and then chopping off things larger
        //than 9 digits and parsing an int from from there
        String num = (
                Integer.toString((int)name.charAt(0)) +
                        Integer.toString((int)address.charAt(0)) +
                        Integer.toString((int)city.charAt(0)) +

                        Integer.toString((int)state.charAt(1)) +
                        Integer.toString((int)state.charAt(0)) +
                        Integer.toString((int)name.charAt(1)) +

                        Integer.toString((int)address.charAt(2)) +
                        Integer.toString((int)name.charAt(name.length()-1)) +
                        Integer.toString((int)city.charAt(city.length()-1))).substring(0,9);

        String [] in = new String[]{name,address,city,state};

        //check to see if mem num exists
        //because of how the names are generated it should make the same one,
        //todo: make way better

        Set existingMemNums = getExistingMemNums();
        if(!existingMemNums.contains(num)) {
            Member temp = new Member(in, zip, num, valid);
            list.add(temp);
        }
    }

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
    public void removeMem(String targMemNum){
        Iterator<Member> toRemove = list.iterator();
        while (toRemove.hasNext()){
            if (toRemove.next().getMemNum().equals(targMemNum)){
                toRemove.remove();
            }
        }
    }

    public void writeOutList() {
        Iterator<Member> toWrite = list.iterator();

        //essentially write nothing to the name of the old file
        try {
            eraseOldFile();
        }catch (IOException e){
            e.printStackTrace();
        }

        while (toWrite.hasNext()) {
            try {
                toWrite.next().appendToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void eraseOldFile()throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/members.txt"));
        writer.close();
    }
}
