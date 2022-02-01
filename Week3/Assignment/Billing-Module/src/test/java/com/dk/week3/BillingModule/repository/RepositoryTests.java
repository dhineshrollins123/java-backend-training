package com.dk.week3.BillingModule.repository;


import com.dk.week3.BillingModule.dataobject.BillGenerationDto;
import com.dk.week3.BillingModule.domain.BillGeneration;
import com.dk.week3.BillingModule.service.BillService2;
import com.dk.week3.BillingModule.service.BillServiceImpl2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTests {

    @MockBean
    private BillRepository repository;

    @DisplayName("Testing Repository Query 1")
    @Test
    public void testBillGen() {

        repository.save(new BillGeneration(100,
                "yogesh",
                LocalDate.of(1921,12,12),
                "Typhoid",
                null,null,5000.22));
    }

    @DisplayName("Testing Repository Query 2")
    @Test
    public void testFindByName(){
        String expected="dhinesh";
Mockito.when(repository.findByaPatientName("dhinesh"))
        .thenReturn(Stream.of(new BillGeneration(121,
        "dhinesh",
        LocalDate.of(2121,12,12),
        "Covid",
        null,null,2121.22)).collect(Collectors.toList()));
         List<BillGeneration> b2 =repository.findByaPatientName("dhinesh");
        boolean b= b2.isEmpty();
        Assertions.assertEquals(false,b);
        Assertions.assertEquals(expected,b2.get(0).getAPatientName());

    }

    @DisplayName("Testing Repository Query 3")
    @Test
    public void testBillAmountMoreThanGiven() {
        Mockito.when(repository.billAmountMoreThanGivenAmount(8000))
                .thenReturn(Stream.of(new BillGeneration(121,
                        "dhinesh",
                        LocalDate.of(2121,12,12),
                        "Covid",
                        null,null,12000.22),new BillGeneration(122,
                        "vasanth",
                        LocalDate.of(2021,12,12),
                        "Dengue",
                        null,null,7000.22)).collect(Collectors.toList()));
       List<BillGeneration> bill = repository.billAmountMoreThanGivenAmount(8000.00);
        Assertions.assertEquals(2,bill.size());
        Assertions.assertNotNull(bill);

    }


}
