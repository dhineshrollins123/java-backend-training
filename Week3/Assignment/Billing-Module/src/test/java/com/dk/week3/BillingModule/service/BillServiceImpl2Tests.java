package com.dk.week3.BillingModule.service;
import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
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
       BillGenerationDto b=new BillGenerationDto("Sangi");
        b.setAPatientName("Sangi");
        List<BillGenerationDto> bill= new ArrayList<>();
         bill.add(b);
        String expected= "Sangi";
        Assertions.assertEquals(expected,bill.get(0).getAPatientName());
        boolean check = bill.contains(b);
        Assertions.assertEquals(true,check);
    }
}
