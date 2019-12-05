package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int start = 0;      //menu option
        String result;  // validated, not validated, suspended
        String p_num;   // Provider Number
        String p_name;  // provider name
        long m_num;     // member number
        String m_name;  // member name
        String s_num;   // service number

        // Populate member, provider, sercvice lists
        MemberList memberlist = new MemberList();
        ProviderList newProviderList = new ProviderList();
        ServiceList serviceList = new ServiceList();

        do{
            switch(start) {
                case (0):
                    System.out.println("Welcome to ChocAn Services. Please log in as either: ");
                    System.out.println("1. Manager");
                    System.out.println("2. Provider");
                    System.out.println("3. Exit\n");
                    start = input.nextInt();
                    break;
                case (1):
                    //Manager Menu
                    System.out.println("Welcome Manager");
                    System.out.println("1. Add Member");
                    System.out.println("2. Remove Member");
                    System.out.println("3. Validate member"); // validated, not validated, suspended
                    System.out.println("4. Get weekly Accounts Payable report");
                    System.out.println("5. Exit\n");
                    int response = input.nextInt();

                    //Add member
                    switch (response) {

                        case(1):
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
                        break;
                        //Remove member
                        case(2):{
                            input.nextLine();
                            System.out.println("What is the Member you wish to remove?");
                            String mNumber = input.nextLine();
                            memberlist.removeMem(mNumber);
                            break;
                        }
                        case(3):
                        System.out.println("Enter member number to lookup: ");
                        m_num = input.nextLong();
                        result = memberlist.verifyMem(m_num);
                        System.out.print(result + "\n" + "\n");
                        break;
                        case(4):
                            Summary.getSummary();
                        default:
                            start = 0;
                    }
                    break;
                case (2):
                    System.out.println("1. Log in with provider number");
                    System.out.println("2. Validate member"); // validated, not validated, suspended
                    System.out.println("3. Bill member and create member report"); // use service # to bill member
                    System.out.println("4. Provider directory");
                    System.out.println("6. Exit\n");

                    int choice = input.nextInt();

                    switch (choice) {
                        case (1):
                            p_num = newProviderList.providerMenu();
                            break;
                        case (2):
                            System.out.println("Enter member number to lookup: ");
                            m_num = input.nextLong();
                            result = memberlist.verifyMem(m_num);
                            System.out.print(result + "\n" + "\n");
                            break;
                        case (3):
                            p_num = newProviderList.providerMenu();
                            p_name = newProviderList.getName(p_num);
                            System.out.println("Enter member number to lookup: ");
                            m_num = input.nextLong();
                            result = memberlist.verifyMem(m_num);
                            char correct = 'n';
                            if (result.equals("Validated")) {
                                // MM-DD-YYY requires input of dashes by user right now, maybe change later?
                                System.out.println("Enter Date (MM-DD-YYY): ");
                                String date = input.next(); // used for Transaction later
                                do {
                                    System.out.println("Provider Directory: \n");
                                    serviceList.dispAll();
                                    System.out.println("Enter service number : ");
                                    s_num = input.next();
                                    System.out.println("Name: " + serviceList.getServiceName(s_num));
                                    /* need error for non-existing service code */
                                    System.out.println("Is this correct? (Y/N): ");
                                    correct = input.next().charAt(0);
                                } while (correct == 'n' || correct == 'N');
                                System.out.println(serviceList.getServicePrice(s_num) + " charged to member " + m_num + "\n");
                                Transaction t_record = new Transaction(date, p_name, Long.toString(m_num), s_num);
                                t_record.display();
                                // Writing service/transaction record to transactionRecord.txt
                                t_record.transactionReport();

                                m_name = memberlist.getName(Long.toString(m_num));
                                //p_name = newProviderList.getName(p_num);
                                newProviderList.increaseConsult(p_num);
                                newProviderList.increaseFees(p_num, serviceList.getServicePrice(s_num));
                                newProviderList.providerReport(p_name, p_num, t_record, serviceList.getServicePrice(s_num), m_name);
                                memberlist.memberReport(Long.toString(m_num), m_name, p_name, t_record);
                            } else
                                System.out.println("Not an active member\n");
                            break;
                        case (4):
                            System.out.println("Provider Directory: \n");
                            serviceList.dispAll();
                            break;

                        default:
                            start = 0;
                    }
            }
        }while(start != 3);
    }
}
