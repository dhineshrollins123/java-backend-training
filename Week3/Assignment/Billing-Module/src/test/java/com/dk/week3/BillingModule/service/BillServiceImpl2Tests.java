package com.dk.week3.BillingModule.service;


import com.dk.week3.BillingModule.domain.BillGeneration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class BillServiceImpl2Tests {

    @DisplayName("Testing Method Find By Name")
    @Test
    void testFindByName() {
        List<BillGeneration> bill = new ArrayList<>();

        BillGeneration object = new BillGeneration();
        for (int i = 0; i < bill.size(); i++) {
            object = bill.get(i);
        }
        var obj = new BillGeneration();
        obj.setAPatientName("Sangi");
        bill.contains("sangi");
        Assertions.assertNotEquals(obj.getAPatientName(), object.getAPatientName());

    }
}
