package Banksystem;

import java.sql.*;
import java.util.Scanner;

public class UserAccounts {
    private final Connection connection;

    public UserAccounts(Connection connection) {
        this.connection = connection;
    }

    Scanner scanner = new Scanner(System.in);

    public int creatingUserAccounts(long account_number, String acc_holder_name, Date acc_creation_date, boolean isActive, double balance, double current_send_account, double current_received_account) throws SQLException {
        String sql = "insert into employee values(?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1, account_number);
        ps.setString(2, acc_holder_name);
        ps.setDate(3, acc_creation_date);
        ps.setBoolean(4, isActive);
        ps.setDouble(5, balance);
        ps.setDouble(6, current_send_account);
        ps.setDouble(7, current_received_account);
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

    public int transferMoney(long account_number) throws SQLException {
        String sql3 = "update employee set balance=balance-4000 where account_number=? ";
        PreparedStatement ps = connection.prepareStatement(sql3);
        ps.setDouble(1, account_number);
        int affected = ps.executeUpdate();
        System.out.println("Money Transferred Sucessfully...");
        connection.commit();
        return affected;
    }

    public void withdrawAmount(long account_number, String acc_holder_name, Date acc_creation_date, boolean isActive, double balance, double currently_send_amount) throws SQLException {

        var sql1 = "insert into employee values(?,?,?,?,?,?,?)";
        var ps = connection.prepareStatement(sql1);
        ps.setLong(1, account_number);
        ps.setString(2, acc_holder_name);
        ps.setDate(3, acc_creation_date);
        ps.setBoolean(4, isActive);
        ps.setDouble(5, balance);
        ps.setDouble(6, currently_send_amount);
        double currently_received_amount = 0;
        ps.setDouble(7, currently_received_amount);
        var affect1 = ps.executeUpdate();
        connection.commit();
        var sql2 = "update employee set balance=balance-currently_send_amount where account_number=?";
        PreparedStatement ps1 = connection.prepareStatement(sql2);
        ps1.setLong(1, account_number);

        var affect2 = ps1.executeUpdate();
        if (affect2 == 0) {
            connection.rollback();
            System.out.println("Transaction Failed");
        } else {
            connection.commit();
            System.out.println("Transaction Completed Sucessfully...");
        }
    }

    public void depositAmount(long account_number, String acc_holder_name, Date acc_creation_date, boolean isActive, double balance, double currently_received_amount) throws SQLException {
        var sql1 = "insert into employee values(?,?,?,?,?,?,?)";
        var ps = connection.prepareStatement(sql1);
        ps.setLong(1, account_number);
        ps.setString(2, acc_holder_name);
        ps.setDate(3, acc_creation_date);
        ps.setBoolean(4, isActive);
        ps.setDouble(5, balance);
        double currently_send_amount = 0;
        ps.setDouble(6, currently_send_amount);
        ps.setDouble(7, currently_received_amount);
        var affect1 = ps.executeUpdate();
        connection.commit();
        var sql2 = "update employee set balance=balance+currently_received_amount where account_number=?";
        PreparedStatement ps1 = connection.prepareStatement(sql2);
        ps1.setLong(1, account_number);
        var affect2 = ps1.executeUpdate();
        if (affect2 == 0) {
            connection.rollback();
            System.out.println("Transaction Failed");
        } else {
            connection.commit();
            System.out.println("Transaction Completed Sucessfully...");
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
