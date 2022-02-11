import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class emailApp {


    Scanner s = new Scanner(System.in);

    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCap = 500;
    private String alter_email;



    public emailApp(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + this.fname + " " + this.lname);

        //calling methods
        this.dept = this.setDept();
        this.password = this.generate_password(8);
        this.email = this.generate_email();
    }

    private String generate_email(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+ "@" + this.dept.toLowerCase()+".company.com";
    }

    private String setDept() {
        System.out.println("Department codes \n1 for sales \n2 for dev \n3 for accounting \n for none");
        boolean flag = false;
        do{
            System.out.println("Enter department code ");
            int choice = s.nextInt();
            switch (choice){
                case 1:
                    return "Sales";

                case 2:
                    return "Dev";

                case 3:
                    return "Accounting";

                case 4:
                    return "None";

                default:
                    System.out.println("Invalid Choice !!!");

            }

        }while(!flag);
        return null;
    }

//random password method

    private String generate_password(int length){
        Random random = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUV";
        String Lower_chars = Capital_chars.toLowerCase();
        String numbers = "O123456789";
        String symbols = "!@#$%&";
        String values = Capital_chars + Lower_chars + numbers + symbols;
        String password = null;
        for(int i =0;i<length;i++){
            password = password + values.charAt(random.nextInt(values.length()));
        }
        return password;
    }
//change password method

    public void set_password() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password ? (Y/N)");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password: ");
                String tempv = s.next();
                if (tempv.equals(this.password)) {
                    System.out.println("Enter new password");
                    this.password = s.next();
                    System.out.println("Password changed !");
                } else {
                    System.out.println("Incorrect password");
                }

            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option canceled");
            } else {
                System.out.println("Enter vaild choice");
            }
        } while (!flag);


    }

    //set  mailbox capcity
    public void set_mailCap(){
        System.out.println("Current capcity= " + this.mailCap + " mb" );
        System.out.println("Enter new mailbox capacity:");
        this.mailCap = s.nextInt();
        System.out.println("Mailbox Capacity is successfully changed !");
    }
    //set alternate email
    public void alternate_email(){
        System.out.println("Enter new alternate email");
        this.alter_email = s.next();
        System.out.println("Alternate email is set");
    }

    //display user information

    public void get_info(){
        System.out.println("Name: " + this.fname + " " + this.lname);
        System.out.println("Department: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox Capacity: " + this.mailCap);
        System.out.println("Alternate Email: " + this.alter_email);
    }

    //store in file

    public void store_file_method(){
        try{
            FileWriter in = new FileWriter("/Users/natezeru/Desktop/Email Admin Project/info.txt");
            in.write("First Name: " + this.fname);
            in.append("\nLast Name: " + this.lname);
            in.append("\n Email: " + this.email);
            in.append("\n Password: " + this.password);
            in.append("\n Mail Capacity: " + this.mailCap);
            in.append("\n Alternate Mail: " + this.alter_email);
            in.close();
            System.out.println("Data stored !");
        }catch (Exception e){
            System.out.println(e);
        }
    }


    //read file method

    public void read_file(){
        try{
            FileReader fr = new FileReader("/Users/natezeru/Desktop/Email Admin Project/info.txt");
            int i;
            while ((i = fr.read()) !=-1){
                System.out.print((char) i);
            }

            fr.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
