package com.week2casestudy.bankapp.service;

import com.week2casestudy.bankapp.domain.BankAccount;
import com.week2casestudy.bankapp.exception.InvalidAmountException;
import com.week2casestudy.bankapp.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = InvalidAmountException.class
)

@Service
public class BankServiceImpl implements BankService {

    private final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);
    @Autowired
    private BankRepository repository;

    @Override
    public void createNewAccount(BankAccount data) {

        repository.save(data);
    }

    @Override
    public BankAccount updateAccountDetails(BankAccount data) {
        BankAccount oldData = repository.findById(data.getAcNum()).orElse(null);
        oldData.setAcHldNm(data.getAcHldNm());
        oldData.setAcCrDt(data.getAcCrDt());
        oldData.setStatus(data.getStatus());
        oldData.setBalance(data.getBalance());
        return repository.save(oldData);

    }

    Boolean temp;

    @Override
    public boolean activateAccount(Long acNum) throws NullPointerException {
      /*  Boolean verify = repository.findStatusTrue(acNum, acStatus);
        List<BankAccount> ref = new ArrayList<>();
        BankAccount account = new BankAccount();
        for (BankAccount reference : ref) {
            temp = reference.getStatus();
        }
        if (verify) {
            System.out.println("ACCOUNT ALREADY ACTIVATED");
            return false;
        } else {
            account.setStatus(true);
            System.out.println("ACCOUNT ACTIVATED SUCESSFULLY");
        }

        return false;*/

        Optional<BankAccount> option = repository.findById(acNum);
        BankAccount old = option.orElseThrow();
        boolean existStatus = old.getStatus();
       // if(existStatus==true) {
            BankAccount newacc = new BankAccount();
            newacc.setAcCrDt(old.getAcCrDt());
            newacc.setStatus(true);
            newacc.setAcHldNm(old.getAcHldNm());
            newacc.setAcNum(old.getAcNum());
            newacc.setBalance(old.getBalance());
            repository.save(newacc);
            return newacc.getStatus();
        }


    @Override
    public boolean deActivateAccount(Long acNum)throws NullPointerException {
        Optional<BankAccount> option = repository.findById(acNum);
        BankAccount old = option.orElseThrow();
        boolean existStatus = old.getStatus();
        BankAccount newacc = new BankAccount();
        newacc.setAcCrDt(old.getAcCrDt());
        newacc.setStatus(false);
        newacc.setAcHldNm(old.getAcHldNm());
        newacc.setAcNum(old.getAcNum());
        newacc.setBalance(old.getBalance());
        repository.save(newacc);
        return newacc.getStatus();
    }

    @Override
    public double withdraw(Long acNum, double amount) {
        logger.info("Withdrawing Money from " + acNum + " with Amount " + amount);
        if (amount <= 0)
        {
            throw new InvalidAmountException("Amount Should be Not ZERO and LESSER  " + amount);
        }
        Optional<BankAccount> option = repository.findById(acNum);
        BankAccount old = option.orElseThrow();
        double existingBalance = old.getBalance();
        double newBalance = existingBalance - amount;
        BankAccount newacc = new BankAccount();
        newacc.setBalance(newBalance);
        newacc.setAcCrDt(old.getAcCrDt());
        newacc.setStatus(old.getStatus());
        newacc.setAcHldNm(old.getAcHldNm());
        newacc.setAcNum(old.getAcNum());
        repository.save(newacc);
        return newacc.getBalance();
    }

    @Override
    public double deposit(Long acNum, double amount) throws InvalidAmountException {
        if (amount <= 0)
        {
            throw new InvalidAmountException("Amount Should be Not ZERO and LESSER  " + amount);
        }
        Optional<BankAccount> option = repository.findById(acNum);
        BankAccount old = option.orElseThrow();
        double existingBalance = old.getBalance();
        double newBalance = existingBalance + amount;
        BankAccount newacc = new BankAccount();
        newacc.setBalance(newBalance);
        newacc.setAcCrDt(old.getAcCrDt());
        newacc.setStatus(old.getStatus());
        newacc.setAcHldNm(old.getAcHldNm());
        newacc.setAcNum(old.getAcNum());
        repository.save(newacc);
        return newacc.getBalance();
    }

    @Override
    public int transferMoney(Long srcAc, Long dstAc, double amt) {
        return 0;
    }

    @Override
    public BankAccount findAccountByAcNum(Long acNum) {
        return repository.findById(acNum).get();
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        return repository.findAll();
    }

    @Override
    public List<BankAccount> namesStartsWith(String prefix) {
        return repository.findByAcHldNmStartingWith(prefix);
    }

    @Override
    public String deleteBankAccount(Long acNum) {
        repository.deleteById(acNum);
        return acNum + " ACCOUNT REMOVED SUCESSFULLY ";
    }
}
