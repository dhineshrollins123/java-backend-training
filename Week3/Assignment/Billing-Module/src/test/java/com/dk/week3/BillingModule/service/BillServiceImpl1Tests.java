package com.dk.week3.BillingModule.service;

import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
import com.dk.week3.BillingModule.domain.BillGeneration;
import com.dk.week3.BillingModule.repository.BillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class BillServiceImpl1Tests {

    @MockBean
    private BillRepository repository;

    @DisplayName("Testing Account Creation Method")
    @Test
    public void testCreateBill() {
        BillGeneration bill = new BillGeneration();
        bill.setPatientId(1);
        bill.setAPatientName("Dhinesh");
        bill.setBillDate(LocalDate.of(2021, 12, 12));
        bill.setPaidStatus(true);
        bill.setPayAmount(20000.00);
        bill.setPaidDate(LocalDate.of(2021, 12, 14));
        bill.setTreatment("Covid");
        repository.save(bill);
        Assertions.assertEquals(1, bill.getPatientId());
        Assertions.assertEquals("Dhinesh", bill.getAPatientName());
        Assertions.assertEquals(LocalDate.of(2021, 12, 12), bill.getBillDate());
        Assertions.assertEquals(true, bill.getPaidStatus());
        Assertions.assertEquals(LocalDate.of(2021, 12, 14), bill.getPaidDate());
        Assertions.assertEquals(20000.00, bill.getPayAmount());
        Assertions.assertEquals("Covid", bill.getTreatment());
    }


    @DisplayName("Testing MarkBills Method")
    @Test
    public void testMarkBill() {
        BillGenerationDto bill = new BillGenerationDto();
        bill.setPaidStatus(false);
        boolean existStatus = bill.getPaidStatus();
        Assertions.assertEquals(false, existStatus);
    }

    @DisplayName("Testing All Bills Method")
    @Test
    public void testAllBills() {
        List<BillGeneration> object = new ArrayList<>();
        List<BillGenerationDto> bills = new ArrayList<>();
        for (int i = 0; i < object.size(); i++) {
            BillGeneration bill = object.get(i);
            bill.setPatientId(2);
            bill.setAPatientName("Dhinesh");
            bill.setBillDate(LocalDate.of(2021, 12, 12));
            bill.setTreatment("Covid");
            bill.setPaidDate(LocalDate.of(2021, 12, 14));
            bill.setPaidStatus(true);
            bill.setPayAmount(15000.00);
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
        List<BillGeneration> bill= repository.findAll();
        Assertions.assertNotNull(bill);

    }

    @DisplayName("Testing Update Method")
    @Test
    public void testUpdateMethod() {
        BillGenerationDto obj = new BillGenerationDto();
        obj.setPatientId(42);
        var bill = new BillGenerationDto();
        bill.setPatientId(78);
        bill.setAPatientName("Dhinesh");
        bill.setBillDate(LocalDate.of(2021, 12, 12));
        bill.setPayAmount(15000.00);
        bill.setPaidDate(LocalDate.of(2021, 12, 15));
        bill.setTreatment("Covid");
        bill.setPaidStatus(true);
        Assertions.assertEquals(78, bill.getPatientId());
    }
}