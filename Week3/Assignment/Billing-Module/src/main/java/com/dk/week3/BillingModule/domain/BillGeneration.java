package com.dk.week3.BillingModule.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class BillGeneration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patientId;

    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String aPatientName;

    @NotNull
    @Column(nullable = false)
    private LocalDate billDate;


    @NotNull
    @Column(nullable = true)
    private String treatment;

    @Column(nullable = true)
    private LocalDate paidDate;

    @Column(nullable = false)
    private Boolean paidStatus;


    @NotNull
    @Column(nullable = false)
    private Double payAmount;
}
