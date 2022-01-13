package controller;

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

import java.util.List;

@RequestMapping("/bank")
@RestController
public class BankController {
    private final Logger logger= LoggerFactory.getLogger(BankController.class);
    @Autowired
    private BankService service;
@PostMapping
    public ResponseEntity<AppResponse<Integer>> createBankAccount(@RequestBody BankAccount ba){
    logger.info("Creating bank account");
    service.createNewAccount(ba);
        var response=new AppResponse<Integer>();
        response.setMsg("Account Created Sucessfully");
        response.setSts("Sucess");
        response.setBody(0);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/withdraw")
public ResponseEntity<AppResponse<Double>>withDrawMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.withdraw(ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("Money Withdrawn Sucessfully");
            response.setSts("Sucess");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch(InvalidAmountException e){
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("Fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/deposit")
    public ResponseEntity<AppResponse<Double>>deposit(@RequestBody BankAccount ba) {
        try {
            double amt = service.deposit(ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("Money Deposited Sucessfully");
            response.setSts("Sucess");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch(InvalidAmountException e){
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("Fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{prefix}")
    public ResponseEntity<AppResponse<List<BankAccount>>> accountsStartWith(@PathVariable String prefix) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account list");
        response.setSts("success");
        response.setBody(service.namesStartsWith(prefix));

        return ResponseEntity.ok(response);
    }


}
