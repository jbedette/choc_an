package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        //Populate the member list
        MemberList memberlist = new MemberList();
        //memberlist.dispAll();

        do{
            // Provider log in could be done first then options...
            System.out.println("1: Log in with provider number");
            System.out.println("2: Validate member"); // call validate()
            System.out.println("3: Bill member"); // call validate(), then add bill
            System.out.println("4: Provider directory");

            choice = input.nextInt();

            switch (choice){
                case(1):
                    System.out.print("choice 1\n");
                    break;
                case(2):
                    System.out.print("choice 2\n");
                    //long m_num;
                    System.out.println("Enter member number to lookup: ");
                    long m_num = input.nextLong();
                    String result = memberlist.verifyMem(m_num);
                    System.out.print(result + "\n");
                    break;
                case(3):
                    System.out.print("choice 3\n");

                    break;
                case(4):
                    System.out.print("choice 4\n");
                    break;
            }
        }while(choice != 3);

    }
}
