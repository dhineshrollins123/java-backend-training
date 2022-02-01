package com.dk.week3.BillingModule.controller;


import com.dk.week3.BillingModule.dataobject.AppResponse;
import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
import com.dk.week3.BillingModule.exceptions.BillNotFoundException;
import com.dk.week3.BillingModule.exceptions.BillsNotFoundByTreatmentException;
import com.dk.week3.BillingModule.exceptions.NoSuchPaidBillsInDatesException;
import com.dk.week3.BillingModule.service.BillService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;


@RequestMapping("/billcon2")
@RestController
public class BillController2 {

    @Autowired
    private BillService2 service2;

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<AppResponse<List<BillGenerationDto>>> billsFindByName(@PathVariable String name) {
        try {
            var response = new AppResponse<List<BillGenerationDto>>();
            response.setBody(service2.billsFindByName(name));
            response.setMessage(" Bills are Shown By Name Sucessfully");
            response.setStatus("Success");
            return ResponseEntity.ok(response);
        } catch (BillNotFoundException e) {
            var response = new AppResponse<Boolean>();
            response.setBody(false);
            response.setMessage(e.getMessage());
            response.setStatus("Failed");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbydate/{date}")
    public ResponseEntity<AppResponse<List<BillGenerationDto>>> billsFindByDate(@PathVariable String date) {
        try {
            var response = new AppResponse<List<BillGenerationDto>>();
            response.setBody(service2.billsFindByDates(date));
            response.setMessage(" Paid Bills are Shown By Particular Date Sucessfully");
            response.setStatus("Success");
            return ResponseEntity.ok(response);
        } catch (NoSuchPaidBillsInDatesException e) {
            var response = new AppResponse<Boolean>();
            response.setBody(false);
            response.setMessage(e.getMessage());
            response.setStatus("Failed");
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search/{amt}")
    public ResponseEntity<AppResponse<List<BillGenerationDto>>> billSearching(@PathVariable double amt) {
        try {
            var response = new AppResponse<List<BillGenerationDto>>();
            response.setBody(service2.billAmountMoreThanGivenAmount(amt));
            response.setMessage("Bills are Shown By Amount More than "+ amt+" Sucessfully");
            response.setStatus("Success");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (BillNotFoundException e) {
            var response = new AppResponse<Boolean>();
            response.setBody(false);
            response.setMessage(e.getMessage());
            response.setStatus("Failed");
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/searching/{treatment}")
    public ResponseEntity<AppResponse<List<BillGenerationDto>>> unPaidBillSearchingByTreatment(@PathVariable String treatment) {
        try {
            var response = new AppResponse<List<BillGenerationDto>>();
            response.setBody(service2.findUnpaidBillsByTreatment(treatment));
            response.setMessage("UnPaid Bills are Shown By Treatment Sucessfully");
            response.setStatus("Success");
            return ResponseEntity.ok(response);
        } catch (BillsNotFoundByTreatmentException e) {
            var response = new AppResponse<Boolean>();
            response.setBody(false);
            response.setMessage(e.getMessage());
            response.setStatus("Failed");
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
    }
}
