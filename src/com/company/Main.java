package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        //Populate the member list
        MemberList memberlist = new MemberList();
        //memberlist.dispAll();

        /*
        *   TESTING SERVICES REMOVE LATER
        */
        ServiceList serviceList = new ServiceList();
        serviceList.dispAll();
        String testing;
        testing = serviceList.getServiceName("123456");
        System.out.println(testing);
        testing = serviceList.getServiceName("1234567");
        System.out.println(testing);
        testing = serviceList.getServiceName("123457");
        System.out.println(testing);
        testing = serviceList.getServiceName("123458");
        System.out.println(testing);
        testing = serviceList.getServicePrice("123456");
        System.out.println(testing);
        testing = serviceList.getServicePrice("1234567");
        System.out.println(testing);
        testing = serviceList.getServicePrice("123457");
        System.out.println(testing);
        testing = serviceList.getServicePrice("123458");
        System.out.println(testing);
        ServicesProvidedList servicesProvided = new ServicesProvidedList();
        //servicesProvided.dispAll();
        servicesProvided.dispByProviderNumber("333333333");
        testing = servicesProvided.getServicePrice("333333333");
        System.out.println(testing);
        System.out.println("\n");
        /*
         *   END OF TESTING SERVICES
         */

        do{
            // Provider log in could be done first then options...
            System.out.println("1: Log in with provider number");
            System.out.println("2: Validate member"); // validated, not validated, suspended
            System.out.println("3: Bill member"); // use service # to bill member
            System.out.println("4: Provider directory");
            System.out.println("5: Exit");

            choice = input.nextInt();

            switch (choice){
                case(1):
                    System.out.print("choice 1\n");
                    break;
                case(2):
                    //System.out.print("choice 2\n");
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
        }while(choice != 5);

    }
}
