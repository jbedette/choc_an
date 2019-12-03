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

        // (1) manager ability to add/delete members, run reports. Menu?
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
                    newProviderList.providerMenu();
                    break;
                case(2):
                    System.out.println("Enter member number to lookup: ");
                    m_num = input.nextLong();
                    result = memberlist.verifyMem(m_num);
                    System.out.print(result + "\n" + "\n");
                    break;
                case(3):
                    System.out.println("Enter member number to lookup: ");
                    m_num = input.nextLong();
                    result = memberlist.verifyMem(m_num);
                    char correct = 'n';
                    if(result.equals("Validated")) {
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
                        }while(correct == 'n' || correct == 'N');
                        System.out.println(serviceList.getServicePrice(s_num) + " charged to member " + m_num + "\n");
                        //!!! p_num "provider" will need to be replaced with actual provider's name
                        Transaction t_record = new Transaction(date, "provider", Long.toString(m_num), s_num);
                        t_record.display();
                        //!!! Write Transaction's data to file (service/transaction record)
                    }
                    else
                        System.out.println("Not an active member\n");
                    break;
                case(4):
                    System.out.println("Provider Directory: \n");
                    serviceList.dispAll();
                    break;
            }
        }while(choice != 5);

    }
}
