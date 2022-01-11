package Banksystem;

import java.sql.*;
import java.util.Scanner;

public class UserAccounts {
    private final Connection connection;
    private String name;
    private String email;
    private long contact;
    private String password;
    private long acc_num1;
    private long acc_num2;
    private double bal;
    public boolean isVerification = false;

    public UserAccounts(Connection connection) {
        this.connection = connection;
    }

    Scanner scanner = new Scanner(System.in);

    public int signUp() throws SQLException {
        System.out.println("--------------------------------------");
        System.out.println("ENTER SIGNUP DETAILS >>>>\n");
        //scanner.nextLine();
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
            String sql = "insert into admin(name,emailId,contact,password)values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, this.name);
            ps.setString(2, this.email);
            ps.setLong(3, this.contact);
            ps.setString(4, this.password);
            int row_affected = ps.executeUpdate();
            System.out.println("\nYour SignUp Process Has Been Done...\n");
            System.out.println("\n=====================================");
            connection.commit();
            return row_affected;
        } else {
            System.out.println("\n Please Enter 10 Digit Mobile Number ^^^\n");
        }
        return 0;
    }

    public int adminLogin() throws SQLException {

        System.out.println("--------------------------------------");
        System.out.println("ENTER LOGIN DETAILS >>>>\n");
        System.out.println("Enter Your Mobile Number : ");
        long con = scanner.nextLong();
        scanner.nextLine();
        var sql = "select contact from admin where contact=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        // ps.setInt(1, (int) con);
        ps.setLong(1, con);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            long cont = rs.getLong(1);
            this.contact = cont;
        }
        if (contact != con) {
            rs.close();
            connection.rollback();
            System.out.println("\n\t\tPlease Enter Registered Number...");
            return 0;

        }
        System.out.println("Enter Your Password : ");
        String pwd = scanner.nextLine();
        var sql1 = "select password from admin where contact=?";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ps1.setLong(1, contact);
        ResultSet rs1 = ps1.executeQuery();
        while (rs1.next()) {
            String pass = rs1.getString(1);
            this.password = pass;
        }
        if (password.equals(pwd)) {
            System.out.println(" \n\t\t * * * LOGIN SUCESSFULLY * * *\n");
            String sql3 = "insert into login values (?,?)";
            PreparedStatement ps3 = connection.prepareStatement(sql3);
            ps3.setLong(1, contact);
            ps3.setString(2, password);
            int affected1 = ps3.executeUpdate();
            connection.commit();
        } else {
            connection.rollback();
            System.out.println("\n\t\t Please Enter Registered password...");
            return 0;
        }
        isVerification = true;
        return 1;
    }

    public int creatingUserAccounts(long account_number, String acc_holder_name, Date acc_creation_date, boolean isActive, double balance) throws SQLException {
        String sql = "insert into employee values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, account_number);
        ps.setString(2, acc_holder_name);
        ps.setDate(3, acc_creation_date);
        ps.setBoolean(4, isActive);
        ps.setDouble(5, balance);
        int row_affected = ps.executeUpdate();
        System.out.println("Account Created Sucessfully...\n");
        connection.commit();
        return row_affected;
    }

    public void displayAllAccounts() throws SQLException {
        String sql1 = "select * from employee";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ResultSet result = ps1.executeQuery();
        connection.commit();
        while (result.next()) {
            long acc_num = result.getLong(1);
            String acc_holder = result.getString(2);
            Date created_date = result.getDate(3);
            boolean isActive = result.getBoolean(4);
            double balance = result.getDouble(5);
            System.out.print("Account Number : " + acc_num + " $");
            System.out.print(" Account Holder Name : " + acc_holder + " $");
            System.out.print(" Account Created Date : " + created_date + " $");
            System.out.print(" Account Status : " + isActive + " $");
            System.out.print(" Account Balance : " + balance + "\n");
        }
        result.close();
    }

    public void displayBalance(long account_numb) throws SQLException {
        String sql2 = "select acc_holder_name,balance from employee where account_number=?";
        PreparedStatement ps2 = connection.prepareStatement(sql2);
        ps2.setLong(1, account_numb);
        ResultSet result = ps2.executeQuery();
        connection.commit();
        while (result.next()) {
            String acc_holder = result.getString(1);
            double balance = result.getDouble(2);
            System.out.println("Account Holder Name : " + acc_holder);
            System.out.println("Account Balance : " + balance);
        }
        result.close();

    }

    public int transferMoney(int a, int b) throws SQLException {

        System.out.println("Enter Your Account Number :");
        long account_number1 = scanner.nextLong();
        String sql1 = "select account_number,balance from employee where account_number=?";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ps1.setLong(1, account_number1);
        ResultSet rs1 = ps1.executeQuery();
        while (rs1.next()) {
            acc_num1 = rs1.getLong(1);
        }
        if (account_number1 == acc_num1) {
            System.out.println("\n\t\tSender Account ID Verified Sucessfully");
        } else {
            System.out.println("\n\t\t Please Enter Correct Account Number");
            return 0;
        }
        System.out.println("How Much You Want to Send :");
        double amount = scanner.nextDouble();
        while (rs1.next()) {
            bal = rs1.getDouble("balance");
        }

        if (amount > bal) {
            System.out.println("Insufficient Balance...");
            connection.rollback();
            return 0;
        }
        System.out.println("Enter Receiver Account Number :");
        long account_number2 = scanner.nextLong();
        String sql2 = "select account_number from employee where account_number=?";
        PreparedStatement ps2 = connection.prepareStatement(sql2);
        ps2.setLong(1, account_number2);
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
            acc_num2 = rs2.getLong(1);
            return 0;
        }
        if (account_number2 == acc_num2) {
            System.out.println("\n\t\tReceiver Account ID Verified Sucessfully");
        } else {
            System.out.println("\n\t\t Please Enter Correct Account Number");
            return 0;
        }
        rs2.close();

        String sql3 = "update employee set balance=balance-" + amount + "where account_number=?";
        PreparedStatement ps3 = connection.prepareStatement(sql3);
        ps3.setDouble(1, account_number1);
        int affected1 = ps3.executeUpdate();
        String sql4 = "update employee set balance=balance+" + amount + "where account_number=? ";
        PreparedStatement ps4 = connection.prepareStatement(sql4);
        ps4.setDouble(1, account_number2);
        int affected2 = ps4.executeUpdate();
        System.out.println("Money Transferred Sucessfully...");

        connection.commit();
        return 1;
    }

    public void withdrawAmount(long account_num, double amount1) throws SQLException {
        System.out.println("Enter Your Account Number :");
        long account_number = scanner.nextLong();
        String sql1 = "select account_number,balance from employee where account_number=?";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ps1.setLong(1, account_number);
        ResultSet rs1 = ps1.executeQuery();
        while (rs1.next()) {
            acc_num1 = rs1.getLong(1);
        }
        System.out.println("Enter Withdrawl Amount :");
        double amount = scanner.nextDouble();
        var sql2 = "update employee set balance=balance-" + amount + "where account_number=?";
        PreparedStatement ps2 = connection.prepareStatement(sql2);
        ps2.setLong(1, account_number);
        var affect2 = ps2.executeUpdate();
        if (affect2 == 0) {
            connection.rollback();
            System.out.println("....Transaction Failed....");
        } else {
            connection.commit();
            System.out.println("\n\t\t*** Transaction Completed Sucessfully...***");
        }
    }

    public void depositAmount(long account_num, double amoun) throws SQLException {
        System.out.println("Enter Account Number :");
        long account_number = scanner.nextLong();
        String sql1 = "select account_number,balance from employee where account_number=?";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ps1.setLong(1, account_number);
        ResultSet rs1 = ps1.executeQuery();
        while (rs1.next()) {
            acc_num1 = rs1.getLong(1);
        }
        System.out.println("Enter Deposit Amount :");
        double amount = scanner.nextDouble();
        var sql2 = "update employee set balance=balance+" + amount + "where account_number=?";
        PreparedStatement ps2 = connection.prepareStatement(sql2);

        ps2.setLong(1, account_number);
        var affect2 = ps2.executeUpdate();
        if (affect2 == 0) {
            connection.rollback();
            System.out.println("Transaction Failed");
        } else {
            connection.commit();
            System.out.println("\n\t\t*** Transaction Completed Sucessfully...***");
        }
    }

    public void accountStatusChecking(long account_number) throws SQLException {
        var sql = "select account_number,isActive from employee where account_number=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, account_number);
        ResultSet result = ps.executeQuery();
        connection.commit();
        while (result.next()) {
            long acc_num = result.getLong(1);
            boolean isActive = result.getBoolean(2);
            System.out.println("Account Number : " + acc_num);
            System.out.println("Account Status : " + isActive);

        }
        result.close();
    }


}
