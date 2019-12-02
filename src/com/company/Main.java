package com.company;


import java.util.Scanner;

import static com.company.Menu.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;     // menu option
        String result;  // validated, not validated, suspended
        long m_num;     // member number
        String s_num;   // service number
        int start = 0;

        //Populate the member list
        MemberList memberlist = new MemberList();
        ProviderList newProviderList = new ProviderList();
        ServiceList serviceList = new ServiceList();

        while(true){
            switch (start){
                case(0): {
                    start = menu();
                    break;
                }
                case(1):{
                    choice = managerMenu();
                    break;
                }
                case(2):{
                    choice = providerMenu();
                    break;
                }
                default:{
                    System.out.println("Goodbye");
                    return;
                }
            }
            switch (choice){
                case(0):
                    break;
                case(2):
                    //manager add
                    memberlist.addMember();
                    break;
                case(3):
                    //manager del
                    memberlist.removeMem();
                    break;
                case(4):
                    //manager report
                    break;
                case(6):
                    newProviderList.providerMenu();
                    break;
                case(1):
                    //manager verify
                case(7):
                    System.out.println("Enter member number to lookup: ");
                    m_num = input.nextLong();
                    result = memberlist.verifyMem(m_num);
                    System.out.print(result + "\n" + "\n");
                    break;
                case(8):
                    System.out.println("Enter member number to lookup: ");
                    m_num = input.nextLong();
                    result = memberlist.verifyMem(m_num);
                    char correct = 'n';
                    if(result.equals("Validated")) {
                        // MM-DD-YYY
                        System.out.println("Enter Date (MM-DD-YYY): ");
                        String date = input.next(); // used for record later
                        do {
                            System.out.println("Provider Directory: \n");
                            serviceList.dispAll();
                            System.out.println("Enter service number : ");
                            s_num = input.next();
                            System.out.println("Name: " + serviceList.getServiceName(s_num));
                            /* need error for non-existing service code */
                            System.out.println("Is this correct? (Y/N): ");
                            correct = input.next().charAt(0);
                        }while(correct == 'n' || correct == 'N');
                        System.out.println(serviceList.getServicePrice(s_num) + " charged to member " + m_num + "\n");
                        /*
                         * Service record can now be written. Should have all info needed. The member account
                         * will need to be charged as well?
                         */
                    }
                    else
                        System.out.println("Not an active member\n");
                    break;
                case(9):
                    System.out.println("Provider Directory: \n");
                    serviceList.dispAll();
                    break;
                default:
                    start = 0;
                    break;
            }
            System.out.println(start + " " + choice);
        }
    }
}
