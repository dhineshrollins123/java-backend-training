package com.springjdbc.OperationsJDBC;

import com.springjdbc.OperationsJDBC.service.DbService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class OperationsJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperationsJdbcApplication.class, args);
			/*	ApplicationContext ctx = SpringApplication.run(OperationsJdbcApplication.class, args);
	DbService service = ctx.getBean(DbService.class);
	service.saveOperation(123,"dhine", String.valueOf(12-02-1998),true);*/
	}

}
