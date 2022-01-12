package com.springjdbc.OperationsJDBC.domain;

import java.sql.Date;

public class Emp {
    private int id;
    private String name;
    private Date dob;
    private boolean isManager;
    public Emp() {
    }

    public Emp(int id, String name, String dob, Boolean isManager) {
        this.id = id;
        this.name = name;
        this.dob = Date.valueOf(dob);
        this.isManager = isManager;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean getManager() {
        return isManager;
    }

    public void setManager(boolean manager) {
        isManager = manager;
    }
}
