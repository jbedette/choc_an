package com.company;

import java.io.*;
import java.util.*;

public class Summary {

    /*
     * Every provider to be paid that week, The number of consultations each had,
     * The members total fee for that week, The total number of providers who
     * provided services, The total number of consultations, and the overall fee
     * total are printed.
     */

    private void eraseOldFile() throws IOException {
    }

    public static void getSummary() throws IOException {
        ProviderList providerList = new ProviderList();
        Set tranList = new HashSet<Transaction>();
        Triple[] outProv = providerList.summReport();
        int count = 0;
        double totalFee = 0;

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/SummaryReport.txt"));
        for (int i = 0; i < outProv.length; i++) {
            count += outProv[i].getNum();
            totalFee += outProv[i].getFee();
            totalFee += outProv[i].getFee();
            System.out.print(outProv[i].name + ' ' + "Total Consults: " + outProv[i].num + " Total Fees: "
                    + outProv[i].fee + "\n");
            writer.write(outProv[i].name + ' ' + "Total Consults: " + outProv[i].num + " Total Fees: " + outProv[i].fee
                    + "\n");
        }
        writer.write("Grand Total of consults: " + count + "\nGrand Total fees: " + totalFee);
        writer.close();
    }
}
