package com.dk.week3.BillingModule.repository;

import com.dk.week3.BillingModule.domain.BillGeneration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface BillRepository extends JpaRepository<BillGeneration, Integer> {

    @Query(value = "select * from bill_generation where a_patient_name = :patientName", nativeQuery = true)
    List<BillGeneration> findByNameStarting(@Param("patientName") String patientName);

    @Query(value = "select * from bill_generation where paid_status=true and paid_date = :date", nativeQuery = true)
    List<BillGeneration> findPaidBillsByDates(@Param("date") String date);

    @Query(value = "select * from bill_generation where paid_status=false and treatment = :treatment", nativeQuery = true)
    List<BillGeneration> findUnpaidBillsByTreatment(@Param("treatment") String treatment);

    @Query(value = "select * from bill_generation where pay_amount > :amt", nativeQuery = true)
    List<BillGeneration> billAmountMoreThanGivenAmount(@Param("amt") double amt);

    @Query(value = "select treatment,sum(pay_amount) As TotalAmount from bill_generation Group By treatment", nativeQuery = true)
    List<Map<String,Integer>> findTreatmentwiseAmountData();

}
