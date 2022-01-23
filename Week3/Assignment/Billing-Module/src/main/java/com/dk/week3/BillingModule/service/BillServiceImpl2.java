package com.dk.week3.BillingModule.service;

import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
import com.dk.week3.BillingModule.domain.BillGeneration;
import com.dk.week3.BillingModule.exceptions.BillNotFoundException;
import com.dk.week3.BillingModule.exceptions.BillsNotFoundByTreatmentException;
import com.dk.week3.BillingModule.exceptions.NoSuchPaidBillsInDatesException;
import com.dk.week3.BillingModule.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = BillNotFoundException.class
)
@Service
public class BillServiceImpl2 implements BillService2 {

    @Autowired
    private BillRepository repository2;


    @Override
    public List<BillGenerationDto> billsFindByName(String name) {
        var object = repository2.findByNameStarting(name);
        if (object.isEmpty()) {
            throw new BillNotFoundException("Bills Not Found Searched By this Name : " + name);
        }

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

    @Override
    public List<BillGenerationDto> billsFindByDates(String date) {

        var object = repository2.findPaidBillsByDates(date);

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
        boolean bool=bills.isEmpty();
        if(bool==true) throw new NoSuchPaidBillsInDatesException("Paid Bills Not Found Searched By this Date : " + date);
        return bills;
    }

    @Override
    public List<BillGenerationDto> findUnpaidBillsByTreatment(String treatment) {
        var object = repository2.findUnpaidBillsByTreatment(treatment);
        if (object==null)
            throw new BillsNotFoundByTreatmentException("UnPaid Bills Not Found Searched By this Treatment : " + treatment);

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

    @Override
    public List<BillGenerationDto> billAmountMoreThanGivenAmount(double amt) {
        var object = repository2.billAmountMoreThanGivenAmount(amt);

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

        boolean bool=bills.isEmpty();
        if(bool==true)
            throw new BillNotFoundException("Bills Not Found Searched By Amount : "+amt);
        return bills;
    }
}


