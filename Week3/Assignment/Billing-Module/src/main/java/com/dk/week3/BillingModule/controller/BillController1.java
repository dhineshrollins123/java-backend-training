package com.dk.week3.BillingModule.controller;

import com.dk.week3.BillingModule.dataobject.AppResponse;
import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
import com.dk.week3.BillingModule.exceptions.BillNotFoundException;
import com.dk.week3.BillingModule.exceptions.PatientAlreadyPaidException;
import com.dk.week3.BillingModule.exceptions.PatientIdNotFoundException;
import com.dk.week3.BillingModule.service.BillService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/billcon1")
@RestController
public class BillController1 {


    @Autowired
    private BillService1 service1;


    @PostMapping("/create")
    public ResponseEntity<AppResponse<Integer>> createNewBill(@Valid @RequestBody BillGenerationDto data) {
        var response = new AppResponse<Integer>();
        service1.createNewBill(data);
        response.setMessage("Bill Created Sucessfully");
        response.setBody(1);
        response.setStatus("Sucess");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<AppResponse<BillGenerationDto>> updateBills(@Valid @RequestBody BillGenerationDto data) {
        try {
            var response = new AppResponse<BillGenerationDto>();
            response.setBody(service1.updateBill(data));
            response.setMessage("Bill Updated Sucessfully");
            response.setStatus("Sucess");
            return ResponseEntity.ok(response);
        } catch (PatientIdNotFoundException e) {
            var response = new AppResponse<Boolean>();
            response.setBody(false);
            response.setMessage(e.getMessage());
            response.setStatus("Failed");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/markbillpaid/{patientId}")
    public ResponseEntity<AppResponse<Boolean>> markBillPaid(@PathVariable Integer patientId) {
        try {
            var response = new AppResponse<Boolean>();
            response.setBody(service1.markBillPaid(patientId));
            response.setMessage("Marked as Bill Paid Sucessfully");
            response.setStatus("Success");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (PatientAlreadyPaidException e) {
            var response = new AppResponse<Boolean>();
            response.setBody(false);
            response.setMessage(e.getMessage());
            response.setStatus("Failed");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allbills")
    public ResponseEntity<AppResponse<List<BillGenerationDto>>> listAllBills() {
        var response = new AppResponse<List<BillGenerationDto>>();
        response.setBody(service1.allBills());
        response.setMessage("All Bills are Shown Sucessfully");
        response.setStatus("Success");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/treatmentbills")
    public ResponseEntity<AppResponse<List<Map<String,Integer>>>>findTreatmentWiseAmount(){
        try {
            var response =new AppResponse<List<Map<String,Integer>>>();
            response.setBody(service1.findTreatmentWiseAmount());
            response.setMessage("Treatment Wise Bills Shown Sucessfully");
            response.setStatus("Sucess");
            return ResponseEntity.ok(response);
        } catch (BillNotFoundException e) {
            var response = new AppResponse<Boolean>();
            response.setBody(false);
            response.setMessage(e.getMessage());
            response.setStatus("Failed");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> messages = new HashMap<>();

        List<ObjectError> errors = ex.getBindingResult().getAllErrors();

        for (ObjectError objerr : errors) {
            FieldError fielerr = (FieldError) objerr;

            String errorField = fielerr.getField();
            String errorMessage = fielerr.getDefaultMessage();

            messages.put(errorField, errorMessage);
        }

        return messages;
    }
}
