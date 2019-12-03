package com.company;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/*
 *  This class will hold the Service Record / Transaction for some member. This includes:
 *  1 - Current Date/Time
 *  2 - Date of Service/Transaction
 *  3 - Provider #
 *  4 - Member #
 *  5 - Service Code
 *  6 - Comments (optional)
 */

public class Transaction {
    String curDateTime; // Current date/time
    String dateOfServ;  // Date of service
    String p_num;       // Provider number
    String m_num;       // Member number
    String s_num;       // Service number
    String comments;    //100 char limit

    Transaction(String dateOfServ, String p_num, String m_num, String s_num){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        this.curDateTime = dtf.format(now);
        this.dateOfServ = dateOfServ;
        this.p_num = p_num;
        this.m_num = m_num;
        this.s_num = s_num;
        comments = comments();
    }

    // Ask user if they want to add optional comments, "no comments" if they don't
    public String comments(){
        Scanner input = new Scanner(System.in); // to get comments
        char option = 'n';
        String cmts = "no comments"; // comments
        System.out.println("Would you like to add comments? (Y/N):");
        option = input.next().charAt(0);
        input.nextLine();
        if(option == 'Y' || option == 'y'){
            do{
                System.out.println("Enter up to 100 characters:");
                cmts = input.nextLine();
            }while(cmts.length() > 100);
        }
        return cmts;
    }

    public void display(){
        System.out.println("Transaction record created:\n");
        System.out.println(curDateTime);
        System.out.println(dateOfServ);
        System.out.println(p_num);
        System.out.println(m_num);
        System.out.println(s_num);
        System.out.println(comments);
        System.out.println();
    }

}

