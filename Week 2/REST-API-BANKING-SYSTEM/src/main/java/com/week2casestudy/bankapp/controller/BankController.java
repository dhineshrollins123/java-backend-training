package com.week2casestudy.bankapp.controller;

import com.week2casestudy.bankapp.domain.BankAccount;
import com.week2casestudy.bankapp.dto.AppResponse;
import com.week2casestudy.bankapp.exception.InvalidAmountException;
import com.week2casestudy.bankapp.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/bank")
@RestController
public class BankController {
    private final Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private BankService service;

    @PostMapping
    public ResponseEntity<AppResponse<Integer>> createBankAccount(@RequestBody BankAccount data) {
        logger.info("Creating bank account");
        var response = new AppResponse<Integer>();
        service.createNewAccount(data);
        response.setMsg("Account Created Sucessfully");
        response.setSts("Sucess");
        response.setBody(0);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/withdraw")
    public ResponseEntity<AppResponse<Double>> withDrawMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.withdraw(ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("Money Withdrawn Sucessfully");
            response.setSts("Sucess");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("Fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/deposit")
    public ResponseEntity<AppResponse<Double>> deposit(@RequestBody BankAccount dk) {
        try {
            double amt = service.deposit(dk.getAcNum(), dk.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("Money Deposited Sucessfully");
            response.setSts("Sucess");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("Fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search/{prefix}")
    public ResponseEntity<AppResponse<List<BankAccount>>> accountsStartWith(@PathVariable String prefix) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("ACCOUNTS NAME STARTS WITH LIST");
        response.setSts("Success");
        response.setBody(service.namesStartsWith(prefix));
        return ResponseEntity.ok(response);
    }


    @GetMapping("/searching/{acNum}")
    public ResponseEntity<AppResponse<BankAccount>> findAccountByAccNum(@PathVariable Long acNum) {
        var response = new AppResponse<BankAccount>();
        response.setMsg("ACCOUNTS SEARCH BY ID");
        response.setSts("Success");
        response.setBody(service.findAccountByAcNum(acNum));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/allaccounts")
    public ResponseEntity<AppResponse<List<BankAccount>>> findAllAccounts() {
        var response = new AppResponse<List<BankAccount>>();
        var ls = new ArrayList<BankAccount>();
        response.setMsg("ALl ACCOUNTS HAS BEEN DISPLAYED");
        response.setBody(service.findAllBankAccounts());
        response.setSts("Success...");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public BankAccount updateData(@RequestBody BankAccount data) {
        return service.updateAccountDetails(data);
    }

    @DeleteMapping("/delete/{acNum}")
    public String deleteBankAccount(@PathVariable Long acNum) {
        return service.deleteBankAccount(acNum);
    }

    @PutMapping("/activate_account/{acNum}")

    public ResponseEntity<AppResponse<Boolean>> activateAccount(@PathVariable Long acNum) {
        var response = new AppResponse<Boolean>();
        response.setMsg("FOR ACCOUNT ACTIVATION");
        response.setBody(service.activateAccount(acNum));
        response.setSts("Success...");
        return ResponseEntity.ok(response);
    }


    @PutMapping("/deactivate_account/{acNum}")

    public ResponseEntity<AppResponse<Boolean>> deActivateAccount(@PathVariable Long acNum) {
        var response = new AppResponse<Boolean>();
        response.setMsg("FOR ACCOUNT DEACTIVATION");
        response.setBody(service.deActivateAccount(acNum));
        response.setSts("Success...");
        return ResponseEntity.ok(response);
    }


}
