package com.dk.week3.BillingModule.service;

import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
import com.dk.week3.BillingModule.domain.BillGeneration;
import com.dk.week3.BillingModule.exceptions.BillNotFoundException;
import com.dk.week3.BillingModule.exceptions.CurrentlyNoBillsException;
import com.dk.week3.BillingModule.exceptions.PatientAlreadyPaidException;
import com.dk.week3.BillingModule.exceptions.PatientIdNotFoundException;
import com.dk.week3.BillingModule.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = BillNotFoundException.class
)
@Service
public class BillServiceImpl1 implements BillService1 {

    @Autowired
    private BillRepository repository1;


    @Override
    public BillGenerationDto createNewBill(BillGenerationDto data) {
        var bill = new BillGeneration();
        bill.setPatientId(data.getPatientId());
        bill.setAPatientName(data.getAPatientName());
        bill.setBillDate(data.getBillDate());
        bill.setPayAmount(data.getPayAmount());
        bill.setPaidDate(data.getPaidDate());
        bill.setTreatment(data.getTreatment());
        bill.setPaidStatus(data.getPaidStatus());
        repository1.save(bill);
        return data;
    }

    @Override
    public BillGenerationDto updateBill(BillGenerationDto data) {
        BillGeneration bill = new BillGeneration();
        bill.setPatientId(data.getPatientId());
        bill.setAPatientName(data.getAPatientName());
        bill.setBillDate(data.getBillDate());
        bill.setPayAmount(data.getPayAmount());
        bill.setPaidDate(data.getPaidDate());
        bill.setTreatment(data.getTreatment());
        bill.setPaidStatus(data.getPaidStatus());
        BillGeneration billGen = repository1.findById(bill.getPatientId())
                .orElseThrow(() ->
                        new PatientIdNotFoundException("Entered Patient ID is Wrong : " + bill.getPatientId()));
        billGen.setAPatientName(bill.getAPatientName());
        billGen.setBillDate(bill.getBillDate());
        billGen.setPayAmount(bill.getPayAmount());
        billGen.setPaidDate(bill.getPaidDate());
        billGen.setTreatment(bill.getTreatment());
        billGen.setPaidStatus(bill.getPaidStatus());
        repository1.save(billGen);
        return data;
    }

    @Override
    public boolean markBillPaid(Integer patientId) {
        BillGeneration bill = repository1.findById(patientId)
                .orElseThrow(() ->
                        new PatientIdNotFoundException("Entered Patient ID is Wrong " + patientId));
        boolean existStatus = bill.getPaidStatus();
        if (existStatus == true) throw new PatientAlreadyPaidException("Entered Patient ID is Already Paid");
        else {
            bill.setPaidStatus(true);
            return bill.getPaidStatus();
        }
    }

    @Override
    public List<Map<String, Integer>> findTreatmentWiseAmount() {

        if(repository1.findTreatmentwiseAmountData()==null)
            throw new BillNotFoundException("Bill Not Found");

        return repository1.findTreatmentwiseAmountData();
    }

    @Override
    public List<BillGenerationDto> allBills() {
        var object = repository1.findAll();

        if (object == null) throw new CurrentlyNoBillsException("Right Now.....NO Bills Are Here...");

        List<BillGenerationDto> bills = new ArrayList<>();
        for (int i = 0; i < object.size(); i++) {
            BillGeneration bill = object.get(i);
            BillGenerationDto obj = new BillGenerationDto(
                    bill.getPatientId(),
                    bill.getAPatientName(),
                    bill.getBillDate(),
                    bill.getTreatment(),
                    bill.getPaidDate(),
                    bill.getPaidStatus(),
                    bill.getPayAmount()
            );
            bills.add(obj);
        }
        return bills;
    }


}

