import Banksystem.UserAccounts;
import connectivity.Connectivity;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private String name;
    private String email;
    private long contact;
    private String password;
    boolean isVerification = false;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connectivity connectivity = new Connectivity();
        UserAccounts reference = new UserAccounts(connectivity.getConnection());
        Main main = new Main();
        boolean isTimer = true;

        System.out.println("\t\t====### Welcome To Banking System ###====\n");
        while (isTimer == true) {
            System.out.println(" \n\t* Select the Options Given Below \n");
            System.out.println("\t ENTER 1 : SIGNUP \n");
            System.out.println("\t ENTER 2 : ADMIN LOGIN \n");
            System.out.println("\t ENTER 3 : CREATE ACCOUNTS \n");
            System.out.println("\t ENTER 4 : SHOW ALL ACCOUNTS \n");
            System.out.println("\t ENTER 5 : TRANSFER MONEY \n");
            System.out.println("\t ENTER 6 : FOR WITHDRAWL \n");
            System.out.println("\t ENTER 7 : FOR DEPOSIT \n");
            System.out.println("\t ENTER 8 : ACCOUNT STATUS CHECKING \n");
            System.out.println("\t ENTER 9 : EXIT\n");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    main.signUp();
                    break;
                case 2:
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    main.adminLogin();
                    break;
                case 3:
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    if (main.isVerification) {
                        reference.creatingUserAccounts(434456789123L, "Likhitha", Date.valueOf(LocalDate.now()), true, 3000, 0, 0);
                    } else System.out.println("Please Login After Come Here...");
                    break;
                case 4:
                    if (main.isVerification) {
                        System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    } else System.out.println("Please Login After Come Here...");
                    reference.displayAllAccounts();
                    break;
                case 5:
                    if (main.isVerification) {
                        System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                        reference.transferMoney(781456789126L);
                    } else System.out.println("Please Login After Come Here...");

                    break;

                case 6:
                    if (main.isVerification) {
                        System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                        reference.withdrawAmount(781456789126L, "raja", Date.valueOf(LocalDate.now()), false, 10000, 3000);
                    } else System.out.println("Please Login After Come Here...");

                    break;
                case 7:
                    if (main.isVerification) {
                        System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                        reference.depositAmount(356456789126L, "karthik", Date.valueOf(LocalDate.now()), false, 10000, 3000);
                    } else System.out.println("Please Login After Come Here...");

                    break;
                case 8:
                    if (main.isVerification) {
                        System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                        reference.accountStatusChecking(789456789123L);
                    } else System.out.println("Please Login After Come Here...");

                    break;
                case 9:
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    System.out.println("\n\t** THANKS FOR VISITING US...COME AGAIN WELCOME...**");
                    isTimer = false;
                    break;
                default:
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    System.out.println("\n ! OOPS ....Please Enter Correct Option...\n");
                    break;
            }
        }
    }


    public void signUp() {
        scanner.nextLine();
        System.out.println("--------------------------------------");
        System.out.println("ENTER SIGNUP DETAILS >>>>\n");
        System.out.println("Enter Your Name : ");
        String name = scanner.nextLine();
        this.name = name;
        System.out.println("Enter Your Email-ID : ");
        String email = scanner.next();
        this.email = email;
        scanner.nextLine();
        System.out.println("Enter Your Contact No : ");
        long cont = scanner.nextLong();
        String num = Long.toString(cont);
        if (num.length() == 10) {
            this.contact = cont;
            scanner.nextLine();
            System.out.println("Enter Your Password : ");
            String pass = scanner.nextLine();
            this.password = pass;
            System.out.println("\n");
            System.out.println("Your SignUp Process Has Been Done...");
            System.out.println("\n=====================================");
        } else {
            System.out.println("\n Please Enter 10 Digit Mobile Number ^^^\n");
        }


    }


    public void adminLogin() {

        System.out.println("--------------------------------------");
        System.out.println("ENTER LOGIN DETAILS >>>>\n");
        System.out.println("Enter Your Mobile Number : ");
        long con = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter Your Password : ");
        String pwd = scanner.nextLine();
        if (this.contact == con) {
            if (this.password.equals(pwd)) {
                System.out.println(" \n * LOGIN SUCESSFULLY *\n");
                isVerification = true;
            } else {
                System.out.println("\n OOPS ! ....Please Enter Correct Password....\n");
            }
        } else {
            System.out.println("\n OOPS ! ...Please Enter Correct Mobile Number...or Do SIGN UP...\n");
        }
    }
}