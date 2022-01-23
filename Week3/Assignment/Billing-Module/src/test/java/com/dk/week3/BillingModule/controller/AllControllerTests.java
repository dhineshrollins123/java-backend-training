package com.dk.week3.BillingModule.controller;

import com.dk.week3.BillingModule.dataobject.AppResponse;
import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
import com.dk.week3.BillingModule.domain.BillGeneration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AllControllerTests {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @DisplayName("Testing POST Method")
    @Test
    public void testPostMethod(){
        String url="http://"+"localhost"+":"+port+"/billcon1/create";
        var bill = new BillGenerationDto();
        bill.setPatientId(101);
        bill.setAPatientName("Dhinesh");
        bill.setBillDate(LocalDate.of(2021,12,12));
        bill.setPayAmount(15000.00);
        bill.setPaidDate(LocalDate.of(2021,12,15));
        bill.setTreatment("Covid");
        bill.setPaidStatus(true);
        var val=template.postForEntity(
                url,
                bill,
                AppResponse.class
        );
        Assertions.assertEquals(HttpStatus.OK,val.getStatusCode());

    }
    @DisplayName("Testing PUT Method")
    @Test
    public void testPutMethod(){
        BillGenerationDto obj=new BillGenerationDto();
        obj.setPatientId(101);
        String url="http://"+"localhost"+":"+port+"/billcon1/update";
        var bill = new BillGenerationDto();
        bill.setPatientId(101);
        bill.setAPatientName("Dhinesh");
        bill.setBillDate(LocalDate.of(2021,12,12));
        bill.setPayAmount(15000.00);
        bill.setPaidDate(LocalDate.of(2021,12,15));
        bill.setTreatment("Covid");
        bill.setPaidStatus(true);
        Assertions.assertEquals(101,bill.getPatientId());

    }

    @DisplayName("GET-Checking Object is Not Null")
    @Test
    public void testGetMethod(){
        String url="http://"+"localhost"+":"+port+"/billcon1/allbills";
        BillGenerationDto bill=template.getForObject(
                url,
                BillGenerationDto.class
        );
        Assertions.assertNotNull(bill);
    }

    @DisplayName("GET-Testing Object Content")
    @Test
    public void testObjectContent(){
        BillGenerationDto bill=new BillGenerationDto();
        bill.setPatientId(101);
        String url="http://"+"localhost"+":"+port+"/billcon1/allbills";
        var rev=template.getForEntity(
                url,
                BillGenerationDto.class
        );
        Assertions.assertEquals(101,bill.getPatientId());
    }

    @DisplayName("GET-Checking Status Code")
    @Test
    public void testStatusCode(){
        String url="http://"+"localhost"+":"+port+"/billcon1/allbills";
        ResponseEntity<BillGenerationDto> entity=template.getForEntity(
                url,
                BillGenerationDto.class
        );
        Assertions.assertEquals(
                HttpStatus.OK,
                entity.getStatusCode()
        );
    }
}
