package com.dk.week3.BillingModule.service;

import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
import com.dk.week3.BillingModule.domain.BillGeneration;
import java.time.LocalDate;
import java.util.List;

public interface BillService2 {
    List<BillGenerationDto> billsFindByName(String name);
    List<BillGenerationDto> billsFindByDates(String date);
    List<BillGenerationDto> findUnpaidBillsByTreatment(String treatment);
    List<BillGenerationDto> billAmountMoreThanGivenAmount(double amt);

}
