package com.springjdbc.OperationsJDBC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class DbService {
    @Autowired
    private JdbcTemplate template;
    public void saveOperation(int empId, String empName, Date dob, boolean isManager) {
        template.update(con -> {
            var sql="insert into emp_info values (?, ?, ? ,? )";
            var ps=con.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.setString(2, empName);
            ps.setDate(3, dob);
            ps.setBoolean(4, false);
            return ps;

        });
    }
   /* public void selectCars() {
template.execute(con -> {
    var sql="select * from emp_info";
    var ps=con.prepareStatement(sql);
    while(ps.next()){

    }
});
    }*/
}
