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
import java.util.List;
import java.util.Optional;


@Transactional(
        isolation= Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = InvalidAmountException.class
)

@Service
public class BankServiceImpl implements BankService {

private final Logger logger= LoggerFactory.getLogger(BankServiceImpl.class);
    @Autowired
    private BankRepository repository;
    @Override
    public void createNewAccount(BankAccount ba) {
        repository.save(ba);
    }

    @Override
    public int updateAccountDetails(BankAccount ba) {
        return 0;
    }

    @Override
    public boolean activateAccount(Long acNum) {
        return false;
    }

    @Override
    public boolean deActivateAccount(Long acNum) {
        return false;
    }

    @Override
    public double withdraw(Long acNum, double amt) {
        logger.info("Withdrawing Money from "+acNum+" with Amount "+amt);
        logger.warn("Make Sure Amount Positive ");
        repository.withdraw(amt,acNum);
        return amt;
    }

    @Override
    public double deposit(Long acNum, double amt) throws InvalidAmountException {
        if(amt<=0) throw new InvalidAmountException("Amount Should be Non zero positive "+amt);
        Optional<BankAccount> op=repository.findById(acNum);
        BankAccount baOld=op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance + amt;

        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);

//        withdraw(acNum, 10);

        return baNew.getBalance();
    }

    @Override
    public int transferMoney(Long srcAc, Long dstAc, double amt) {
        return 0;
    }

    @Override
    public BankAccount findAccountByAcNum(Long acNum) {
        return null;
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        return null;
    }

    @Override
    public List<BankAccount> namesStartsWith(String prefix) {
        return repository.findByAcHldNmStartingWith(prefix);
    }
}
