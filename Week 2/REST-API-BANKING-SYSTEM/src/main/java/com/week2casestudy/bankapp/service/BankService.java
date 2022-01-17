package com.week2casestudy.bankapp.service;

import com.week2casestudy.bankapp.domain.BankAccount;

import java.util.List;

public interface BankService  {
    void createNewAccount(BankAccount data);//DONE
    BankAccount updateAccountDetails(BankAccount data);//DONE
    int transferMoney(Long srcAc,Long dstAc,double amt);
    BankAccount findAccountByAcNum(Long acNum);//DONE
    List<BankAccount> findAllBankAccounts();//DONE
    List<BankAccount> namesStartsWith(String prefix);//DONE
    String deleteBankAccount(Long acNum);//DONE
    boolean activateAccount(Long acNum);
    boolean deActivateAccount(Long acNum);
    double withdraw(Long acNum, double amount);
    double deposit(Long acNum,double amount);
}
