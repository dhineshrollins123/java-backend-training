package com.springjdbc.OperationsJDBC.control;

import com.springjdbc.OperationsJDBC.domain.Emp;
import com.springjdbc.OperationsJDBC.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping(value = "/v2")
    public String saveV2(@RequestBody Emp emp){
        service.saveOpV2(emp);
        return "Employee Saved...";
    }
    @GetMapping
    public @ResponseBody
    List<Emp> employees(){
        return service.findEmployees();
    }
}
