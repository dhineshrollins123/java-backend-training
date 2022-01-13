import Banksystem.UserAccounts;
import connectivity.Connectivity;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public Main() throws SQLException, ClassNotFoundException {

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        boolean isTimer = true;
        Connectivity connectivity = new Connectivity();
        Main main = new Main();
        UserAccounts reference = new UserAccounts(connectivity.getConnection());
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
                    reference.signUp();
                    break;
                case 2:
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    reference.adminLogin();
                    break;
                case 3:
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    if (reference.isVerification) {
                        System.out.println("\nEnter Account Number : ");
                        long account_num = scanner.nextLong();
                        scanner.nextLine();
                        System.out.println("\nEnter Account Holder Name : ");
                        String account_hol_name = scanner.nextLine();
                        System.out.println("\nEnter Current Balance : ");
                        double balance = scanner.nextDouble();
                        reference.creatingUserAccounts(account_num, account_hol_name, Date.valueOf(LocalDate.now()), true, balance);
                    } else System.out.println("Please Login After Come Here...");
                    break;
                case 4:
                    if (reference.isVerification) {
                        System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    } else System.out.println("Please Login After Come Here...");
                    reference.displayAllAccounts();
                    break;
                case 5:
                    // if (main.isVerification) {
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    reference.transferMoney(123, 456);
                    //  } else System.out.println("Please Login After Come Here...");

                    break;

                case 6:
                    if (reference.isVerification) {
                        System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                        reference.withdrawAmount(781456789126L, 0);
                    } else System.out.println("Please Login After Come Here...");

                    break;
                case 7:
                    if (reference.isVerification) {
                        System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                        reference.depositAmount(356456789126L, 0);
                    } else System.out.println("Please Login After Come Here...");

                    break;
                case 8:
                    if (reference.isVerification) {
                        System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                        System.out.println("\n Enter Account Number For Status Checking : ");
                        long status = scanner.nextLong();
                        reference.accountStatusChecking(status);
                    } else System.out.println("Please Login After Come Here...");

                    break;
                case 9:
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    System.out.println("\n\t** THANKS FOR VISITING US...COME AGAIN WELCOME...**");
                    isTimer = false;
                    break;
                default:
                    System.out.println("\n YOU SELECTED OPTION :" + option + "\n");
                    System.out.println("\n\t\t ! OOPS ....Please Enter Correct Option...\n");
                    break;
            }
        }
    }


}