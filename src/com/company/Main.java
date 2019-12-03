package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;     // menu option
        String result;  // validated, not validated, suspended
        long m_num;     // member number
        String s_num;   // service number

        //Populate the member list
        MemberList memberlist = new MemberList();

        ProviderList newProviderList = new ProviderList();

        ServiceList serviceList = new ServiceList();

        do{
            // Provider log in could be done first then options...
            System.out.println("Welcome to ChocAn Services. Please log in as either: ");
            System.out.println("1. Manager");
            System.out.println("2. Provider");
            choice = input.nextInt();

            switch (choice) {
                case (1):
                    //Manager Menu
                    System.out.println("Welcome Manager");
                    System.out.println("1. Add Member");
                    System.out.println("2. Remove Member");
                    int response = input.nextInt();

                    //Add member
                    if(response == 1) {
                        input.nextLine();
                        String name, address, city, state, zip;
                        System.out.println("What is the member's name?");
                        name = input.nextLine();
                        System.out.println("What is the member's address");
                        address = input.nextLine();
                        System.out.println("What is the member's city?");
                        city = input.nextLine();
                        System.out.println("What is the member's state?");
                        state = input.nextLine();
                        System.out.println("What is the member's zip?");
                        zip = input.nextLine();

                        memberlist.addMember(name, address, city, state, zip, "True");
                        memberlist.dispAll();
                    }
                    //Remove member
                    else if(response == 2) {
                        input.nextLine();
                        System.out.println("What is the Member you wish to remove?");
                        String mNumber = input.nextLine();
                        memberlist.removeMem(mNumber);
                    }

                    //Return to main menu
                    break;

                case(2):
                    System.out.print("Welcome to the provider portal,\nplease enter your provider number:\n");
                    long pNumber = input.nextInt();
                    if(newProviderList.logIn(pNumber)){
                        choice = newProviderList.providerMenu();
                        switch(choice){
                            case(1):
                                //Validate
                                System.out.println("Enter member number to lookup: ");
                                m_num = input.nextLong();
                                result = memberlist.verifyMem(m_num);
                                System.out.print(result + "\n" + "\n");
                                break;

                            case(2):
                                //Bill
                                System.out.println("Enter member number to lookup: ");
                                m_num = input.nextLong();
                                result = memberlist.verifyMem(m_num);
                                char correct = 'n';
                                if(result.equals("Validated")) {
                                    // MM-DD-YYYY
                                    System.out.println("Enter Date (MM-DD-YYYY): ");
                                    String date = input.next(); // used for record later
                                    do {
                                        System.out.println("Provider Directory: \n");
                                        serviceList.dispAll();
                                        System.out.println("Enter service number : ");
                                        s_num = input.next();
                                        System.out.println("Name: " + serviceList.getServiceName(s_num));
                                        // need error for non-existing service code
                                        System.out.println("Is this correct? (Y/N): ");
                                        correct = input.next().charAt(0);
                                    }while(correct == 'n' || correct == 'N');

                                    System.out.println(serviceList.getServicePrice(s_num) + " charged to member " + m_num + "\n");

                                    /*
                                     * Service record can now be written. Should have all info needed. The member account
                                     * will need to be charged as well?*/

                                    }
                                    else
                                        System.out.println("Not an active member\n");
                                    break;
                            case(3):
                                //Provider Directory
                                System.out.println("Provider Directory: \n");
                                serviceList.dispAll();
                                break;

                            case(4):
                                //quit
                        }
                    }
                    break;
            }

        }while(choice != 5);

    }
}
