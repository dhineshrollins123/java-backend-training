package com.springjdbc.OperationsJDBC.control;

import com.springjdbc.OperationsJDBC.domain.Emp;
import com.springjdbc.OperationsJDBC.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/db")
@RestController
public class DbController {
    @Autowired
    private DbService service;
    @PostMapping
    public String save(@RequestBody Emp emp){
        service.saveOperation(
                emp.getId(),
                emp.getName(),
                emp.getDob(),
                emp.getManager());
        return "Employee Saved";
    }
}
