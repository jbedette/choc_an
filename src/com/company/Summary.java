package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Summary {

    /*
    Every provider to be paid that week,
    The number of consultations each had,
    The members total fee for that week,
    The total number of providers who provided services,
    The total number of consultations,
    and the overall fee total are printed.
    */

    public static void getSummary(){
        MemberList memberList = new MemberList();
        ProviderList providerList = new ProviderList();
        ServiceList serviceList = new ServiceList();
        Set tranList = new HashSet<Transaction>();
        Set memList = memberList.getList();
        Set provList = providerList.getList();
        Set servList = serviceList.getList();
        Triple [] outProv = providerList.summReport();


        for(int i = 0;i<outProv.length;i++){
            System.out.println(
                    outProv[i].name +' '+
                    outProv[i].num +' '+
                    outProv[i].fee
            );
        }
        /*
        Scanner tranScan = null;
        try {
            tranScan = new Scanner(new File("src/members.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (tranScan.hasNext()) {
            String curDateTime = tranScan.next();
            String dateOfServ = tranScan.next();
            String p_num = tranScan.next();
            String m_num = tranScan.next();

            String s_num = tranScan.next();
            String comments = tranScan.next();

            String [] toClean = new String[]{dateOfServ};

            toClean = Utility.sanitizeReadWrite(true,toClean);
            Transaction temp = new Transaction(toClean[1],p_num,m_num,s_num);

            tranList.add(temp);
        }

         */

    }
}
