package com.dk.week3.BillingModule.service;

import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
import com.dk.week3.BillingModule.domain.BillGeneration;

import java.util.List;
import java.util.Map;

public interface BillService1 {
     BillGenerationDto createNewBill(BillGenerationDto data);
     BillGenerationDto updateBill(BillGenerationDto data);
     boolean markBillPaid(Integer patientId);
     List<BillGenerationDto> allBills();
     List<Map<String, Integer>> findTreatmentWiseAmount();
}
