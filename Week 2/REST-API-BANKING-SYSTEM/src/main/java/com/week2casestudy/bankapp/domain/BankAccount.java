package com.week2casestudy.bankapp.domain;

import com.week2casestudy.bankapp.dto.AmountTransferDto;
import com.week2casestudy.bankapp.dto.AppResponse;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long acNum; // ac_num
    private String acHldNm;
    private Double balance;
    private Boolean status;
    private Date acCrDt;

    @OneToOne
    @JoinColumn(name = "user_ac_num")
    private AmountTransferDto user;

    public Long getAcNum() {
        return acNum;
    }

    public void setAcNum(Long acNum) {
        this.acNum = acNum;
    }

    public String getAcHldNm() {
        return acHldNm;
    }

    public void setAcHldNm(String acHldNm) {
        this.acHldNm = acHldNm;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getAcCrDt() {
        return acCrDt;
    }

    public void setAcCrDt(Date acCrDt) {
        this.acCrDt = acCrDt;
    }

    public Long getSrcAc() {
        AmountTransferDto ref=new AmountTransferDto();
        return ref.getSrcAc();
    }

    public Long getDstAc() {
        AmountTransferDto ref=new AmountTransferDto();
        return ref.getDstAc();
    }
}
