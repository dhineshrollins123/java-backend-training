package com.dk.week3.BillingModule.repository;


import com.dk.week3.BillingModule.domain.BillGeneration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTests {

    @Autowired
    private BillRepository repository;

    @DisplayName("Testing Repository Query 1")
    @Test
    public void testBillGen() {

        repository.save(new BillGeneration());
    }


    @DisplayName("Testing Repository Query 2")
    @Test
    public void testBillAmountMoreThanGiven() {
        List<BillGeneration> bill = repository.billAmountMoreThanGivenAmount(20000.00);

        Assertions.assertNotNull(bill);

    }


}
