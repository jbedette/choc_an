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
            String addr = memScan.next();
            String city = memScan.next();
            String state = memScan.next();

            int zip = Integer.parseInt(memScan.next());
            int num = Integer.parseInt(memScan.next());
            Member temp = new Member(name,addr,city,state,zip,num);
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


}
