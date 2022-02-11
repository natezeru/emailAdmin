import java.util.Scanner;

public class emailMain {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter first name");
        String f_name = s.nextLine();
        System.out.println("Enter last name");
        String l_name = s.nextLine();

        emailApp ea = new emailApp(f_name, l_name);

        int choice = -1;
        do{
            System.out.println("\n*****\nEnter your choice\n1.Show Info\n2.Change password\n3 Change Mailbox Capacity\n4 Set Alt email " +
                    "\n5 Store data in file \n6 Display data in file \n7 Exit");
            choice = s.nextInt();
            switch (choice){
                case 1:
                ea.get_info();
                break;

                case 2:
                    ea.set_password();
                    break;
                case 3:
                    ea.set_mailCap();
                    break;
                case 4:
                    ea.alternate_email();
                    break;
                case 5:
                    ea.store_file_method();
                    break;
                case 6:
                    ea.read_file();
                    break;
                case 7:
                    System.out.println("Thank you for using this application");
                    break;
                default:
                    System.out.println("Invaild choice");
            }
        } while (choice!=7);
    }
}
